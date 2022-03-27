package com.example.stockmarket;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StockInformation extends AppCompatActivity {

    //Initiate the app data
    AppData data = new AppData();
    int stockPos = -1; //Stock position data is stored here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_information);
    }

    /**
     * Methods that are used for changing activities and passing data through the activities
     */

    //sets the position given position of a stock
    private void setPosData(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("stockPos");
            stockPos = value; //Sets the position
        }
    }

    //Returns to the main activity
    private void returnMain(){
        Intent activity = new Intent(this, MainActivity.class);
        activity.putExtra("stockPos", stockPos);
        activity.putExtra("bookmarks",data.returnBookMarks());
        startActivity(activity);
    }


}
