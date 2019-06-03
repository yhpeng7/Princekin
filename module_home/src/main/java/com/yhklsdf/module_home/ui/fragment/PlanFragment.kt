package com.yhklsdf.module_home.ui.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.yhklsdf.lib_common.base.BaseFragment
import com.yhklsdf.lib_common.utils.ImageLoader
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.adapter.RVCompetitionAdapter
import com.yhklsdf.module_home.bean.CompetitionBean
import com.yhklsdf.module_home.bean.NewsBean
import com.yhklsdf.module_home.bean.TextBannerBean
import com.yhklsdf.module_home.ui.activity.HighDynamicActivity
import com.yhklsdf.module_home.ui.activity.JobDetailsActivity
import com.yhklsdf.module_home.ui.activity.SaBActivity
import com.yhklsdf.module_home.utils.GlideImageLoader
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.h_activity_job_details.*
import kotlinx.android.synthetic.main.h_fragment_plan.*
import org.jetbrains.anko.support.v4.startActivity

class PlanFragment : BaseFragment() {

    val images = mutableListOf(
            R.drawable.h_banner_0,
            R.drawable.h_banner_1
    )

    val textBanners = mutableListOf(
            TextBannerBean("校招", "腾讯招收50万年薪程序员", ""),
            TextBannerBean("春招", "阿里招收45万年薪程序员员员员员员员员员员员员员员员员员员员员员", ""),
            TextBannerBean("秋招", "头条招收百万年薪程序员", "")
    )

    val vp_items = mutableListOf(
            CompetitionBean(R.drawable.test_vp_1,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_2,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_3,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_2,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_3,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_1,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_2,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_3,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_1,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_3,"青年创新创业大赛","校创协/创新创业",""),
            CompetitionBean(R.drawable.test_vp_2,"青年创新创业大赛","校创协/创新创业","")
    )

    val news = mutableListOf(
            NewsBean(true,false,"学校宣布任命三名处级干部","西邮新闻网",7000,R.drawable.test_news_1,""),
            NewsBean(false,true,"我校师生收看纪念五四运动100周年大会实况","西邮新闻网",6875,R.drawable.test_news_2,""),
            NewsBean(false,false,"报名帖|促学风系列之西邮创业论坛---三节课创始人","西邮新闻网",7000,R.drawable.test_news_3,""),
            NewsBean(false,false,"学校宣布任命三名处级干部","西邮新闻网",7000,R.drawable.test_news_1,""),
            NewsBean(false,false,"我校师生收看纪念五四运动100周年大会实况","西邮新闻网",6875,R.drawable.test_news_2,""),
            NewsBean(false,false,"报名帖|促学风系列之西邮创业论坛---三节课创始人","西邮新闻网",7000,R.drawable.test_news_3,"")
    )

    override fun attachLayoutRes() = R.layout.h_fragment_plan

    override fun lazyLoad() {
    }

    @SuppressLint("InflateParams")
    override fun initView(view: View) {
        setOnClickListener()
        banner_home.setImages(images)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setImageLoader(GlideImageLoader())
                .isAutoPlay(true)
                .start()

        textBanners.forEach { t ->
            val itemView = layoutInflater.inflate(R.layout.h_item_view_flipper, null)
            val tag: TextView = itemView.findViewById(R.id.h_tv_2)
            val message: TextView = itemView.findViewById(R.id.h_tv_3)
            tag.text = t.tag
            message.text = t.messae
            h_view_flipper.addView(itemView)
        }
        h_view_flipper.setFlipInterval(2000)
        h_view_flipper.startFlipping()

        val manager = LinearLayoutManager(activity)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        h_rv_1.layoutManager = manager
        h_rv_1.adapter = RVCompetitionAdapter(vp_items)

        news.forEach { t ->
            val itemView = layoutInflater.inflate(R.layout.h_item_home_news,h_job_details_container_2,false)
            if(t == news[0]){
                val view : View = itemView.findViewById(R.id.h_view4)
                view.visibility = View.GONE
            }
            val stick : TextView = itemView.findViewById(R.id.h_news_stick)
            val title : TextView = itemView.findViewById(R.id.h_news_title)
            val source : TextView = itemView.findViewById(R.id.h_news_sourse)
            val pageView : TextView = itemView.findViewById(R.id.h_news_pageview)
            val image : ImageView = itemView.findViewById(R.id.h_news_image)
            when {
                t.isStick -> stick.text = "置顶"
                t.isHot -> stick.text = "热门"
                else -> stick.visibility = View.GONE
            }
            title.text = t.title
            source.text = t.source
            pageView.text = t.pageView.toString()
            ImageLoader.load(activity!!,t.image,image)
            h_news_container.addView(itemView)
        }
    }

    private fun setOnClickListener() {
        h_home_plan_tv_0.setOnClickListener { startActivity(Intent(activity, HighDynamicActivity::class.java)) }

        h_view_flipper.setOnClickListener { startActivity(Intent(activity, JobDetailsActivity::class.java)) }

        h_home_plan_iv_5.setOnClickListener { startActivity(Intent(activity, SaBActivity::class.java)) }
    }

    private fun initData() {
    }
}