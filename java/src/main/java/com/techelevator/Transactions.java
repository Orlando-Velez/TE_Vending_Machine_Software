package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class Transactions extends VendingMachineCLI{


    public Transactions(Menu menu) {
        super(menu);
    }

    public BigDecimal balanceRemaining() {
//        BigDecimal moneyIn = BigDecimal.valueOf(Long.parseLong(moneyToFeed()));
        BigDecimal moneyIn = new BigDecimal(moneyToFeed());
        String itemOption = itemCode();
//        BigDecimal costOfItem = getInfoFromLine().get(itemOption).getPrice();
        BigDecimal costOfItem = new BigDecimal(String.valueOf(getInfoFromLine().get(itemOption).getPrice()));
        BigDecimal balance = moneyIn.subtract(costOfItem);
        return balance;
    }





}