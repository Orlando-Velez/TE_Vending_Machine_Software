package com.techelevator;

import java.io.File;
import java.math.BigDecimal;

public class Beverages extends Product implements Sellable{

    public Beverages(String itemName, BigDecimal price) {
        super(itemName, price);
    }

}