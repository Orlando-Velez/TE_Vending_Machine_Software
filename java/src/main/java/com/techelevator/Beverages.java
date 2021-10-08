package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Product implements Sellable{


    public Beverages(String itemName, BigDecimal price) {
        super(itemName, price);
    }

    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }
}