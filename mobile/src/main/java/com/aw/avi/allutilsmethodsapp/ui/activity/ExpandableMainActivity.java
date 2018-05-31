package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.aw.avi.allutilsmethodsapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableMainActivity extends AppCompatActivity {

    public  Context mContext;
    @BindView(R.id.elv_assets)
    ExpandableListView elvAssets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_main);
        ButterKnife.bind(this);
        mContext = this;
    }
}
