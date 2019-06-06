package com.yhklsdf.lib_common.module.home.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.SearchActivity;
import com.yhklsdf.lib_common.module.home.adapter.GraduateChooserAdapter;
import com.yhklsdf.lib_common.module.home.adapter.SchoolAdapter;
import com.yhklsdf.lib_common.module.home.item.SchoolBean;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/home/post_graduate")
public class PostGraduateActivity extends AppCompatActivity {
    private ImageButton home_imgbtn_post_graduate_back;
    private ConstraintLayout home_constraint_post_graduate_search;
    private RecyclerView home_recycler_post_graduate_chooser;
    private ImageButton home_imgbtn_post_graduate_more;
    private RecyclerView home_recycler_post_graduate_school;
    private ConstraintLayout home_constraint_post_graduate_curtain;
    private List<String> testStringList;
    private List<SchoolBean> testSchoolList;
    private SchoolAdapter mSchoolAdapter;
    private GraduateChooserAdapter mGraduateChooserAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_post_graduate);
        initView();
        initData();
    }

    private void initView() {
        home_imgbtn_post_graduate_back = findViewById(R.id.home_imgbtn_recruit_back);
        home_constraint_post_graduate_search = findViewById(R.id.home_constraint_recruit_search);
        home_recycler_post_graduate_chooser = findViewById(R.id.home_recycler_post_graduate_chooser);
        home_imgbtn_post_graduate_more = findViewById(R.id.home_imgbtn_post_graduate_more);
        home_recycler_post_graduate_school = findViewById(R.id.home_recycler_post_graduate_school);
        home_constraint_post_graduate_curtain = findViewById(R.id.home_constraint_post_graduate_curtain);
        testStringList = new ArrayList<>();
        testSchoolList = new ArrayList<>();
        mGraduateChooserAdapter = new GraduateChooserAdapter(this, testStringList);
        LinearLayoutManager chooserManager = new LinearLayoutManager(this);
        chooserManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_recycler_post_graduate_chooser.setAdapter(mGraduateChooserAdapter);
        home_recycler_post_graduate_chooser.setLayoutManager(chooserManager);
        home_recycler_post_graduate_chooser.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {    //判断滚动到底部则设置imgbtn不可见
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visblePosition = manager.findLastVisibleItemPosition();
                int itemCount = manager.getItemCount();
                if (visblePosition == itemCount - 1) {
                    home_imgbtn_post_graduate_more.setVisibility(View.GONE);
                } else {
                    home_imgbtn_post_graduate_more.setVisibility(View.VISIBLE);
                }
            }
        });
        mSchoolAdapter = new SchoolAdapter(this, testSchoolList);
        LinearLayoutManager schoolManager = new LinearLayoutManager(this);
        home_recycler_post_graduate_school.setAdapter(mSchoolAdapter);
        home_recycler_post_graduate_school.setLayoutManager(schoolManager);
        home_imgbtn_post_graduate_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        home_constraint_post_graduate_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostGraduateActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initData() {
        for (int i = 0; i < 5; i++) {
            testStringList.add("北京");
            testStringList.add("超长的地址");
            testStringList.add("广西");
            testStringList.add("四川");
            testStringList.add("新疆");
            testStringList.add("湖南");
        }
        mGraduateChooserAdapter.setStringList(testStringList);
        for (int i = 0; i < 5; i++) {
            testSchoolList.add(new SchoolBean("1", "北京大学", "985/双一流", "学校介绍"));
            testSchoolList.add(new SchoolBean("2", "北京工业大学", "211/双一流", "学校介绍"));
            testSchoolList.add(new SchoolBean("3", "北京物资大学", "普通一本", "学校介绍"));
            testSchoolList.add(new SchoolBean("4", "北京理工大学", "985/211", "学校介绍"));
        }
        mSchoolAdapter.setStringList(testSchoolList);
    }

    public void setCurtainVisibility(int visible) {
        home_constraint_post_graduate_curtain.setVisibility(visible);
    }
}
