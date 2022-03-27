package com.example.stockmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SideMenu extends AppCompatActivity {

    AppData data = new AppData();
    ArrayList<String> s;
    boolean bo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu);

        //For Side Btn
        Button btn = (Button) findViewById(R.id.backButton); //Creating variable of type button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //The event
                checkOfData();
                openMain();
            }
        });

    }

    /*
     * OUTPUTS
     */


    public void openMain() {
        Intent activity = new Intent(this, MainActivity.class);

        //DEBUG: Send the data back
        activity.putExtra("bookmarks", s);
        activity.putExtra("firstboot", bo);

        startActivity(activity);
    }


    /*
     * INPUTS
     */

    private void checkOfData(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s = extras.getStringArrayList("bookmarks");
            bo = extras.getBoolean("firstboot");

        }
    }

}
