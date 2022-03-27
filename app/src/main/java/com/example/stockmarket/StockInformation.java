package com.example.stockmarket;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StockInformation extends AppCompatActivity {

    //Initiate the list of stocks here
    AppData data = new AppData();
    ArrayList<String> stockData = data.returnStockList(); //The list of stocks is stored here
    int stockPos = -1; //Stock position data is stored here



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_information);
        setPosData();
        String s = stockData.get(stockPos);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            ArrayList<String> keys = extras.getStringArrayList("bookmarks"); //Incoming bookmark data
            data.storeBookMarks(keys);
        }

        Object thing = data.returnBookMarks();

        returnMain();

    }

    //sets the position given position of a stock
    private void setPosData(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("stockPos");
            stockPos = value; //Sets the position
        }
    }

    private void returnMain(){
        Intent activity = new Intent(this, MainActivity.class);
        activity.putExtra("stockPos", stockPos);
        startActivity(activity);
    }


}
