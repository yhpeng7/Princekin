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

import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.SearchActivity;
import com.yhklsdf.lib_common.module.home.adapter.CareerAdapter;
import com.yhklsdf.lib_common.module.home.adapter.CompanyAdapter;
import com.yhklsdf.lib_common.module.home.adapter.RecruitChooserAdapter;
import com.yhklsdf.lib_common.module.home.item.CareerBean;
import com.yhklsdf.lib_common.module.home.item.CompanyBean;

import java.util.ArrayList;
import java.util.List;

public class RecruitActivity extends AppCompatActivity {
    private ImageButton home_imgbtn_recruit_back;
    private ConstraintLayout home_constraint_recruit_search;
    private RecyclerView home_recycler_recruit_company;
    private RecyclerView home_recycler_recruit_software;
    private ImageButton home_imgbtn_recruit_software_more;
    private RecyclerView home_recycler_recruit_hardware;
    private ImageButton home_imgbtn_recruit_hardware_more;
    private RecyclerView home_recycler_recruit_career;
    private ConstraintLayout home_constraint_recruit_curtain;
    private List<CompanyBean> mCompanyBeanList;
    private List<String> mSoftWareList;
    private List<String> mHardWareList;
    private List<CareerBean> mCareerBeanList;
    private CompanyAdapter mCompanyAdapter;
    private RecruitChooserAdapter mSoftWareAdapter;
    private RecruitChooserAdapter mHardWareAdapter;
    private CareerAdapter mCareerAdapter;
    private RecruitChooserAdapter.RecruitChooserViewHolder mSelectedViewHolder = null;


    public RecruitChooserAdapter.RecruitChooserViewHolder getSelectedViewHolder() {
        return mSelectedViewHolder;
    }

    public void setSelectedViewHolder(RecruitChooserAdapter.RecruitChooserViewHolder mSelectedViewHolder) {
        this.mSelectedViewHolder = mSelectedViewHolder;
    }

    public void setCurtainVisibility(int visibility) {
        home_constraint_recruit_curtain.setVisibility(visibility);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_recruit);
        initView();
        initData();
    }


    private void initView() {
        home_imgbtn_recruit_back = findViewById(R.id.home_imgbtn_recruit_back);
        home_constraint_recruit_search = findViewById(R.id.home_constraint_recruit_search);
        home_recycler_recruit_company = findViewById(R.id.home_recycler_recruit_company);
        home_recycler_recruit_software = findViewById(R.id.home_recycler_recruit_software);
        home_imgbtn_recruit_software_more = findViewById(R.id.home_imgbtn_recruit_software_more);
        home_recycler_recruit_hardware = findViewById(R.id.home_recycler_recruit_hardware);
        home_imgbtn_recruit_hardware_more = findViewById(R.id.home_imgbtn_recruit_hardware_more);
        home_recycler_recruit_career = findViewById(R.id.home_recycler_recruit_career);
        home_constraint_recruit_curtain = findViewById(R.id.home_constraint_recruit_curtain);
        mCompanyBeanList = new ArrayList<>();
        mSoftWareList = new ArrayList<>();
        mHardWareList = new ArrayList<>();
        mCareerBeanList = new ArrayList<>();
        home_imgbtn_recruit_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        home_constraint_recruit_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecruitActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        mCompanyAdapter = new CompanyAdapter(this, mCompanyBeanList);
        LinearLayoutManager companyManager = new LinearLayoutManager(this);
        companyManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_recycler_recruit_company.setAdapter(mCompanyAdapter);
        home_recycler_recruit_company.setLayoutManager(companyManager);

        mSoftWareAdapter = new RecruitChooserAdapter(this, mSoftWareList);
        LinearLayoutManager softwareManager = new LinearLayoutManager(this);
        softwareManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_recycler_recruit_software.setAdapter(mSoftWareAdapter);
        home_recycler_recruit_software.setLayoutManager(softwareManager);
        home_recycler_recruit_software.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {    //判断滚动到底部则设置imgbtn不可见
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visiblePosition = manager.findLastVisibleItemPosition();
                int itemCount = manager.getItemCount();
                if (visiblePosition == itemCount - 1) {
                    home_imgbtn_recruit_software_more.setVisibility(View.GONE);
                } else {
                    home_imgbtn_recruit_software_more.setVisibility(View.VISIBLE);
                }
            }
        });

        mHardWareAdapter = new RecruitChooserAdapter(this, mHardWareList);
        LinearLayoutManager hardwareManager = new LinearLayoutManager(this);
        hardwareManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_recycler_recruit_hardware.setAdapter(mHardWareAdapter);
        home_recycler_recruit_hardware.setLayoutManager(hardwareManager);
        home_recycler_recruit_hardware.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {    //判断滚动到底部则设置imgbtn不可见
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visiblePosition = manager.findLastVisibleItemPosition();
                int itemCount = manager.getItemCount();
                if (visiblePosition == itemCount - 1) {
                    home_imgbtn_recruit_hardware_more.setVisibility(View.GONE);
                } else {
                    home_imgbtn_recruit_hardware_more.setVisibility(View.VISIBLE);
                }
            }
        });

        mCareerAdapter = new CareerAdapter(this, mCareerBeanList);
        LinearLayoutManager careerManager = new LinearLayoutManager(this);
        home_recycler_recruit_career.setAdapter(mCareerAdapter);
        home_recycler_recruit_career.setLayoutManager(careerManager);
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            mCompanyBeanList.add(new CompanyBean("1", "已开始", "杭州阿里巴巴有限公司"));
            mCompanyBeanList.add(new CompanyBean("2", "已开始", "华为科技股份有限公司"));
            mCompanyBeanList.add(new CompanyBean("3", "已开始", "字节跳动网络科技有限公司"));
        }
        mCompanyAdapter.setmCompanyBeanList(mCompanyBeanList);
        for (int i = 0; i < 3; i++) {
            mSoftWareList.add("JAVA开发");
            mSoftWareList.add("前端工程师");
            mSoftWareList.add("后端工程师");
            mSoftWareList.add("大数据");
            mSoftWareList.add("PAYTHON");
        }
        mSoftWareAdapter.setStringList(mSoftWareList);
        for (int i = 0; i < 3; i++) {
            mHardWareList.add("光通信工程师");
            mHardWareList.add("光传输工程师");
            mHardWareList.add("自动化控制工程师");
        }
        mHardWareAdapter.setStringList(mHardWareList);
        for (int i = 0; i < 3; i++) {
            mCareerBeanList.add(new CareerBean("Java开发工程师", "西安金映客", "计算机/互联网", "5.15"));
            mCareerBeanList.add(new CareerBean("前端工程师", "声彩传媒", "计算机/互联网", "4.28"));
            mCareerBeanList.add(new CareerBean("光通信工程师", "合创知识", "通信/传媒", "3.24"));
            mCareerBeanList.add(new CareerBean("大数据分析", "重辉科技", "文化/传媒", "3.24"));
        }
        mCareerAdapter.setCareerBeanList(mCareerBeanList);

    }
}
