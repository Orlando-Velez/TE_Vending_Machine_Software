package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product implements Sellable{

    public Gum(String itemName, BigDecimal price) {
        super(itemName, price);
    }
}
