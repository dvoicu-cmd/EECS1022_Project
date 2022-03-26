package com.example.stockmarket;

import java.util.ArrayList;
import java.util.List;

public class stockList {
    ArrayList stocklist = new ArrayList<String>();

    public stockList(){
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
    }

    public ArrayList<String> returnStockList(){
        return stocklist;
    }
}
