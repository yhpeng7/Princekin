package com.yhklsdf.module_home.adapter

import android.content.Context
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yhklsdf.lib_common.utils.ImageLoader
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.bean.HighDynamicBean

class RVHighDynamicAdapter(private val context: Context?, data: MutableList<HighDynamicBean>) :
        BaseQuickAdapter<HighDynamicBean,BaseViewHolder>(R.layout.h_item_high_dynamic,data) {
    override fun convert(helper: BaseViewHolder?, item: HighDynamicBean?) {

        helper ?: return
        item ?: return
        helper.setText(R.id.h_tv_high_dynamic_1, item.jName)
        helper.setText(R.id.h_tv_high_dynamic_2, item.cName)
        helper.setText(R.id.h_tv_high_dynamic_3, item.description)
        helper.setText(R.id.h_tv_high_dynamic_4, item.pay)
        ImageLoader.load(context!!,item.logo,helper.getView(R.id.h_iv_high_dynamic))
    }
}