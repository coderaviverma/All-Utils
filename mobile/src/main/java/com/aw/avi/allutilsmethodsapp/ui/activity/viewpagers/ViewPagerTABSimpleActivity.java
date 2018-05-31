package com.aw.avi.allutilsmethodsapp.ui.activity.viewpagers;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.adapters.ViewPagerAdapter;
import com.aw.avi.allutilsmethodsapp.ui.fragments.FirstFragment;
import com.aw.avi.allutilsmethodsapp.ui.fragments.SecoundFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerTABSimpleActivity extends AppCompatActivity {

    @BindView(R.id.tabsfragment)
    TabLayout tabsfragment;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_view_pager);
        ButterKnife.bind(this);

        setupViewPager(viewpager);
        tabsfragment.setupWithViewPager(viewpager);
    }


    private void setupViewPager(ViewPager viewPager) {

//        viewpager.setPageTransformer(false, new ViewPager.PageTransformer() {
//            public void transformPage(View page, float position) {
//                page.setRotationY(position * -40); // animation style... change as you want..
//            }
//        });


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(FirstFragment.newInstance(), "Fragment 1");
        adapter.addFragment(SecoundFragment.newInstance(), "Fragment 2");
        viewPager.setAdapter(adapter);


    }
}
