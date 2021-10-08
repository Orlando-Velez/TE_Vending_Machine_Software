package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;

public class Beverages extends Product implements Sellable{


    public Beverages(String itemName, BigDecimal price) {
        super(itemName, price);
    }
}