package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookMarkActivity extends AppCompatActivity {
    int number = 0;
    String[] stockList = {"Apple" , "Tesla" , "Google" , "Amazon"};
    Button btn = (Button) findViewById(R.id.button2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_mark);
    }

    public void onClick(View view) {
        TextView text = (TextView) findViewById(R.id.textView);
        number++;
        for(int i = 0; i < stockList.length; i++){
            text.setText(stockList[i]);
        }

    }
}