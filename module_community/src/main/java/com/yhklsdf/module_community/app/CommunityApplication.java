package com.yhklsdf.module_community.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yhklsdf.lib_common.app.BaseApplication;

import org.litepal.LitePal;

public class CommunityApplication extends BaseApplication {
    @Override
    public void onCreate () {
        super.onCreate();
        initARouter();
        initLitePal();
    }

    @Override
    protected void attachBaseContext (Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initLitePal(){
        LitePal.initialize(this);
    }

    private void initARouter() {
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();    // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this);
    }
}
