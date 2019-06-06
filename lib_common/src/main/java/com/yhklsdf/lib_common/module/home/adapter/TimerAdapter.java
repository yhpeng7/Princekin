package com.yhklsdf.lib_common.module.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yhklsdf.lib_common.R;


public class TimerAdapter extends RecyclerView.Adapter<TimerAdapter.IntegerViewHolder> {

    private Context mContext;

    public TimerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public IntegerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_dialog_checkin_timer, viewGroup, false);
        IntegerViewHolder viewHolder = new IntegerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IntegerViewHolder integerViewHolder, int i) {
        integerViewHolder.item_txtv.setText(i+"");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class IntegerViewHolder extends RecyclerView.ViewHolder {
        TextView item_txtv;

        public IntegerViewHolder(@NonNull View itemView) {
            super(itemView);
            item_txtv = itemView.findViewById(R.id.home_txtv_dialog_checkin_timer);
        }
    }
}
