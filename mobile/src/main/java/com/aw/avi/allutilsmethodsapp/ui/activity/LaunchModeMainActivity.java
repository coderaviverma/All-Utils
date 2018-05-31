package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.ui.activity.launchmodes.singleinstance
        .SingleInstanceActivity_A;
import com.aw.avi.allutilsmethodsapp.ui.activity.launchmodes.singletasks.SingleTaskActivity_A;
import com.aw.avi.allutilsmethodsapp.ui.activity.launchmodes.singletops.SingleTopActivity_A;
import com.aw.avi.allutilsmethodsapp.ui.activity.launchmodes.standards.StandardActivity_A;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaunchModeMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_standard_mode, R.id.bt_single_top_mode, R.id.bt_single_task_mode, R.id
            .bt_single_instance_mode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_standard_mode:
                startActivity(new Intent(this, StandardActivity_A.class));
                break;
            case R.id.bt_single_top_mode:
                startActivity(new Intent(this, SingleTopActivity_A.class));

                break;
            case R.id.bt_single_task_mode:

                startActivity(new Intent(this, SingleTaskActivity_A.class));

                break;
            case R.id.bt_single_instance_mode:

                startActivity(new Intent(this, SingleInstanceActivity_A.class));

                break;
        }
    }
}
