package com.aw.avi.allutilsmethodsapp.ui.activity.viewpagers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aw.avi.allutilsmethodsapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewpagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_simple_viewpager, R.id.bt_viewpager_tab_scroll, R.id
            .bt_viewpager_tab_scroll_parallex})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_simple_viewpager:
                startActivity(new Intent(this, ViewPagerTABSimpleActivity.class));
                break;
            case R.id.bt_viewpager_tab_scroll:
                startActivity(new Intent(this, ViewPagerTABScrollActivity.class));
                break;
            case R.id.bt_viewpager_tab_scroll_parallex:
                startActivity(new Intent(this, ViewpagerScrollParallexActivity.class));
                break;
        }
    }
}
