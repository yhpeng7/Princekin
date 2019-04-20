package com.yhklsdf.lib_common.base

import org.greenrobot.eventbus.EventBus

abstract class BasePresenter<M : IModel, V : IView> : IPresenter<V> {

    protected var mModel: M? = null
    protected var mView: V? = null

    private val isViewAttach: Boolean
        get() = mView != null

    /**
     * 创建Model
     */
    open fun createModel() : M? = null

    open fun useEventBus() : Boolean = false

    override fun attachView(mView: V) {
        this.mView = mView
        this.mModel = createModel()
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
    }

    override fun detachView() {
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
            mModel?.onDetach()
            mModel = null
            mView = null
        }
    }
}