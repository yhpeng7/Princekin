package com.yhklsdf.lib_common.base

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import com.noober.background.BackgroundLibrary
import com.yhklsdf.lib_common.constant.Constant
import com.yhklsdf.lib_common.event.NetworkChangeEvent
import com.yhklsdf.lib_common.receiver.NetworkChangeReceiver
import com.yhklsdf.lib_common.utils.KeyBoardUtil
import com.yhklsdf.lib_common.utils.Preference
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity() {

    /**
     * 检查登录
     */
    protected var isLogin : Boolean by Preference(Constant.LOGIN_KEY, false)

    /**
     * 缓存上一次的网络状态
     */
    protected var hasNetwork: Boolean by Preference(Constant.HAS_NETWORK, true)

    /**
     * 网络状态变化的广播
     */
    protected var mNetworkChangeReceiver : NetworkChangeReceiver? = null

    /**
     * 布局文件id
     */
    protected abstract fun attachLayoutRes() : Int

    /**
     * 是否使用EventBus
     */
    open fun useEventBus() : Boolean = true

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 开始请求
     */
    abstract fun start()

    override fun onCreate(savedInstanceState: Bundle?) {
        BackgroundLibrary.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(attachLayoutRes())
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        initData()
        initView()
        start()
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        start()
    }

    override fun onResume() {
        val filter = IntentFilter()
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        mNetworkChangeReceiver = NetworkChangeReceiver()
        registerReceiver(mNetworkChangeReceiver, filter)

        super.onResume()
    }

    override fun onPause() {
        if (mNetworkChangeReceiver != null) {
            unregisterReceiver(mNetworkChangeReceiver)
            mNetworkChangeReceiver = null
        }

        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNetworkChangeEvent(networkChangeEvent: NetworkChangeEvent) {
        hasNetwork = networkChangeEvent.isConnected
        checkNetwork(networkChangeEvent.isConnected)
    }

    private fun checkNetwork(connected: Boolean) {
        if (connected) {
            doReConnected()
        } else {
            toast("网络连接不可用，请检查网络设置！")
        }
    }

    private fun doReConnected() {
        start()
    }

    protected fun initToolbar(toolbar: Toolbar, homeAsUpEnabled: Boolean, title: String) {
        toolbar.title = title
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(homeAsUpEnabled)
    }

    /**
     * 点击空白处 隐藏键盘
     */
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_UP) {
            val v = currentFocus
            if (KeyBoardUtil.isHideKeyboard(v,ev)) {
                KeyBoardUtil.hideKeyBoard(this,v)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 处理菜单被选中运行后的事件处理
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            android.R.id.home ->{
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Fragment 逐个出栈
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}