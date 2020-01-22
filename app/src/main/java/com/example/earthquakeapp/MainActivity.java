package com.example.earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter madapter;

    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayList<MyWord> list = new ArrayList<>();
//        list.add(new MyWord("1.1","chandigarh","12feb"));
//        list.add(new MyWord("1.2","chandigarh","15feb"));
//        list.add(new MyWord("1.3","chandigarh","10feb"));
//        list.add(new MyWord("1.6","chandigarh","11feb"));

//        final ArrayList<MyWord> list = QueryUtils.extractEarthquakes();
        ListView listView = findViewById(R.id.list_layout);
        madapter = new CustomAdapter(this,new ArrayList<MyWord>());
        listView.setAdapter(madapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyWord currentWord = madapter.getItem(position);
                String url = currentWord.geturl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }
    private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<MyWord>> {

        @Override
        protected List<MyWord> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<MyWord> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;

        }

        @Override
        protected void onPostExecute(List<MyWord> data) {
            madapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                madapter.addAll(data);
            }

        }
    }
}
