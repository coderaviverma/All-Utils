package com.aw.avi.allutilsmethodsapp.ui.activity.recyclerviews.hetrorecy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.aw.avi.allutilsmethodsapp.R;

public class HetrogenousRecyclerviewActivity extends AppCompatActivity implements HetroRecyView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hetrogenous_recyclerview);


    }

    @Override
    public void swapAdapters(RecyclerView.Adapter adapter) {

    }
}
