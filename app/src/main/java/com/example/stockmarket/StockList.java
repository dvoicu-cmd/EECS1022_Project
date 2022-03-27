package com.example.stockmarket;

import java.util.*;

public class StockList {
    private List<Stock> stocks;
    private static StockList instance;

    private StockList(){
        stocks = new ArrayList<>();

        //names
        List<String> stockNames = new ArrayList<>();
        stockNames.add("Intel");
        stockNames.add("Microsoft");
        stockNames.add("Apple");
        stockNames.add("Google");
        stockNames.add("Facebook");
        stockNames.add("Disney");
        stockNames.add("Tesla");
        stockNames.add("Exxon");
        stockNames.add("Nvidia");
        stockNames.add("Qualcomm");
        stockNames.add("Netflix");
        stockNames.add("Micron");

        //descriptions
        List<String> stockDescs = new ArrayList<>();
        stockDescs.add("Inte descl");
        stockDescs.add("Microsoft desc");
        stockDescs.add("Apple desc");
        stockDescs.add("Google");
        stockDescs.add("Facebook");
        stockDescs.add("Disney");
        stockDescs.add("Tesla");
        stockDescs.add("Exxon");
        stockDescs.add("Nvidia");
        stockDescs.add("Qualcomm");
        stockDescs.add("Netflix");
        stockDescs.add("Micron");

        //stock values (for now rnd between 50 and 200)
        List<List<Double>> stockValues = new ArrayList<>();
        for (int i=0; i<stockNames.size(); i++){
            ArrayList<Double> stockMonthlyValues = new ArrayList<>();
            for (int j=0; j<12; j++)
                stockMonthlyValues.add( (new Random().nextInt(15000) + 5000) /100.0);
            stockValues.add(stockMonthlyValues);
        }
        for (int i = 0; i< stockNames.size(); i++)
           stocks.add(new Stock(stockNames.get(i), stockDescs.get(i), stockValues.get(i)));
    }

    public static StockList getInstance(){
        if (instance == null)
            instance = new StockList();
        return instance;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
