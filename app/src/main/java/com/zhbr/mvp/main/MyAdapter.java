package com.zhbr.mvp.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhbr.R;
import com.zhbr.bean.Message;

import java.text.SimpleDateFormat;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Message> mDataSet;
    public SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_title;
        public TextView tv_body;
        public TextView tv_date;
        public MyViewHolder(View v) {
            super(v);
            tv_title = (TextView)v.findViewById(R.id.tv_title);
            tv_body = (TextView)v.findViewById(R.id.tv_body);
            tv_date = (TextView)v.findViewById(R.id.tv_date);
        }
    }

    public MyAdapter(List<Message> mDataSet){
        this.mDataSet =mDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_recycler_view_item,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        Message msg = mDataSet.get(i);
        viewHolder.tv_title.setText(msg.getId()+" "+msg.getTitle());
        viewHolder.tv_body.setText(msg.getBody());
        viewHolder.tv_date.setText(msg.getDate());
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
