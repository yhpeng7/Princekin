package com.yhklsdf.lib_common.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseModel : IModel,LifecycleObserver{
    /**
     * CompositeDisposable类:可以快速解除所有添加的Disposable类 每当我们得到一个Disposable时就调用CompositeDisposable.add()将它添加到容器中, 在退出的时候, 调用CompositeDisposable.clear() 即可快速解除
     */
    private var compositeDisposable : CompositeDisposable? = null

    override fun addDisposable(disposable: Disposable?) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        disposable?.let { compositeDisposable?.add(it) }
    }

    override fun onDetach() {
        compositeDisposable?.clear()
        compositeDisposable = null
    }

    //模块可见
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    internal fun onDestroy(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}