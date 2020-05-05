package com.mrlove.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyAdapter adapter;
    private ArrayList<String> arrayList;
    private ArrayList<String> arrayList1;
    private ArrayList<String> arrayList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList = new ArrayList<>();
        for(int i=1;i<20;i++){
            arrayList.add("安卓测试"+i);
        }
        arrayList1 = new ArrayList<>();
        for(int i=1;i<20;i++){
            arrayList1.add("页面刷新"+i);
        }

        arrayList2 = new ArrayList<>();
        for(int i=1;i<20;i++){
            arrayList2.add("改变数据"+i);
        }
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                changeData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        adapter = new MyAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    public void changeData(){
        Random random = new Random();
        ArrayList<String> arrayList3 = new ArrayList<>();
        Boolean b = random.nextBoolean();
        System.out.println(b);
        arrayList3.clear();
        arrayList3.addAll(b?arrayList1:arrayList2);
        arrayList.clear();
        arrayList.addAll(arrayList3);
        adapter.notifyDataSetChanged();
    }
}
