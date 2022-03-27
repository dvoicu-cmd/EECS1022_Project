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

public class MainActivity extends AppCompatActivity {

    ListView listView; //List view on layout
    private ArrayAdapter adapter; //Array Adaptor for the list
    AppData data = new AppData(); //Initiate the app data
    ArrayList<String> stockList = data.returnStockList();

    ArrayList<String> s;
    boolean bo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Implementation for scrollable list
         */
        // Finding the widgets
        listView = (ListView) findViewById(R.id.list_view);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        //For the list
        adapter = new ArrayAdapter(MainActivity.this, R.layout.list_item_layout, stockList);
        listView.setAdapter(adapter);

        //Create the list
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });


        /**
         * OnClick handler methods
         */
        //When sideMenu is clicked
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
                openStockInformation(position);
            }
        });

        /**
         * Handle the data after there was a click (if there is any)
         */
        //SHOW IT HERE:
        if(data.firstBootState() == false){
            Bundle extras = getIntent().getExtras();
            ArrayList<String> s = extras.getStringArrayList("bookmarks");
        }
        data.firstBoot();
    } //End of onCreate

    /**
     * Methods that are used for changing activities and passing data through the activities
     */



    /*
     * DATA OUTPUTS
     */

    //Open SideMenu
    public void openSideMenu(){
        Intent activity = new Intent(this, SideMenu.class);
        //de bug: add facebook to list
        data.addToBookmark(4);
        activity.putExtra("bookmarks", data.returnBookMarks());
        activity.putExtra("firstboot",data.firstBootState());
        startActivity(activity);
    }

    public void openStockInformation(int position){
        Intent activity = new Intent(this, StockInformation.class);
        activity.putExtra("stockPos",position);
        activity.putExtra("bookmarks",data.returnBookMarks());
        startActivity(activity);
    }


    /*
     * DATA INPUTS
     */
    private void checkOfData(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s = extras.getStringArrayList("bookmarks");
            bo = extras.getBoolean("firstboot");
        }
    }


}//End of Main Activity

