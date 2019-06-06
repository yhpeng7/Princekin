package com.yhklsdf.lib_common.module.dialog;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.home.adapter.TimerAdapter;
import com.yhklsdf.lib_common.module.home.item.BackGroundView;

//签到弹窗
//现在先这么用着,如果之后需要传入数据可以改构造方法或者是直接让Dialog从本地读取
@Route(path = "/home/check_in")
public class CheckInDialog extends AppCompatDialog {
    private int hundred;
    private int ten;
    private int single;
    private int exceed = 99;
    private String time = "2019/5/18";
    private BackGroundView imgv_dialog_checkin_background;
    private ImageButton btn_dialog_checkin_cancel;
    private Button btn_dialog_checkin_check;
    private TextView txtv_dialog_checkin_time;
    private TextView txtv_dialog_checkin_exceed;
    private RecyclerView recycler_dialog_checkin_hundred;
    private RecyclerView recycler_dialog_checkin_ten;
    private RecyclerView recycler_dialog_checkin_single;
    private Context mContext;

    public CheckInDialog(Context context) {
        super(context);
        this.mContext = context;
        initView();
        initData();
    }

    public CheckInDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
        initView();
        initData();
    }

    private void initData() {
        txtv_dialog_checkin_time.setText(time);
        txtv_dialog_checkin_exceed.setText("超越" + exceed + "%的同校同学");
    }

    private void initView() {
        setContentView(R.layout.home_dialog_checkin);
        btn_dialog_checkin_cancel = findViewById(R.id.home_imgbtn_dialog_cancel);
        btn_dialog_checkin_check = findViewById(R.id.home_btn_dialog_checkin_check);
        txtv_dialog_checkin_time = findViewById(R.id.home_txtv_dialog_checkin_time);
        txtv_dialog_checkin_exceed = findViewById(R.id.home_txtv_dialog_checkin_exceed);
        recycler_dialog_checkin_hundred = findViewById(R.id.home_recycler_dialog_hundred);
        recycler_dialog_checkin_ten = findViewById(R.id.home_recycler_dialog_ten);
        recycler_dialog_checkin_single = findViewById(R.id.home_recycler_dialog_single);
        imgv_dialog_checkin_background = findViewById(R.id.home_imgv_dialog_background);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TimerAdapter hundredAdapter = new TimerAdapter(mContext);
        TimerAdapter tenAdapter = new TimerAdapter(mContext);
        TimerAdapter singleAdapter = new TimerAdapter(mContext);
        recycler_dialog_checkin_hundred.setAdapter(hundredAdapter);
        recycler_dialog_checkin_hundred.setLayoutManager(new LinearLayoutManager(mContext) {
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller scroller = new LinearSmoothScroller(recyclerView.getContext()) {

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return super.calculateSpeedPerPixel(displayMetrics) * 10;    //修改smoothScroll时间
                    }
                };
                scroller.setTargetPosition(position);
                startSmoothScroll(scroller);
            }
        });
        recycler_dialog_checkin_ten.setAdapter(tenAdapter);
        recycler_dialog_checkin_ten.setLayoutManager(new LinearLayoutManager(mContext) {
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller scroller = new LinearSmoothScroller(recyclerView.getContext()) {
                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return super.calculateSpeedPerPixel(displayMetrics) * 10;
                    }
                };
                scroller.setTargetPosition(position);
                startSmoothScroll(scroller);
            }
        });
        recycler_dialog_checkin_single.setAdapter(singleAdapter);
        recycler_dialog_checkin_single.setLayoutManager(new LinearLayoutManager(mContext) {
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller scroller = new LinearSmoothScroller(recyclerView.getContext()) {

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return super.calculateSpeedPerPixel(displayMetrics) * 10;
                    }
                };
                scroller.setTargetPosition(position);
                startSmoothScroll(scroller);
            }
        });
        btn_dialog_checkin_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        btn_dialog_checkin_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
    }

    private void check() {
        single++;
        if (single >= 10) {
            ten++;
            single = 0;
        }
        if (ten >= 10) {
            hundred++;
            ten = 0;
        }
        recycler_dialog_checkin_hundred.smoothScrollToPosition(hundred);
        recycler_dialog_checkin_ten.smoothScrollToPosition(ten);
        recycler_dialog_checkin_single.smoothScrollToPosition(single);
    }
}
