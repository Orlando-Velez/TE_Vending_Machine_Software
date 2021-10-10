package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Transactions extends Inventory {

    List<String> list = new ArrayList<>();

    public List<String> getList(){
        return this.list;
    }

    public void logFile() throws IOException {
        File log = new File("log.txt");
        List<String> list = getList();
        try(FileWriter writer = new FileWriter(log, true)){
            for(String newLog : list){
                writer.write(newLog);
                writer.write("\n");
            }
        }
    }

}