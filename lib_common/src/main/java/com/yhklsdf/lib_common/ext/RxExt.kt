package com.yhklsdf.lib_common.ext

import com.yhklsdf.lib_common.app.BaseApplication
import com.yhklsdf.lib_common.base.IModel
import com.yhklsdf.lib_common.base.IView
import com.yhklsdf.lib_common.rx.SchedulerUtils
import com.yhklsdf.lib_common.utils.NetworkUtil
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.sr(
        model : IModel?,
        view : IView?,
        isShowLoading : Boolean = true,
        onSuccess : (T) -> Unit
) {
    val subscribe: Any = this.compose(SchedulerUtils.ioToMain())
            .subscribe(object : Observer<T> {
                override fun onComplete() {
                    view?.hideLoading()
                }

                override fun onSubscribe(d: Disposable) {
                    if (isShowLoading) {
                        view?.showLoading()
                    }
                    model?.addDisposable(d)
                    if (!NetworkUtil.isNetworkAvailable(BaseApplication.instance)) {
                        onComplete()
                    }
                }

                override fun onNext(t: T) {
                    onSuccess.invoke(t)
                }

                override fun onError(e: Throwable) {
                    view?.hideLoading()
                    //TODO 加网络错误处理类
                    view?.showError("好像出问题了呢！")
                }
            })
}