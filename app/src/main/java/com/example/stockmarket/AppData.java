package com.example.stockmarket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//This is our consistent list of stocks to the project.
//With this class you will be able to access the stocks and their positional information from this class.

public class AppData {
    List stockList = new ArrayList<String>();
    Map bookMarks = new HashMap<Integer,String>(); //Integer = key, String = value, | key = the position of the stock in the arrayList, value = the name of stock.

    public AppData(){
        //Add Stocks here
        stockList.add("Intel");
        stockList.add("Microsoft");
        stockList.add("Apple");
        stockList.add("Google");
        stockList.add("Facebook");
        stockList.add("Disney");
        stockList.add("Tesla");
        stockList.add("Exxon");
        stockList.add("Nvidia");
        stockList.add("Qualcomm");
        stockList.add("Netflix");
        stockList.add("Micron");
    }

    public ArrayList<String> returnStockList(){
        return (ArrayList) stockList;
    }

    //Adds a stock at a given position value to the bookmark map
    //v = position value of the array list
    public void addToBookmark(int v){
        //First extract data from stockList with given inputs
        Integer value = v;
        String key = (String) stockList.get(v);
        //Then put the values into the map
        bookMarks.put(value,key);
    }

    //Returns a list of bookedMarked stocks
    public ArrayList<String> returnBookMarks(){
        ArrayList<String> outPut = new ArrayList(); //List to output
        //Fill an array list with the values of book marks then return it
        for(int i = 0; i<stockList.size(); i++){
            if(bookMarks.get(i) != null){
                outPut.add((String)bookMarks.get(i));
            }
        }
        return outPut;
    }

    //Stores the inputted array list into the hashmap
    public void storeBookMarks(ArrayList<String> input){
        //Find pos/key value based on the list then store it with a key value pair
        bookMarks.clear();
        for(int i = 0; i<input.size(); i++){
            String value = input.get(i);
            int key = -1;
            key = stockList.indexOf(value);
            if(key == -1){
                throw new NullPointerException(); //one of the values was not was not the same as the list
            }
            else {
                bookMarks.put(key,value);
            }
        }
    }

}
