package com.yhklsdf.module_course.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class AllCourseItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public AllCourseItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)
            outRect.bottom = spacing / 2; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}