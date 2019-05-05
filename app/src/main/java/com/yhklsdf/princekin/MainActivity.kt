package com.yhklsdf.princekin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBarDrawerToggle
import com.yhklsdf.lib_common.base.BaseActivity
import com.yhklsdf.module_community.CommunityFragment
import com.yhklsdf.module_course.CourseFragment
import com.yhklsdf.module_home.HomeFragment
import com.yhklsdf.module_mine.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity() {

    private val BOTTOM_INDEX = "bottom_index"

    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_COMMUNITY = 0x02

    private var mIndex = FRAGMENT_HOME

    private var mHomeFragment : HomeFragment? = null
    private var mCommunityFragment : CommunityFragment? = null
    private var mCourseFragment : CourseFragment? = null
    private var mMineFragment : MineFragment? = null

    override fun attachLayoutRes() = R.layout.activity_main

    override fun initData() {
    }

    override fun initView() {
        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }

        initDrawerLayout()

        bottom_navigation.labelVisibilityMode = 1

        nav_view.run {
            setNavigationItemSelectedListener(onDrawerNavigationItemSelectedListener)
        }

        showFragment(mIndex)
    }

    override fun start() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState?.getInt(BOTTOM_INDEX)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(BOTTOM_INDEX, mIndex)
    }

    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        mIndex = index
        when(index){
            FRAGMENT_HOME ->{
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance()
                    transaction.add(R.id.container, mHomeFragment!!, "home")
                } else {
                    transaction.show(mHomeFragment!!)
                }
            }
            FRAGMENT_COMMUNITY ->{
                if (mCommunityFragment == null) {
                    mCommunityFragment = CommunityFragment.getInstance()
                    transaction.add(R.id.container, mCommunityFragment!!, "community")
                } else {
                    transaction.show(mCommunityFragment!!)
                }
            }
        }
        transaction.commit()
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mCommunityFragment?.let { transaction.hide(it) }
        mCourseFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

    private val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                return@OnNavigationItemSelectedListener when (item.itemId) {
                    R.id.action_home ->{
                        showFragment(FRAGMENT_HOME)
                        true
                    }
                    R.id.action_community ->{
                        showFragment(FRAGMENT_COMMUNITY)
                        true
                    }
                    else -> false
                }
            }

    private val onDrawerNavigationItemSelectedListener =
            NavigationView.OnNavigationItemSelectedListener { item ->
                when(item.itemId){
                    R.id.nav_info -> {
                    }
                }
                true
            }

    private fun initDrawerLayout() {
        main_drawer_layout.run {
            var toggle = ActionBarDrawerToggle(
                    this@MainActivity,
                    this,
                    toolbar
                    , R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close)
            addDrawerListener(toggle)
            toggle.syncState()
        }
    }
}
