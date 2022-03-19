package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List stocklist = new ArrayList();
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding the widgets
        listView = (ListView) findViewById(R.id.list_view);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        // Adding stocks
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

        // For list
        adapter = new ArrayAdapter(MainActivity.this, R.layout.list_item_layout, stocklist);
        listView.setAdapter(adapter);

        // For search box
        theFilter.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                (MainActivity.this).adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });


    }
}