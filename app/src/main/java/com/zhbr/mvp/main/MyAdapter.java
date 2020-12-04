package com.zhbr.mvp.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhbr.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] mDataSet;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    public MyAdapter(String[] mDataSet){
        this.mDataSet =mDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        TextView v = (TextView)LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_recycler_view,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.textView.setText(mDataSet[i]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
