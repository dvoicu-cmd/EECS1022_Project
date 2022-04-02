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
        stockDescs.add("Description: Intel Corporation, stylized as intel, is an American multinational " +
                "corporation and technology company headquartered in Santa Clara, California. " +
                "It is the world's largest semiconductor chip manufacturer by revenue, and is the " +
                "developer of the x86 series of microprocessors, the processors found in " +
                "most personal computers. P/E ratio: 9.90  Mkt cap: 196.71B  Div yield: 3.03%");
        stockDescs.add("Description: Microsoft Corporation is an American multinational technology corporation " +
                "which produces computer software, consumer electronics, personal computers, " +
                "and related services. Its best-known software products are the Microsoft Windows " +
                "line of operating systems, the Microsoft Office suite, and the Internet Explorer " +
                "and Edge web browsers. P/E ratio: 32.92  Mkt cap: 2.32T  Div yield: 0.80%");
        stockDescs.add("Description: Apple Inc. is an American multinational technology company that specializes" +
                " in consumer electronics, software and online services. Apple is the largest " +
                "information technology company by revenue and, as of January 2021, it is the " +
                "world's most valuable company, the fourth-largest personal computer vendor by " +
                "unit sales and second-largest mobile phone manufacturer. P/E ratio: 28.94  Mkt cap: 2.84T  Div yield: 0.50%");
        stockDescs.add("Description: Google LLC is an American multinational technology company that specializes" +
                " in Internet-related services and products, which include a search engine, online" +
                " advertising technologies, cloud computing, software, and hardware. It is " +
                "considered one of the Big Five American information technology companies, " +
                "alongside Amazon, Apple, Meta and Microsoft. P/E ratio: 25.08  Mkt cap: 1.86T  Div yield: -");
        stockDescs.add("Description: Facebook is an American online social media and social networking service" +
                " owned by Meta Platforms. Founded in 2004 by Mark Zuckerberg with fellow Harvard" +
                " College students and roommates Eduardo Saverin, Andrew McCollum, Dustin " +
                "Moskovitz, and Chris Hughes, its name comes from the face book directories " +
                "often given to American university students. P/E ratio: 16.33  Mkt cap: 612.03B  Div yield: -");
        stockDescs.add("Description: disney.com is a website operated by Disney Digital Network, a division" +
                " of The Walt Disney Company, that promotes various Disney properties such as" +
                " films, television shows, and theme park resorts, and offers entertainment " +
                "content intended for children and families. P/E ratio: 81.30  Mkt cap: 249.43B  Div yield: -");
        stockDescs.add("Description: Tesla, Inc. is an American electric vehicle and clean energy company " +
                "based in Austin, Texas. Tesla designs and manufactures electric cars, battery " +
                "energy storage from home to grid-scale, solar panels and solar roof tiles, and " +
                "related products and services. P/E ratio: 221.31  Mkt cap: 1.12T  Div yield: -");
        stockDescs.add("Description: Exxon Mobil Corporation, stylized as ExxonMobil, is an American " +
                "multinational oil and gas corporation headquartered in Irving, Texas. " +
                "It is the largest direct descendant of John D. Rockefeller's Standard Oil, " +
                "and was formed on November 30, 1999, by the merger of Exxon and Mobil. P/E ratio: 15.46  Mkt cap: 351.90B  Div yield: 4.23%");
        stockDescs.add("Description: Nvidia Corporation is an American multinational technology company " +
                "incorporated in Delaware and based in Santa Clara, California. It is a fabless " +
                "company which designs graphics processing units for the gaming and professional " +
                "markets, as well as system on a chip units for the mobile computing and " +
                "automotive market. P/E ratio: 69.44 Mkt cap: 670.47B  Div yield: 0.060%");
        stockDescs.add("Description: Qualcomm is an American multinational corporation headquartered in San" +
                " Diego, California, and incorporated in Delaware. It creates semiconductors," +
                " software, and services related to wireless technology. It owns patents critical" +
                " to the 5G, 4G, CDMA2000, TD-SCDMA and WCDMA mobile communications standards. P/E ratio: 16.85  Mkt cap: 165.66B  Div yield: 1.85% " +
                "");
        stockDescs.add("Description: Netflix, Inc. is an American subscription streaming service and production" +
                " company. Launched on August 29, 1997, it offers a library of films and television" +
                " series through distribution deals as well as its own productions, known as " +
                "Netflix Originals. P/E ratio: 34.98  Mkt cap: 165.81B  Div yield: -");
        stockDescs.add("Description: Micron Technology, Inc. is an American producer of computer memory and" +
                " computer data storage including dynamic random-access memory, flash memory," +
                " and USB flash drives. It is headquartered in Boise, Idaho. Its consumer " +
                "products are marketed under the brands Crucial and Ballistix. P/E ratio: 9.59  Mkt cap: 85.07B  Div yield: 0.53%");

        //stock values (for now rnd between 50 and 200)
        List<List<Double>> stockValues = new ArrayList<>();
        for (int i=0; i<stockNames.size(); i++){
            ArrayList<Double> stockMonthlyValues = new ArrayList<>();
            for (int j=0; j<12; j++)
                stockMonthlyValues.add( (new Random().nextInt(100000) + 1500) /100.0);
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
