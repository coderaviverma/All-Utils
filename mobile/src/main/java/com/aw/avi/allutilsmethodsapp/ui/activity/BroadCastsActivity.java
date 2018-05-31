package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aw.avi.allutilsmethodsapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadCastsActivity extends AppCompatActivity {
    @BindView(R.id.bt_local_broadcast)
    Button btLocalBroadcast;
    @BindView(R.id.bt_sticky_broadcast)
    Button btStickyBroadcast;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_casts);
        ButterKnife.bind(this);

        stickyBroadCast();
    }


    private void stickyBroadCast() {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = mContext.registerReceiver(null, ifilter);

        // Are we charging / charged?
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

// How are we charging?
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

        Toast.makeText(mContext, "BroadCastsActivity " + chargePlug, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.bt_local_broadcast, R.id.bt_sticky_broadcast})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_local_broadcast:
                break;
            case R.id.bt_sticky_broadcast:
                break;
        }
    }
}
