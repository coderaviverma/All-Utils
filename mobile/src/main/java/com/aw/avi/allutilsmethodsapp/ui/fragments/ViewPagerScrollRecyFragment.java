package com.aw.avi.allutilsmethodsapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.adapters.ViewPagersRecyclerviewAdapter;
import com.aw.avi.allutilsmethodsapp.datagenerator.DataGenerator;
import com.aw.avi.allutilsmethodsapp.models.Details;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ViewPagerScrollRecyFragment extends Fragment {
    @BindView(R.id.rcv_scroll)
    RecyclerView rcvScroll;
    Unbinder unbinder;
    private Context mContext;

    public ViewPagerScrollRecyFragment() {
        // Required empty public constructor
    }

    public static ViewPagerScrollRecyFragment newInstance() {
        ViewPagerScrollRecyFragment fragment = new ViewPagerScrollRecyFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager_scroll_recy, container, false);
        unbinder = ButterKnife.bind(this, view);
        rcvScroll.setLayoutManager(new LinearLayoutManager(mContext));

        List<Details> detailsList = DataGenerator.detailsGenerator();

        rcvScroll.setAdapter(new ViewPagersRecyclerviewAdapter(mContext, detailsList));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
