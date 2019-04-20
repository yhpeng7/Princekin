package com.yhklsdf.lib_common.rx

import com.yhklsdf.lib_common.rx.scheduler.IoMainScheduler

object SchedulerUtils {
    fun <T> ioToMain(): IoMainScheduler<T> = IoMainScheduler()
}