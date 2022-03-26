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
    AppData stocks = new AppData(); //Initiate the new stock list here
    ArrayList<String> stockList = stocks.returnStockList();



    //Doing a little testing:
    int stockPos = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding the widgets
        listView = (ListView) findViewById(R.id.list_view);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        // For list
        adapter = new ArrayAdapter(MainActivity.this, R.layout.list_item_layout, stockList);
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
                openStockInformation(position);
            }
        });

    } //End of onCreate

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//    }
//
//

    /*
     * Methods that are used for changing activities and passing data through the activities
     */

    //Open SideMenu
    public void openSideMenu(){
        Intent activity = new Intent(this, SideMenu.class);
        startActivity(activity);
    }

    public void openStockInformation(int position){
        Intent activity = new Intent(this, StockInformation.class);
        activity.putExtra("stockPos",position);
        startActivity(activity);
    }

}//End of Main Activity

