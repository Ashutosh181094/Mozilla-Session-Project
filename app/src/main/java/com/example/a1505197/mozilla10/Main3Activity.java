package com.example.a1505197.mozilla10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main3Activity extends AppCompatActivity {
RecyclerView recyclerView;
    MyCustomAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        adapter = new MyCustomAdapter(this, MyData.getdata());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        toolbar = (Toolbar) findViewById(R.id.etcontactToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MOZILLA DESTINATION ");

        getSupportActionBar().setElevation(10f);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Main3Activity.this,Main2Activity.class));
            }
        });

    }

    }

