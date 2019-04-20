package com.yhklsdf.lib_common.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.yhklsdf.lib_common.constant.Constant
import com.yhklsdf.lib_common.event.NetworkChangeEvent
import com.yhklsdf.lib_common.utils.NetworkUtil
import com.yhklsdf.lib_common.utils.Preference
import org.greenrobot.eventbus.EventBus

class NetworkChangeReceiver : BroadcastReceiver() {

    private var hasNetwork : Boolean by Preference(Constant.HAS_NETWORK,true)

    override fun onReceive(context: Context, intent: Intent) {

        val isConnect = NetworkUtil.isNetworkConnect(context)
        if (isConnect) {
            if (isConnect != hasNetwork) {
                EventBus.getDefault().post(NetworkChangeEvent(isConnect))
            }
        } else {
            EventBus.getDefault().post(NetworkChangeEvent(isConnect))
        }
    }
}
