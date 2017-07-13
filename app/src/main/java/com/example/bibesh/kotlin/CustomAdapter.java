package com.example.bibesh.kotlin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bibesh on 7/13/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    LayoutInflater inflater;
    ArrayList<PersonModel> data;
    ClickListener clickListener;

    public CustomAdapter(Context ctx, ArrayList<PersonModel> data, ClickListener clickListener) {
        this.inflater = LayoutInflater.from(ctx);
        this.data = data;
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_recycler, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvPersonName.setText(data.get(position).getName());
        holder.tvPersonAddress.setText(data.get(position).getAddress());
        holder.ivClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPerson, ivClick;
        TextView tvPersonName, tvPersonAddress;

        public MyViewHolder(View view) {
            super(view);
            ivPerson = view.findViewById(R.id.iv_person);
            tvPersonName = view.findViewById(R.id.tv_person_name);
            tvPersonAddress = view.findViewById(R.id.tv_person_address);
            ivClick = view.findViewById(R.id.iv_click);
        }
    }
}
