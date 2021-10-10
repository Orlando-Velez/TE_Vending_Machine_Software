//package com.techelevator;
//
//import java.io.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class Transactions extends Inventory {
//
//    public static void main(String[] args) {
//        DateTimeFormatter currentDay = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(currentDay.format(now));
//    }
//
//    List<String> list = new ArrayList<>();
//
//    public List<String> getList(){
//        return this.list;
//    }
//
//    public void logFile() throws IOException {
//        File log = new File("log.txt");
//        List<String> list = getList();
//        try(FileWriter writer = new FileWriter(log, true)){
//            for(String newLog : list){
//                writer.write(newLog);
////                writer.write("\n");
////                writer.write();
//            }
//        }
//    }
//
//}