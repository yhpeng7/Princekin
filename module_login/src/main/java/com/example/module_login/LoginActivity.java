package com.example.module_login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.yhklsdf.lib_common.utils.KeyBoardUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_cancel).setOnClickListener(this::onClick);
        findViewById(R.id.tv_register).setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.tv_register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else if (id==R.id.tv_cancel) {
            finish();
        }
    }

    /**
     * 点击空白处 隐藏键盘
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            View v = getCurrentFocus();
            if (KeyBoardUtil.isHideKeyboard(v,ev)) {
                KeyBoardUtil.hideKeyBoard(this,v);
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
