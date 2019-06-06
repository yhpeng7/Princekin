package com.yhklsdf.lib_common.module;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.yhklsdf.lib_common.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@Route(path = "/common/search")
public class SearchActivity extends AppCompatActivity {
    private ImageView lib_imgv_search_back;
    private TextView lib_txtv_search_cancel;
    private SearchView lib_srchv_search;
    private ConstraintLayout lib_constraint_search_containner;
    private ConstraintLayout lib_constraint_search_curtain;
    private HistoryFragment mHistoryFragment;
    private ResultFragment mResultFragment;
    private FragmentManager mFragmentManager;
    private SearchView.SearchAutoComplete mSrcTextView;
    private SharedPreferences mHistoryPreferences;
    private SharedPreferences.Editor mEditor;
    private List<String> mHistoryList;
    private String[] tempData = {"EPI实验室", "书法协会", "校青协", "手机爱好者俱乐部", "腾讯", "大学生创新创业协会", "花粥的歌", "大学生艺术团"};
    //测试数据
    private List<String> resultList;
    private Gson mGson;

    public void setSearchContent(String content) {
        lib_srchv_search.setFocusable(true);
        mSrcTextView.setText(content);
    }

    public void onSearch(String content) {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                addHistory(content);
                //完成操作并且跳转
                emitter.onNext("跳转");
            }
        });
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(SearchActivity.this, s, Toast.LENGTH_SHORT).show();
                        performCancel();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (!TextUtils.isEmpty(mSrcTextView.getText())) {
            performCancel();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_activity_search);
        mGson = new Gson();
        initView();
        initData();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.lib_constraint_search_containner, mHistoryFragment);   //第一次运行先显示搜索历史Fragment
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveHistoryToPreference();
    }

    private void initData(){
        getHistoryFromPreference();
        mHistoryFragment.setHistory(mHistoryList);
    }

    private void initView() {
        lib_srchv_search = findViewById(R.id.home_linear_post_graduate);
        lib_imgv_search_back = findViewById(R.id.home_imgbtn_recruit_back);
        lib_txtv_search_cancel = findViewById(R.id.home_txtv_post_graduate_cancel);
        lib_constraint_search_containner = findViewById(R.id.lib_constraint_search_containner); //放置Fragment的位置
        lib_constraint_search_curtain = findViewById(R.id.lib_constraint_search_curtain);   //一个覆盖全局的加载圈
        mHistoryPreferences = getSharedPreferences("History", MODE_PRIVATE);
        mEditor = mHistoryPreferences.edit();
        mFragmentManager = getSupportFragmentManager();
        mHistoryFragment = new HistoryFragment();
        mResultFragment = new ResultFragment();
        lib_txtv_search_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCancel();
            }
        });
        lib_srchv_search.findViewById(android.support.v7.appcompat.R.id.search_plate).setBackgroundColor(Color.TRANSPARENT);
        lib_srchv_search.findViewById(android.support.v7.appcompat.R.id.search_close_btn).setClickable(false);
        mSrcTextView = lib_srchv_search.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        mSrcTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        lib_srchv_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("CheckResult")
            @Override
            public boolean onQueryTextSubmit(String query) {    //点击提交按钮
                if (TextUtils.isEmpty(query)) {
                    lib_srchv_search.clearFocus();
                } else {
                    Observable.interval(1, TimeUnit.SECONDS)
                            .take(1)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<Long>() {
                                @Override
                                public void accept(Long aLong) throws Exception {
                                    getResultFromServer(query);
                                    //向服务器发送请求并且从中获取搜索建议
                                    lib_constraint_search_curtain.setVisibility(View.GONE);
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    throwable.printStackTrace();
                                }
                            });
                }
                return false;
            }

            @SuppressLint("CheckResult")
            @Override
            public boolean onQueryTextChange(String newText) {  //搜索框内容变化
                if (TextUtils.isEmpty(newText)) {
                    changeToHistory();
                } else {
                    lib_constraint_search_curtain.setVisibility(View.VISIBLE);
                    Observable.interval(1, TimeUnit.SECONDS)
                            .take(1)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<Long>() {
                                @Override
                                public void accept(Long aLong) throws Exception {
                                    getResultFromServer(newText);
                                    //向服务器发送请求并且从中获取搜索建议
                                    lib_constraint_search_curtain.setVisibility(View.GONE);
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    throwable.printStackTrace();
                                }
                            });
                    changeToResult();
                }
                return false;
            }
        });
    }

    private void getResultFromServer(String string) {   //从服务器获取搜索历史(多线程)
        List<String> tempList = Arrays.asList(tempData);
        resultList = new ArrayList<String>(tempList);
        List<String> realResultList = new ArrayList<>();
        for (int i = 0; i < resultList.size(); i++) {
            String temp = resultList.get(i);
            if (temp.contains(string)) {
                realResultList.add(temp);
            }
        }
        mResultFragment.setResultData(realResultList);
    }

    private void changeToHistory() {    //切换到搜索历史
        mHistoryFragment.setHistory(mHistoryList);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.lib_constraint_search_containner, mHistoryFragment);
        transaction.commit();
    }

    private void changeToResult() {     //切换到搜索结果
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.lib_constraint_search_containner, mResultFragment);
        transaction.commit();
    }

    private void getHistoryFromPreference() {   //从SharedPreference获取搜索历史
        if (mHistoryList == null) {
            String strJson = mHistoryPreferences.getString("History_Json", null);    //获取存入的Json数据
            if (strJson != null) {
                String[] temp = mGson.fromJson(strJson, String[].class);
                List<String> tempList = Arrays.asList(temp);
                mHistoryList = new ArrayList<>(tempList); //将Json数据解析为List
            } else {
                mHistoryList = new ArrayList<>();
            }
        }
    }

    private void saveHistoryToPreference(){
        String jsonString = mGson.toJson(mHistoryList);
        mEditor.putString("History_Json",jsonString);
        mEditor.commit();
    }


    private void performCancel() {  //执行SearchView初始化
        lib_srchv_search.setFocusable(false);
        lib_srchv_search.clearFocus();
        mSrcTextView.setText("");
    }

    private void addHistory(String content) {   //判断是否要添加搜索历史
        boolean isAdd = true;   //判断搜索历史中是否有这一条
        int pointer = 0;        //当搜索记录存在时用于标记
        for (int i = 0; i < mHistoryList.size(); i++) {
            if (content.equals(mHistoryList.get(i))) {
                isAdd = false;
                pointer = i;
            }
        }
        if (isAdd) {  //如果需要添加就判断有没有超出10个
            if (mHistoryList.size() >= 10) {    //如果超过10个
                List<String> buffer = new ArrayList<>();
                buffer.add(content);
                for (int i = 0; i < 9; i++) {
                    buffer.add(mHistoryList.get(i));
                }
                mHistoryList.clear();
                for (int i = 0; i < buffer.size(); i++) {
                    mHistoryList.add(buffer.get(i));
                }
            } else {    //不超10个直接添加
                mHistoryList.add(content);
            }
        } else {    //不添加说明搜索记录存在,前移搜索记录
            List<String> buffer = new ArrayList<>();
            buffer.add(content);
            int min = mHistoryList.size() > 10 ? 10 : mHistoryList.size();
            for (int i = 0; i < min; i++) {
                if (i != pointer)
                    buffer.add(mHistoryList.get(i));
            }
            mHistoryList.clear();
            for (int i = 0; i < min; i++) {
                mHistoryList.add(buffer.get(i));
            }
        }
    }
}
