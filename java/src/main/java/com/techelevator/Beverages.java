package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Product implements Sellable{


    public Beverages(String location, String itemName, BigDecimal price, String itemType) {
        super(location, itemName, price, itemType);
    }

    @Override
    public String message() {
        return  "Glug Glug, Yum!";
    }
}