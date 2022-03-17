package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List stocklist = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        stocklist.add("Intel");
        stocklist.add("Microsoft");
        stocklist.add("Apple");
        stocklist.add("Google");
        stocklist.add("Facebook");
        stocklist.add("Disney");
        stocklist.add("Tesla");
        stocklist.add("Exxon");
        stocklist.add("Nvidia");
        stocklist.add("Qualcomm");
        stocklist.add("Netflix");
        stocklist.add("Micron");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.list_item_layout, stocklist);
        listView.setAdapter(adapter);


    }
}