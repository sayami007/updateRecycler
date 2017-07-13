package com.example.bibesh.kotlin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Bibesh on 7/13/17.
 */

public class MainActivity extends AppCompatActivity implements ClickListener {

    RecyclerView rv_list;

    ArrayList<PersonModel> personModel = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        CustomAdapter adapter = new CustomAdapter(this, getData(), this);

        rv_list.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Log.v("POS", "" + position);
        personModel.remove(position);
        rv_list.getAdapter().notifyItemRemoved(position);
        rv_list.getAdapter().notifyItemRangeChanged(position,personModel.size());
    }


    private ArrayList<PersonModel> getData() {


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

        return personModel;
    }
}
