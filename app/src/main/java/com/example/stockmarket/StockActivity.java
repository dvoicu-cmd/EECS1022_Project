package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            stockName = extras.getString("stockName");
        }

        graphView = findViewById(R.id.idGraphView);

        //get stock data
        List<Stock> stocks = StockList.getInstance().getStocks();
        Stock stock = null;
        for (Stock s : stocks)
            if (s.getName().equals(stockName))
                stock = s;

        DataPoint[] datapoints = new DataPoint[12];
        for (int i=0;i<12;i++){
            datapoints[i] = new DataPoint(i+1, stock.getValues().get(i));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(datapoints);

        graphView.setTitle(stock.getName());
        graphView.setTitleColor(R.color.purple_200);
        graphView.setTitleTextSize(30);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(12);
        graphView.addSeries(series);

        TextView description = (TextView) findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());
        description.setText( stock.getDescription());
        TextView stockNameView = (TextView) findViewById(R.id.stockName);
        stockNameView.setText(stock.getName()+" stock in 12 months");
    }
}