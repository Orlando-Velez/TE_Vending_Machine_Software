package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product implements Sellable{

    public Candy(String itemName, BigDecimal price) {
        super(itemName, price);
    }
}
