package com.aw.avi.allutilsmethodsapp.ui.activity.recyclerviews.hetrorecy;

import android.support.v7.widget.RecyclerView;

import com.aw.avi.allutilsmethodsapp.ui.activity.recyclerviews.hetrorecy.models.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinash.verma on 3/14/2018.
 */

public class HetrogrnousRecyPresenter {

    private HetroRecyView hetroRecyView;

    private RecyclerView.Adapter adapter;

    public HetrogrnousRecyPresenter(HetroRecyView hetroRecyView) {
        this.hetroRecyView = hetroRecyView;
    }


    public void loadRecyclerView() {


    }

    private List<Object> getSampleArrayList() {
        List<Object> items = new ArrayList<>();
        items.add(new Users("Dany Targaryen", "Valyria"));
        items.add(new Users("Rob Stark", "Winterfell"));
        items.add("image");
        items.add(new Users("Jon Snow", "Castle Black"));
        items.add("image");
        items.add(new Users("Tyrion Lanister", "King's Landing"));
        return items;
    }
}
