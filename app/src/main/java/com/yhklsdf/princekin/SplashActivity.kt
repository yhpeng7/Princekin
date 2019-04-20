package com.yhklsdf.princekin

import android.content.Intent
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.yhklsdf.lib_common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private var alphaAnimation : AlphaAnimation? = null

    override fun attachLayoutRes() = R.layout.activity_splash

    override fun useEventBus() = false

    override fun initData() {
    }

    override fun initView() {
        alphaAnimation = AlphaAnimation(0.3F,1.0F)
        alphaAnimation?.run {
            duration = 2000
            setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    jumpToMain()
                }

                override fun onAnimationStart(animation: Animation?) {
                }

            })
        }
        activity_splash.startAnimation(alphaAnimation)
    }

    private fun jumpToMain() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
    }

    override fun start() {
    }

}
