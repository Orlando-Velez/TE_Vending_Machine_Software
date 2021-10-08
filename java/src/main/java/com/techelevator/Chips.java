package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Product implements Sellable{

    public Chips(String itemName, BigDecimal price) {
        super(itemName, price);
    }
}
