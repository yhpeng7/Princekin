package com.yhklsdf.module_home.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.bean.RankingBean
import kotlinx.android.synthetic.main.h_item_honor_ranking.view.*

class RankingAdapter(var dataList: List<RankingBean>) : RecyclerView.Adapter<RankingAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.h_item_honor_ranking, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.onBind(p1)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun onBind(index: Int) {
            var data = dataList[index]
            itemView.h_honor_tv_name.text = data.name
            itemView.h_honor_tv_institute.text = data.institute
            itemView.h_honor_tv_point.text = "1280"
            itemView.h_honor_tv_achievement.text = data.type + data.company
            if (data.type == "就业") {
                itemView.h_honor_tv_fraction.text = "年薪" + data.salary
            } else {
                itemView.h_honor_tv_fraction.text = data.salary + "被录取"
            }
        }
    }
}