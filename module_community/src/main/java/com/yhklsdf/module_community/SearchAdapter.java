package com.yhklsdf.module_community;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private List<String> mResultList;
    private LayoutInflater mInflater;
    private Context mContext;
    private SearchActivity mSearchActivity;

    public SearchAdapter(Activity activity, Context context) {
        this.mContext = context;
        this.mInflater = activity.getLayoutInflater();
        mSearchActivity = (SearchActivity) activity;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.lib_item_result_recycler, viewGroup, false);
        SearchViewHolder viewHolder = new SearchViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder searchViewHolder, int i) {
        String text = mResultList.get(i);
        searchViewHolder.lib_txtv_search_result.setText(text);
        searchViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击" + text, Toast.LENGTH_SHORT).show();
                mSearchActivity.onSearch(text);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mResultList == null) {
            return 0;
        } else {
            return mResultList.size();
        }
    }

    public void setResultList(List<String> resultList) {
        this.mResultList = resultList;
        this.notifyDataSetChanged();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        private TextView lib_txtv_search_result;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            this.lib_txtv_search_result = itemView.findViewById(R.id.lib_txtv_search_result);
        }
    }
}
