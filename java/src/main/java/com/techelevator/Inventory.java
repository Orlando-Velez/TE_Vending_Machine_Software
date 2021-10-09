package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;



public class Inventory {
    BigDecimal balance = BigDecimal.ZERO;
    Integer startQuantity = 5;

    Scanner reader = new Scanner(System.in);

    File fileInfo = new File("vendingmachine.csv");


    public ArrayList<String[]> getFile() {

        ArrayList<String[]> fileArray = new ArrayList<>();

        try (Scanner reader = new Scanner(fileInfo)) {
            while (reader.hasNextLine()) {
                String lineInput = reader.nextLine();
                String[] fileOutput = lineInput.split("\\|");
                fileArray.add(fileOutput);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        }

        return fileArray;
    }

    public Map<String, Product> getInfoFromLine() {
        Map<String, Product> map = new TreeMap<>();

        for (String[] display : getFile()) {
                String slot = display[0];
                String itemName = display[1];
                String itemType = display[3];
                BigDecimal itemPrice = BigDecimal.ZERO;
                try{
                    itemPrice = new BigDecimal(display[2]);
                } catch (NumberFormatException ex) {
                    String message = String.format("Failed to parse info line");
                    System.out.println(message);
                }
            if (itemType.equals("Drink")) {
                Product beverage = new Product(slot, itemName, itemPrice, itemType);
                map.put(slot, beverage);
            }
            else if (itemType.equals("Chip")) {
                Product chips = new Product(slot, itemName, itemPrice, itemType);
                map.put(slot, chips);
            }
            else if (itemType.equals("Candy")) {
                Product candy = new Product(slot, itemName, itemPrice, itemType);
                map.put(slot, candy);
            }
            else if (itemType.equals("Gum")) {
                Product gum = new Product(slot,itemName,itemPrice,itemType);
                map.put(slot, gum);
            }


        }
        return map;
    }

    public BigDecimal moneyToFeed() {

        System.out.println("Insert money in  whole dollar amounts: $1, $2, $5, or $10");
        String userInput = reader.nextLine();
        BigDecimal money = new BigDecimal(userInput);
        balance = balance.add(money);
        return balance;
    }

    public String itemCode(){

        System.out.println();
        System.out.println("Please make a selection: ");
        String userInput = reader.nextLine();
        return userInput;
    }

    public BigDecimal balanceRemaining(Product item) {
        balance = balance.subtract(item.getPrice());
        return balance;
    }

    public Integer stockQuantity(Product quantity) {
       int stock = quantity.getCount();
       return stock;
    }
//    public Integer decrease(Product quantity) {
//        int stock = quantity.decreaseCount();
//        return stock;
//    }
    public int get() {return ;}
public int decreaseCount(){
    startQuantity -= 1;
    return startQuantity;
}


}
