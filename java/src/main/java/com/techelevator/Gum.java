package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product implements Sellable{


    public Gum(String location, String itemName, BigDecimal price, String itemType) {
        super(location, itemName, price, itemType);
    }

    @Override
    public String message() {
        return "Chew Chew, Yum!";
    }
}
