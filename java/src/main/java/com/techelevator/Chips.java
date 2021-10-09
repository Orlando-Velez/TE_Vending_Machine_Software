package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Product implements Sellable {

    public Chips(String location, String itemName, BigDecimal price, String itemType) {
        super(location, itemName, price, itemType);
    }

    @Override
    public String message() {
        return "Crunch Crunch, Yum!";
    }
}
