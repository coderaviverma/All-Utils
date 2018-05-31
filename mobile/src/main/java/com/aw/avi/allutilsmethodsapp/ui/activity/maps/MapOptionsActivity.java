package com.aw.avi.allutilsmethodsapp.ui.activity.maps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.aw.avi.allutilsmethodsapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapOptionsActivity extends AppCompatActivity {
    @BindView(R.id.bt_simple_map)
    Button btSimpleMap;
    @BindView(R.id.bt_cluster_map)
    Button btClusterMap;
    @BindView(R.id.bt_cluster_custom_marker_map)
    Button btClusterCustomMarkerMap;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_options);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.bt_simple_map, R.id.bt_cluster_map, R.id.bt_cluster_custom_marker_map})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_simple_map:
                startActivity(new Intent(this, SimpleMapsActivity.class));
                break;
            case R.id.bt_cluster_map:
                startActivity(new Intent(this, ClusterMapsActivity.class));
                break;
            case R.id.bt_cluster_custom_marker_map:
                startActivity(new Intent(this, ClusterCustomMarkerMapsActivity.class));
                break;
        }
    }
}
