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
    Set bookMarksSet = new HashSet<String>();

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

    public ArrayList<String> getStockList(){
        return (ArrayList) stockList;
    }

    public boolean contains(String s){
        boolean condition = false;
        bookMarksSet.clear();
        for(int i = 0; i< stockList.size(); i++){
            if(bookMarks.get(i) != null){
                bookMarksSet.add(bookMarks.get(i));
            }
        }
        condition = bookMarksSet.contains(s);
        return condition;
    }

    //Adds a stock at a given position value to the bookmark map
    //v = position value of the array list
    public void addToBookmark(int k){
        //First extract data from stockList with given input
        Integer key = k;
        String value = (String) stockList.get(k);
        //Then put the values into the map
        bookMarks.put(key,value);
    }

    public void addToBookmark(String v){
        String value = v;
        Integer key = stockList.indexOf(v);
        bookMarks.put(key,value);
    }

    //Removes a stock at a given position value to the bookmark map
    public void removeFromBookmark(int k){
        Integer key = k;
        bookMarks.remove(key);
    }

    public void removeFromBookmark(String v){
        String value = v;
        Integer key = stockList.indexOf(value);
        bookMarks.remove(key);
    }

    //Returns a list of bookedMarked stocks
    public ArrayList<String> getBookMarks(){
        ArrayList<String> outPut = new ArrayList(); //List to output
        //Fill an array list with the values of book marks then return it
        for(int i = 0; i<=stockList.size(); i++){
            if(bookMarks.get(i) != null){
                outPut.add((String)bookMarks.get(i));
            }
        }
        return outPut;
    }

    //Stores the inputted array list into the hashmap
    public void storeBookMarks(ArrayList<String> input){
        //Find pos/key value based on the list then store it with a key value pair
        int f = input.size();
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
