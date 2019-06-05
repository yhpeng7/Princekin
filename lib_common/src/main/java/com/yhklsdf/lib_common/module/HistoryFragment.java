package com.yhklsdf.lib_common.module;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yhklsdf.lib_common.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HistoryFragment extends Fragment implements View.OnClickListener {
    private LinearLayout lib_linear_search_hot_containner;
    private TextView lib_txtv_search_history_1;
    private TextView lib_txtv_search_history_2;
    private TextView lib_txtv_search_history_3;
    private TextView lib_txtv_search_history_4;
    private TextView lib_txtv_search_history_5;
    private TextView lib_txtv_search_history_6;
    private TextView lib_txtv_search_history_7;
    private TextView lib_txtv_search_history_8;
    private TextView lib_txtv_search_history_9;
    private TextView lib_txtv_search_history_10;
    private ImageView lib_imgv_search_history_divider;
    private List<TextView> mTextViewList;
    private List<String> mHistoryList;
    private SearchActivity mSearchActivity; //丑陋的回调,不过现在没想到什么好方法

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lib_fragment_history, container, false);
        initView(view);
        initData(view);
        return view;
    }

    private void initView(View view) {
        lib_linear_search_hot_containner = view.findViewById(R.id.lib_linear_history_hot_containner);
        lib_txtv_search_history_1 = view.findViewById(R.id.lib_txtv_search_history_1);
        lib_txtv_search_history_2 = view.findViewById(R.id.lib_txtv_search_history_2);
        lib_txtv_search_history_3 = view.findViewById(R.id.lib_txtv_search_history_3);
        lib_txtv_search_history_4 = view.findViewById(R.id.lib_txtv_search_history_4);
        lib_txtv_search_history_5 = view.findViewById(R.id.lib_txtv_search_history_5);
        lib_txtv_search_history_6 = view.findViewById(R.id.lib_txtv_search_history_6);
        lib_txtv_search_history_7 = view.findViewById(R.id.lib_txtv_search_history_7);
        lib_txtv_search_history_8 = view.findViewById(R.id.lib_txtv_search_history_8);
        lib_txtv_search_history_9 = view.findViewById(R.id.lib_txtv_search_history_9);
        lib_txtv_search_history_10 = view.findViewById(R.id.lib_txtv_search_history_10);
        mTextViewList = new ArrayList<>();
        lib_txtv_search_history_1.setOnClickListener(this);
        lib_txtv_search_history_2.setOnClickListener(this);
        lib_txtv_search_history_3.setOnClickListener(this);
        lib_txtv_search_history_4.setOnClickListener(this);
        lib_txtv_search_history_5.setOnClickListener(this);
        lib_txtv_search_history_6.setOnClickListener(this);
        lib_txtv_search_history_7.setOnClickListener(this);
        lib_txtv_search_history_8.setOnClickListener(this);
        lib_txtv_search_history_9.setOnClickListener(this);
        lib_txtv_search_history_10.setOnClickListener(this);
        mTextViewList.add(lib_txtv_search_history_1);
        mTextViewList.add(lib_txtv_search_history_2);
        mTextViewList.add(lib_txtv_search_history_3);
        mTextViewList.add(lib_txtv_search_history_4);
        mTextViewList.add(lib_txtv_search_history_5);
        mTextViewList.add(lib_txtv_search_history_6);
        mTextViewList.add(lib_txtv_search_history_7);
        mTextViewList.add(lib_txtv_search_history_8);
        mTextViewList.add(lib_txtv_search_history_9);
        mTextViewList.add(lib_txtv_search_history_10);
    }

    private void initData(View view) {
        mSearchActivity = (SearchActivity) getActivity();
        Observable<List<String>> observable = Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                //向服务器请求并且获取热搜
                String hot1 = new String("EPI实验室");
                String hot2 = new String("书法协会");
                String hot3 = new String("校青协");
                List<String> tempList = new ArrayList<>();
                tempList.add(hot1);
                tempList.add(hot2);
                tempList.add(hot3);
                tempList.add(hot1);
                tempList.add(hot2);
                tempList.add(hot3);
                emitter.onNext(tempList);
            }
        });
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> stringList) throws Exception {
                        LayoutInflater inflater = getLayoutInflater();
                        LinearLayout linear_history = null;
                        int min = stringList.size() < 5 ? stringList.size() : 5;
                        for (int i = 0; i < stringList.size(); i++) {
                            switch (i) {
                                case 0:
                                    linear_history = view.findViewById(R.id.lib_search_hot_0);
                                    break;
                                case 1:
                                    linear_history = view.findViewById(R.id.lib_search_hot_1);
                                    break;
                                case 2:
                                    linear_history = view.findViewById(R.id.lib_search_hot_2);
                                    break;
                                case 3:
                                    linear_history = view.findViewById(R.id.lib_search_hot_3);
                                    break;
                                case 4:
                                    linear_history = view.findViewById(R.id.lib_search_hot_4);
                                    break;
                            }
                            final int point = i;
                            if (linear_history != null) {
                                linear_history.setVisibility(View.VISIBLE);
                                linear_history.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        mSearchActivity.setSearchContent(stringList.get(point));
                                    }
                                });
                                TextView textView = linear_history.findViewById(R.id.lib_txtv_history_hot);
                                //在绘制前判断textView行数是否大于1
                                //如果大于1则说明textView被压缩,则不显示(不绘制)
                                textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                                    @Override
                                    public boolean onPreDraw() {
                                        if (textView.getLineCount() > 1) {
                                            textView.setVisibility(View.GONE);
                                        }
                                        textView.getViewTreeObserver().removeOnPreDrawListener(this);
                                        return false;
                                    }
                                });
                                if (textView.getLineCount() > 1) {
                                    linear_history.setVisibility(View.GONE);
                                    break;
                                }
                                textView.setText(stringList.get(i));
                            }
                        }
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        showHistory();
    }

    private void showHistory() {
        ConstraintSet constraintSet = new ConstraintSet();
        if (mHistoryList != null) {
            int count = mHistoryList.size();
            TextView temp = null;
            for (int i = 0; i < count; i++) {
                temp = mTextViewList.get(i);
                temp.setVisibility(View.VISIBLE);
                temp.setText(mHistoryList.get(i));
            }
//            if (temp != null) {
//                //设置Divider分割线的高度
//                constraintSet.connect(lib_imgv_search_history_divider.getId(), ConstraintSet.BOTTOM, temp.getId(), ConstraintSet.BOTTOM);
//                lib_imgv_search_history_divider.invalidate();
//            }
            for (int i = count; i < mTextViewList.size(); i++) {
                temp = mTextViewList.get(i);
                temp.setVisibility(View.INVISIBLE);
            }
        } else {
            for (int i = 0; i < mTextViewList.size(); i++) {
                TextView temp = mTextViewList.get(i);
                temp.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void setHistory(List<String> historyList) {   //设置搜索历史并且初始化布局
        this.mHistoryList = historyList;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.lib_txtv_search_history_1) {
            mSearchActivity.setSearchContent(mHistoryList.get(0));
        } else if (i == R.id.lib_txtv_search_history_2) {
            mSearchActivity.setSearchContent(mHistoryList.get(1));
        } else if (i == R.id.lib_txtv_search_history_3) {
            mSearchActivity.setSearchContent(mHistoryList.get(2));
        } else if (i == R.id.lib_txtv_search_history_4) {
            mSearchActivity.setSearchContent(mHistoryList.get(3));
        } else if (i == R.id.lib_txtv_search_history_5) {
            mSearchActivity.setSearchContent(mHistoryList.get(4));
        } else if (i == R.id.lib_txtv_search_history_6) {
            mSearchActivity.setSearchContent(mHistoryList.get(5));
        } else if (i == R.id.lib_txtv_search_history_7) {
            mSearchActivity.setSearchContent(mHistoryList.get(6));
        } else if (i == R.id.lib_txtv_search_history_8) {
            mSearchActivity.setSearchContent(mHistoryList.get(7));
        } else if (i == R.id.lib_txtv_search_history_9) {
            mSearchActivity.setSearchContent(mHistoryList.get(8));
        } else if (i == R.id.lib_txtv_search_history_10) {
            mSearchActivity.setSearchContent(mHistoryList.get(9));
        }
    }
}
