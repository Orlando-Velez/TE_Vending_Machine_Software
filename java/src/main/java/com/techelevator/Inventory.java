package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {


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
                }
            if (itemType.equals("Drink")) {
                Beverages beverage = new Beverages(itemName, itemPrice);
                map.put(slot, beverage);
            }

            for(Map.Entry<String, Product> entry : map.entrySet()) {
                String key = entry.getKey();
                Product value = entry.getValue();
                String formatString = String.format("%s: %-15s  $%.2f", key, value.getItemName(), value.getPrice());
                System.out.println(formatString);
            }

        }
        return null;
    }

}
