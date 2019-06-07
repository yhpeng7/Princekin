package com.yhklsdf.module_home.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.bean.MessageBean
import kotlinx.android.synthetic.main.h_item_honor_message.view.*

class MessageAdapter(var dataList: List<MessageBean>) : RecyclerView.Adapter<MessageAdapter.Holder>() {
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.onBind(p1)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.h_item_honor_message, p0, false)
        return Holder(view)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun onBind(index: Int) {
            var data = dataList[index]
            itemView.h_tv_job_details_name.text = data.name
            itemView.h_tv_job_details_institute.text = data.institute
            itemView.h_tv_job_details_achievement.text = data.type + data.company
            if (data.type == "就业") {
                itemView.h_tv_job_details_fraction.text = "年薪" + data.salary
            } else {
                itemView.h_tv_job_details_fraction.text = data.salary + "被录取"
            }
            itemView.h_tv_job_details_summary.text = data.message
        }
    }
}