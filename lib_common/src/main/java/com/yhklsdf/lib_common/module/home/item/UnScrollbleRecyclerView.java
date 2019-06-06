package com.yhklsdf.lib_common.module.home.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UnScrollbleRecyclerView extends RecyclerView {
    public UnScrollbleRecyclerView(@NonNull Context context) {
        super(context);
    }

    public UnScrollbleRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UnScrollbleRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) { //设置为不可被用户滚动
        return false;
    }
}
