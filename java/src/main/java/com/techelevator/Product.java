package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Product {
    //Instance Variables
    private String location;
    private String itemName;
    private BigDecimal price;
    private String itemType;
    private int count;

    //Constructor


    public Product(String location, String itemName, BigDecimal price, String itemType){
        this.location = location;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
//        this.count = 5;
    }

    //Getters
    public String getLocation() {return location;}
    public String getItemName(){return itemName;}
    public BigDecimal getPrice(){return price;}
    public String getItemType() {return itemType;}
//    public int getCount(){return count;}
//
//    public void decreaseCount(){
//        count -= 1;
//    }

}
