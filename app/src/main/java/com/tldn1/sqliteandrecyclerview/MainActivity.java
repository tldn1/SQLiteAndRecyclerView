package com.tldn1.sqliteandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] name = {"Mico","Bozo","Zoran","Petko","Semir"};
    String[] email = {"mico@live.com","bozo@live.com","zoran@live.com","petko@live.com","semir@live.com"};

    ArrayList<ContactModel> arrayList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        DBHelper dbHelper = new DBHelper(this);


        for(int i=0;i<name.length;i++) {
            dbHelper.addContact(name[i],email[i]);
        }

        arrayList.addAll(dbHelper.getData());
        adapter = new RecyclerViewAdapter(arrayList);
        recyclerView.setAdapter(adapter);



    }
}
