package com.example.stockmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SideMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu);

        //For Side Btn
        Button btn = (Button) findViewById(R.id.backButton); //Creating variable of type button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //The event
                openMain();
            }
        });

    }
    public void openMain() {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

}
