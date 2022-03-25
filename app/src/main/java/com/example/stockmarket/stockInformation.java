package com.example.stockmarket;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class stockInformation extends AppCompatActivity {

    //Initiate the list of stocks here
    stockList stocks = new stockList();
    ArrayList<String> stockData = stocks.returnStockList(); //The list of stocks is stored here
    int stockPos = -1; //Stock position data is stored here


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_information);
        setPosData();
        String s = stockData.get(stockPos);
    }

    //sets the position given position of a stock
    private void setPosData(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("stockPos");
            stockPos = value; //Sets the position
        }
    }

}
