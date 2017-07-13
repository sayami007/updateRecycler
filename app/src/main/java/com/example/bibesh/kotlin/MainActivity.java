package com.example.bibesh.kotlin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bibesh on 7/13/17.
 */

public class MainActivity extends AppCompatActivity implements ClickListener {

    RecyclerView rv_list;

    @Override
    public void onItemClick(int position) {
        Log.v("POS","POS");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);


        ArrayList<PersonModel> personModel = new ArrayList<>();

        PersonModel model = new PersonModel();
        model.setName("BIBESH");
        model.setAddress("Kathmandu");

        PersonModel model1 = new PersonModel();
        model1.setName("BIBESH");
        model1.setAddress("Kathmandu");

        PersonModel model2 = new PersonModel();
        model2.setName("BIBESH");
        model2.setAddress("Pokhata");

        personModel.add(model);
        personModel.add(model1);
        personModel.add(model2);

        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv_list.setAdapter(new CustomAdapter(this, personModel,this));
    }

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
            holder.ivPerson.setOnClickListener(new View.OnClickListener() {
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
            ImageView ivPerson;
            TextView tvPersonName, tvPersonAddress;

            public MyViewHolder(View view) {
                super(view);
                ivPerson = view.findViewById(R.id.iv_person);
                tvPersonName = view.findViewById(R.id.tv_person_name);
                tvPersonAddress = view.findViewById(R.id.tv_person_address);
            }
        }
    }
}
