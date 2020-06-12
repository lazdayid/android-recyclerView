package com.lazday.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<MainModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();
        setData();
    }

    private void setRecyclerView(){

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(MainActivity.this, data);
    }

    private void setData(){

        for (int i = 0; i < Avengers.getTitles().length; i++) {
            Log.d(TAG, "title: " + Avengers.getTitles()[i]);
            MainModel model = new MainModel();
            model.setTitle( Avengers.getTitles()[i] );
            model.setImage(getResources().getDrawable(Avengers.getImages()[i]) );
            data.add(model);
        }

        recyclerView.setAdapter(adapter);
    }
}
