package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BookMarkActivity extends AppCompatActivity {

    //Init app data
    AppData data = new AppData();

    //Activity Data
    ArrayList<String> stockList = data.getStockList(); //The list of stocks
    ArrayList<String> bookMarks = data.getBookMarks();
    boolean temp = false;



    int number = 0;
    //String[] stockList = {"Apple" , "Tesla" , "Google" , "Amazon"};
    //Button btn = (Button) findViewById(R.id.button2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_mark);

        //Get bundle of inputted data and apply it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            temp = extras.getBoolean("temp");
        }


        //On Click for mainPage to go back to main page
        Button btn = (Button) findViewById(R.id.mainPageBtn); //Creating variable of type button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("bookMarks", data.getBookMarks());
                i.putExtra("temp", temp);
                startActivity(i);
            }
        });

    } // end of on create



    public void onClick(View view) {
        TextView text = (TextView) findViewById(R.id.textView);
        number++;
 //       for(int i = 0; i < stockList.length; i++){
 //           text.setText(stockList[i]);
        }

    }//End of activity