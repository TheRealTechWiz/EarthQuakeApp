package com.example.earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<MyWord> list = new ArrayList<>();
        list.add(new MyWord("1.1","chandigarh","12feb"));
        list.add(new MyWord("1.2","chandigarh","15feb"));
        list.add(new MyWord("1.3","chandigarh","10feb"));
        list.add(new MyWord("1.6","chandigarh","11feb"));


        ListView listView = findViewById(R.id.list_layout);
        CustomAdapter adapter = new CustomAdapter(this,list);
        listView.setAdapter(adapter);
    }
}
