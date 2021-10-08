package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
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
    // Set default values at 5
    public int productQuantity() {
        //this is the counter
        int startCount = 5;
            for (int i = startCount; i > 0; i--) {
                if (startCount > 0) {
                    return startCount--;
                }
                else {
                    return 0;
                }
            }

            return 0;
    }


}
