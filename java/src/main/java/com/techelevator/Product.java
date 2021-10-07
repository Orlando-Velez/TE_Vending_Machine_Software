package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Product {
    //Instance Variables
    private String location;
    //product name
    private String itemName;
    private BigDecimal price;
    private String itemType;

    //Constructor
    public Product(String location, String itemName, BigDecimal price, String itemType) {
        this.location = location;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
    }

    //Getters
    public String getLocation() {return location;}
    public String getItemName(){return itemName;}
    public BigDecimal getPrice(){return price;}
    public String getItemType() {return itemType;}

    //Method
    public Map<String, BigDecimal> itemCost = new HashMap<>();

}
