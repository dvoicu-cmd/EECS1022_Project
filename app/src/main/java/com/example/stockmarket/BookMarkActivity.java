package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookMarkActivity extends AppCompatActivity {

    //Init app data
    AppData data = new AppData();

    //Activity Data
    ArrayList<String> stockList = data.getStockList(); //The list of stocks

    //Array Adaptor for the list
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_mark);

        // Finding the widgets
        ListView listView = (ListView) findViewById(R.id.list_view);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        //Get bundle of inputted data and apply it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            data.storeBookMarks(extras.getStringArrayList("bookMarks"));
        }

        //On Click for mainPage to go back to main page
        Button btn = (Button) findViewById(R.id.SideBtn); //Creating variable of type button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("bookMarks", data.getBookMarks());
                startActivity(i);
            }
        });

        //Process the bookmark data here

        data.addToBookmark(4);

        adapter = new ArrayAdapter(BookMarkActivity.this, R.layout.list_item_layout, data.getBookMarks());
        listView.setAdapter(adapter);

        //Create the list
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (BookMarkActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    } // end of on create

    public void stockClickHandler(View v){
        TextView stock = (TextView) v;
        CharSequence stockName = stock.getText();
        Intent i = new Intent(getApplicationContext(),StockActivity.class);
        i.putExtra("stockName",stockName);
        i.putExtra("bookMarks", data.getBookMarks());
        startActivity(i);
    }

}//End of activity