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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Initiate the app data class
    AppData data = new AppData();

    //For List view on layout
    ListView listView; //List view on layout
    private ArrayAdapter adapter; //Array Adaptor for the list

    //Activity Data
    ArrayList<String> stockList = data.returnStockList(); //The list of stocks
    ArrayList<String> bookMarks = data.returnBookMarks();
    boolean bootStatus = data.firstBootState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Implementation for scrollable list
         */
        // Finding the widgets
        ListView listView = (ListView) findViewById(R.id.list_view);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        //For the list
        adapter = new ArrayAdapter(MainActivity.this, R.layout.list_item_layout, stockList);

        // getting stocks values
        List<String> stockNameList = new ArrayList<>();
        List<Stock> stocks = StockList.getInstance().getStocks();
        for (Stock s : stocks)
            stockNameList.add(s.getName());

        // For list
        adapter = new ArrayAdapter(MainActivity.this, R.layout.list_item_layout, stockNameList);
        listView.setAdapter(adapter);

        //Create the list
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

        /**
         * OnClick handler methods
         */
        //When sideMenu is clicked
        Button btn = (Button) findViewById(R.id.SideBtn); //Creating variable of type button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //The event
                Intent i = new Intent(getApplicationContext(), BookMarkActivity.class);
                i.putExtra("bookMarks", data.returnBookMarks());
                i.putExtra("bootStatus",data.firstBootState());
                startActivity(i);
            }
        });
    }

    public void stockClickHandler(View v){
        TextView stock = (TextView) v;
        CharSequence stockName = stock.getText();
        Intent i = new Intent(getApplicationContext(),StockActivity.class);
        i.putExtra("stockName",stockName);
        i.putExtra("bookMarks",bookMarks);
        i.putExtra("bootStatus",bootStatus);
        startActivity(i);

    } //End of onCreate

}//End of Main Activity

