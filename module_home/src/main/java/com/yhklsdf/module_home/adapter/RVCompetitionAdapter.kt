package com.yhklsdf.module_home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhklsdf.lib_common.utils.ImageLoader
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.bean.CompetitionBean
import kotlinx.android.synthetic.main.h_item_vp_competition.view.*

class RVCompetitionAdapter(val dataList : MutableList<CompetitionBean>): RecyclerView.Adapter<RVCompetitionAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.h_item_vp_competition, p0, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(dataList[p1])
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(bean: CompetitionBean) {
            itemView.h_tv_rv1_title.text = bean.title
            itemView.h_tv_rv1_category.text = bean.category
            ImageLoader.load(itemView.context,bean.image,itemView.h_iv_rv1_image)
        }
    }
}