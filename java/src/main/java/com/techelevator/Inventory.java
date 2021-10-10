package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;



public class Inventory {

    BigDecimal balance = BigDecimal.ZERO;
    int startQuantity = 5;

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
        if(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("5") && !userInput.equals("10")){
            System.out.println("***Invalid Whole Dollar Amount***");
        }
        else {
            BigDecimal money = new BigDecimal(userInput);
            balance = balance.add(money);
        }
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

    public int getStartQuantity() {
        return startQuantity;
    }

    public void decreaseCount() {
        startQuantity -= 1;
    }

    public Map changeBack() {
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("Quarters", balance.divideToIntegralValue(BigDecimal.valueOf(.25)));
        map.put("Dimes", balance.subtract(balance.divideToIntegralValue(BigDecimal.valueOf(.25)).divide(BigDecimal.valueOf(4))).divideToIntegralValue(BigDecimal.valueOf(.10)));
        map.put("Nickels", balance.subtract(map.get("Quarters").divide(BigDecimal.valueOf(4)).add(map.get("Dimes").divide(BigDecimal.valueOf(10)))).divideToIntegralValue(BigDecimal.valueOf(.05)));
        return map;

    }


    public String dayTime() {
        DateTimeFormatter currentDay = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return currentDay.format(now);
    }

    List<String> list = new ArrayList<>();

    public List<String> getList(){
        return this.list;
    }

    public static void logFile(String message) throws IOException {
        File log = new File("log.txt");
        boolean append = log.exists() ? true : false;
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(log, append))){
                writer.println(message);

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found: " + ex.getMessage());
        }
    }

}
