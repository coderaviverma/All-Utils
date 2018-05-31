package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.ui.activity.kotlin.KotlinBasicActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class KotlinMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotlin_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.bt_kotlin_first, R.id.bt_kotlin_logics})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_kotlin_first:
                startActivity(new Intent(this, KotlinBasicActivity.class));
                break;
            case R.id.bt_kotlin_logics:
                break;
        }
    }
}
