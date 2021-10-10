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
    private String message;

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
    public String getMessage() {return message;}
//    public int getCount(){return count;}
//
//    public void decreaseCount(){
//        count -= 1;
//    }
public String message() {
    return "Stuff";
}
}
