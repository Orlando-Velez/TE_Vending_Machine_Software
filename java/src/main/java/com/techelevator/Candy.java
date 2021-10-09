package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product implements Sellable{

    public Candy(String location, String itemName, BigDecimal price, String itemType) {
        super(location, itemName, price, itemType);
    }

    @Override
    public String message() {
        return "Munch Munch, Yum!";
    }
}
