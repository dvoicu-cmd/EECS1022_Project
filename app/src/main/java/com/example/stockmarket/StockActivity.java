package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;


public class StockActivity extends AppCompatActivity {

    GraphView graphView;
    String stockName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        // on below line we are initializing our graph view.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            stockName = extras.getString("stockName");
            //The key argument here must match that used in the other activity
        }
        graphView = findViewById(R.id.idGraphView);
        List<String> stocklist = new ArrayList<>();
        stocklist.add("Intel");
        stocklist.add("Microsoft");
        stocklist.add("Apple");
        stocklist.add("Google");
        stocklist.add("Facebook");
        stocklist.add("Disney");
        stocklist.add("Tesla");
        stocklist.add("Exxon");
        stocklist.add("Nvidia");
        stocklist.add("Qualcomm");
        stocklist.add("Netflix");
        stocklist.add("Micron");
        Stocks stocks = new Stocks(stocklist);
        DataPoint[] datapoints = new DataPoint[12];
        for (int i=0;i<12;i++){
            datapoints[i] = new DataPoint(i, stocks.getStockForMonth(stockName, i+1));
        }
        // on below line we are adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(datapoints);

        // after adding data to our line graph series.
        // on below line we are setting
        // title for our graph view.
        graphView.setTitle("My Graph View");

        // on below line we are setting
        // text color to our graph view.
        graphView.setTitleColor(R.color.purple_200);

        // on below line we are setting
        // our title text size.
        graphView.setTitleTextSize(30);

        // on below line we are adding
        // data series to our graph view.
        graphView.addSeries(series);
        TextView description = (TextView) findViewById(R.id.description);
        description.setText( stockName + "is fucking great!\nfuck android!");
        TextView stockNameView = (TextView) findViewById(R.id.stockName);
        stockNameView.setText(stockName);
    }
}