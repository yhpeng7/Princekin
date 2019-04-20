package com.yhklsdf.lib_common.base

/**
 * in --- 消费类型为T的值
 */
interface IPresenter <in V : IView>{

    /**
     * 绑定View
     */
    fun attachView(mView : V)

    /**
     * 解绑View
     */
    fun detachView()
}