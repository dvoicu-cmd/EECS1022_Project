package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //For Side Btn
        Button btn = (Button) findViewById(R.id.SideBtn); //Creating variable of type button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //The event
                openSideMenu();
            }
        });

        //When a list element is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Handle the following
                //This is where you add information about (adapter.getItem(position))
                openSideMenu();
            }
        });

    } //End of onCreate

    //Method that opens the pop up menu
    public void openSideMenu(){
        Intent activity = new Intent(this, sideMenu.class);
        startActivity(activity);
    }

}//End of Main Activity

