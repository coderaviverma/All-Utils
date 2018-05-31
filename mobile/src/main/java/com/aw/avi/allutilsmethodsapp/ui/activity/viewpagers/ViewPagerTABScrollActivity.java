package com.aw.avi.allutilsmethodsapp.ui.activity.viewpagers;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.adapters.ViewPagerAdapter;
import com.aw.avi.allutilsmethodsapp.ui.fragments.ViewPagerScrollRecyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerTABScrollActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_tabscroll);
//        getSupportActionBar().hide();

        ButterKnife.bind(this);
        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ViewPagerScrollRecyFragment.newInstance(), "ViewPagerScrollRecy 1");
        adapter.addFragment(ViewPagerScrollRecyFragment.newInstance(), "ViewPagerScrollRecy 2");
        viewPager.setAdapter(adapter);


    }
}
