package com.aw.avi.allutilsmethodsapp.ui.activity.recyclerviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.ui.activity.recyclerviews.hetrorecy.HetrogenousRecyclerviewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewMainActivity extends AppCompatActivity {

    @BindView(R.id.bt_rcv_simple)
    Button btRcvSimple;
    @BindView(R.id.rcv_grid)
    Button rcvGrid;
    @BindView(R.id.rcv_staggerd)
    Button rcvStaggerd;
    @BindView(R.id.rcv_with_header)
    Button rcvWithHeader;
    @BindView(R.id.rcv_with_viewpager)
    Button rcvWithViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_rcv_simple, R.id.rcv_grid, R.id.rcv_staggerd, R.id.rcv_with_header, R.id
            .rcv_with_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_rcv_simple:
                break;
            case R.id.rcv_grid:
                break;
            case R.id.rcv_staggerd:
                break;
            case R.id.rcv_with_header:
                break;
            case R.id.rcv_with_viewpager:
                break;
            case R.id.rcv_hetrogeneous:
                startActivity(new Intent(this, HetrogenousRecyclerviewActivity.class));
                break;
        }
    }
}
