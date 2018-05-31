package com.aw.avi.allutilsmethodsapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.models.Details;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Avinash on 12/10/2017.
 */

public class ViewPagersRecyclerviewAdapter extends RecyclerView
        .Adapter<ViewPagersRecyclerviewAdapter.MyViewHolder> {

    private Context mContext;

    private List<Details> dataList;

    public ViewPagersRecyclerviewAdapter(Context mContext, List<Details> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(mContext).inflate(R.layout.row_recycler, parent,
                false);
            notifyDataSetChanged();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvText.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_text)
        TextView tvText;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
