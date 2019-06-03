package com.yhklsdf.module_home.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yhklsdf.lib_common.utils.ImageLoader
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.bean.SaBBean

class RVSaBAdapter(private val context: Context?,data : MutableList<SaBBean>) :
        BaseQuickAdapter<SaBBean,BaseViewHolder>(R.layout.h_item_start_a_business,data){
    override fun convert(helper: BaseViewHolder?, item: SaBBean?) {

        helper ?: return
        item ?: return

        helper.setText(R.id.h_sab_tv_1, item.name)
        helper.setText(R.id.h_sab_tv_2, item.identity)
        helper.setText(R.id.h_sab_tv_3, item.speak)
        helper.setText(R.id.h_sab_tv_4, item.date)
        ImageLoader.load(context!!,item.header,helper.getView(R.id.h_sab_iv))
    }
}