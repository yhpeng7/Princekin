package com.yhklsdf.module_home.ui.activity

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.content.Intent
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.onekeyshare.OnekeyShare
import cn.sharesdk.tencent.qq.QQ
import cn.sharesdk.wechat.friends.Wechat
import cn.sharesdk.wechat.utils.WXMediaMessage
import cn.sharesdk.wechat.utils.WXTextObject
import com.yhklsdf.lib_common.base.BaseSwipeBackActivity
import com.yhklsdf.lib_common.utils.AnimatorUtil
import com.yhklsdf.lib_common.utils.CustomPopWindow
import com.yhklsdf.lib_common.utils.ImageLoader
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.bean.AlumnusInfoBean
import kotlinx.android.synthetic.main.h_activity_job_details.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor

class JobDetailsActivity : BaseSwipeBackActivity() {

    var mCustomPopWindow: CustomPopWindow? = null
    val sp by lazy { Platform.ShareParams() }
    val qqPlatform by lazy{ ShareSDK.getPlatform(QQ.NAME) }
    val weChatPlatform by lazy{ ShareSDK.getPlatform(Wechat.NAME) }

    var isCollect: Boolean = false

    val alumnusList = listOf(
            AlumnusInfoBean(R.drawable.test_job_head_1, "黄飞鸿", 2016, "电子工程学院", "黄飞鸿，毕业于西安邮电大学电子工程学院。曾就任校科协主席、荣获过2015年国家奖学金。于2016年被腾讯招作JAVA实习生，并与2016年末正式签约入职"),
            AlumnusInfoBean(R.drawable.test_job_head_2, "黄飞鸿", 2016, "电子工程学院", "黄飞鸿，毕业于西安邮电大学电子工程学院。曾就任校科协主席、荣获过2015年国家奖学金。于2016年被腾讯招作JAVA实习生，并与2016年末正式签约入职"),
            AlumnusInfoBean(R.drawable.test_job_head_2, "黄飞鸿", 2016, "电子工程学院", "黄飞鸿，毕业于西安邮电大学电子工程学院。曾就任校科协主席、荣获过2015年国家奖学金。于2016年被腾讯招作JAVA实习生，并与2016年末正式签约入职"),
            AlumnusInfoBean(R.drawable.test_job_head_2, "黄飞鸿", 2016, "电子工程学院", "黄飞鸿，毕业于西安邮电大学电子工程学院。曾就任校科协主席、荣获过2015年国家奖学金。于2016年被腾讯招作JAVA实习生，并与2016年末正式签约入职"),
            AlumnusInfoBean(R.drawable.test_job_head_2, "黄飞鸿", 2016, "电子工程学院", "黄飞鸿，毕业于西安邮电大学电子工程学院。曾就任校科协主席、荣获过2015年国家奖学金。于2016年被腾讯招作JAVA实习生，并与2016年末正式签约入职"))

    override fun attachLayoutRes() = R.layout.h_activity_job_details

    override fun initData() {

    }

    @SuppressLint("InflateParams")
    override fun initView() {
        setClickListener()

        alumnusList.forEach { t ->
            val alumnusView = layoutInflater.inflate(R.layout.h_item_job_alumnus, h_job_details_container_2, false)
            if (t == alumnusList[0]) {
                val separate: View = alumnusView.findViewById(R.id.h_view5)
                separate.visibility = View.GONE
            }
            val image: ImageView = alumnusView.findViewById(R.id.h_iv_job_details_2)
            val name: TextView = alumnusView.findViewById(R.id.h_tv_job_details_6)
            val gradle: TextView = alumnusView.findViewById(R.id.h_tv_job_details_7)
            val college: TextView = alumnusView.findViewById(R.id.h_tv_job_details_8)
            val experience: TextView = alumnusView.findViewById(R.id.h_tv_job_details_9)
            ImageLoader.load(this@JobDetailsActivity, t.image, image)
            name.text = t.name
            gradle.text = t.grade.toString().plus("级")
            college.text = t.college
            experience.text = t.experience
            h_job_details_container_2.addView(alumnusView)
        }
    }

    fun setClickListener() {
        h_btn_job_details_1.setOnClickListener {
            finish()
        }

        val shareView = layoutInflater.inflate(R.layout.h_job_share, null)
        shareView.findViewById<TextView>(R.id.h_tv_job_share).setOnClickListener {
            mCustomPopWindow?.dissmiss()
        }
        shareView.findViewById<ImageButton>(R.id.h_iv_job_share_3).setOnClickListener {
            sp.shareType = Platform.SHARE_TEXT
            sp.text = "欢迎使用星规划！"
            weChatPlatform.share(sp)
        }
        shareView.findViewById<ImageButton>(R.id.h_iv_job_share_4).setOnClickListener {
        }

        h_btn_job_details_2.setOnClickListener {
            mCustomPopWindow = CustomPopWindow.PopupWindowBuilder(this)
                    .setView(shareView)
                    .enableBackgroundDark(true)
                    .setBgDarkAlpha(0.7f)
                    .create()
                    .showAtLocation(contentView, Gravity.CENTER, 0, 0)
        }

        h_ly_job_info.setOnClickListener {
            startActivity(Intent(this@JobDetailsActivity,CompanyIntro::class.java))
        }

        h_btn_job_details_3.setOnClickListener {
            if (!isCollect) {
                h_btn_job_details_4.text = "已收藏"
                h_btn_job_details_4.textColor = Color.parseColor("#2D6FAA")
                h_btn_job_details_3.visibility = View.GONE
                h_btn_job_details_3.setImageResource(R.mipmap.job_details_5)
                isCollect = true
            } else {
                h_btn_job_details_4.text = "收藏"
                h_btn_job_details_4.textColor = Color.parseColor("#A1A1A1")
                h_btn_job_details_3.setImageResource(R.mipmap.job_details_4)
                isCollect = false
            }
        }
    }

    override fun start() {
    }
}
