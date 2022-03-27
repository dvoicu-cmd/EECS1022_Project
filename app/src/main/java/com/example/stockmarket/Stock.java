package com.example.stockmarket;

import java.util.*;

public class Stock {
    private String name;
    private String description;
    private List<Double> values;

   public Stock(String name, String description, List<Double> values){
       this.name = name;
       this.description = description;
       this.values = values;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }
}
