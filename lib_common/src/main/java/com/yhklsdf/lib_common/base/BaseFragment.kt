package com.yhklsdf.lib_common.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhklsdf.lib_common.constant.Constant
import com.yhklsdf.lib_common.event.NetworkChangeEvent
import com.yhklsdf.lib_common.receiver.NetworkChangeReceiver
import com.yhklsdf.lib_common.utils.Preference
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseFragment : Fragment() {

    /**
     * 检查登录
     */
    protected var isLogin: Boolean by Preference(Constant.LOGIN_KEY, false)

    /**
     * 缓存上一次的网络状态
     */
    protected var hasNetwork: Boolean by Preference(Constant.HAS_NETWORK, true)

    /**
     * 网络状态变化的广播
     */
    protected var networkChangeReceiver: NetworkChangeReceiver? = null

    /**
     * 布局文件id
     */
    protected abstract fun attachLayoutRes(): Int

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false

    /**
     * 数据是否加载过了
     */
    private var hasLoadData = false

    /**
     * 是否使用EventBus
     */
    open fun useEventBus(): Boolean = true

    /**
     * 懒加载
     */
    abstract fun lazyLoad()

    /**
     * 初始化View
     */
    abstract fun initView(view: View)

    /**
     * 无网 -> 有网 状态的自动重连操作，子类可重写该方法
     */
    open fun doReConnected() {
        lazyLoad()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(attachLayoutRes(), null)
    }

    /**
     * Fragment 懒加载
     *
     * isVisibleToUser --- Fragment的UI是否对用户可见
     *
     * 1. onCreate方法后，onCreateView前执行
     * 2. 该方法只有Fragment在ViewPager里才会被调用
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepare()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        isViewPrepare = true
        initView(view)
        lazyLoadDataIfPrepare()
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        lazyLoadDataIfPrepare()
    }

    private fun lazyLoadDataIfPrepare() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNetworkChangeEvent(event: NetworkChangeEvent) {
        if (event.isConnected) {
            doReConnected()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }
}