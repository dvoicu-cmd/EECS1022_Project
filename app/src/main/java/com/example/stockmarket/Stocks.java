package com.example.stockmarket;

import java.util.*;

public class Stocks {
    private Map<String, List<Double>> stockData = new HashMap<>();

    public Stocks(List<String> stockNames, List<List<Double>> stockValues) {
        for (int i = 0; i< stockNames.size(); i++)
            stockData.put(stockNames.get(i), stockValues.get(i));
    }

    public Stocks(List<String> stockNames) {
        List<List<Double>> stockValues = new ArrayList<>();
        for (int i=0; i<stockNames.size(); i++){
            ArrayList<Double> stockMonthlyValues = new ArrayList<>();
            for (int j=0; j<12; j++)
                stockMonthlyValues.add( (new Random().nextInt(15000) + 5000) /100.0);
            stockValues.add(stockMonthlyValues);
        }
        for (int i = 0; i< stockNames.size(); i++)
            stockData.put(stockNames.get(i), stockValues.get(i));
    }

    public Double getStockForMonth(String stockName, int monthNum){
        return stockData.get(stockName).get(monthNum-1);
    }


}
