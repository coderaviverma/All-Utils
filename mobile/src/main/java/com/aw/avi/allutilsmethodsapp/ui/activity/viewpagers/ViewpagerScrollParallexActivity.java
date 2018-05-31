package com.aw.avi.allutilsmethodsapp.ui.activity.viewpagers;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.adapters.ViewPagersRecyclerviewAdapter;
import com.aw.avi.allutilsmethodsapp.datagenerator.DataGenerator;
import com.aw.avi.allutilsmethodsapp.models.Details;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewpagerScrollParallexActivity extends AppCompatActivity {

    @BindView(R.id.header)
    ImageView header;
    @BindView(R.id.anim_toolbar)
    Toolbar animToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rcv_scrollableview)
    RecyclerView rcvScrollableview;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_scroll_parallex);
        ButterKnife.bind(this);
        mContext = this;

        rcvScrollableview.setLayoutManager(new LinearLayoutManager(mContext));

        List<Details> detailsList = DataGenerator.detailsGenerator();

        rcvScrollableview.setAdapter(new ViewPagersRecyclerviewAdapter(mContext, detailsList));
    }
}
