package com.example.earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayList<MyWord> list = new ArrayList<>();
//        list.add(new MyWord("1.1","chandigarh","12feb"));
//        list.add(new MyWord("1.2","chandigarh","15feb"));
//        list.add(new MyWord("1.3","chandigarh","10feb"));
//        list.add(new MyWord("1.6","chandigarh","11feb"));

        final ArrayList<MyWord> list = QueryUtils.extractEarthquakes();
        ListView listView = findViewById(R.id.list_layout);
        final CustomAdapter adapter = new CustomAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyWord currentWord = list.get(position);
                String url = currentWord.geturl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
