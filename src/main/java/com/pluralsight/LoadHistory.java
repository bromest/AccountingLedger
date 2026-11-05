package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class LoadHistory {
    static ArrayList<LedgerApp> history = new ArrayList<>();
    public static void loadHistory(){

        history.clear();

        try{
            BufferedReader br = new BufferedReader(new FileReader("transactions.csv"));
            String line;
            while ((line = br.readLine()) != null){

                if(line.trim().isEmpty()|| line.toLowerCase().startsWith("date")) continue; // skips empty lines and The title line

                String[] section = line.split("\\|");

                if (section.length >= 5){
                    String description = section[2];
                    String vendor = section[3];
                    double amount = Double.parseDouble(section[4]);

                    LedgerApp entry = new LedgerApp(description,vendor,amount);
                    history.add(entry);
                }
            }
            br.close();
            System.out.println(history);

        } catch (FileNotFoundException e) {
            System.out.println("No transaction found yet. please try again later.");
        }
        catch(IOException e){
            System.err.println("Error loading history");
        }
    }
    public static void displayAll(){

        loadHistory();

        System.out.println("\n=== All transactions ===");
        if(history.isEmpty()){
            System.out.println("No transactions found.");
        }

        for(int i = history.size()-1; i>=0 ; i--){
            System.out.println(history.get(i));
        }
    }
    public static void displayDeposit(){
        loadHistory();
        System.out.println("\n=== Deposits ===");
        boolean found = false;
        for(int i = history.size()-1; i>=0 ; i--){
            LedgerApp entry = history.get(i);
            if(entry.getAmount() > 0){
                System.out.println(entry);
                found = true;
            }
        }if (!found){
            System.out.println("No deposited transactions found.");
        }
    }
    public static void displayWithdraw(){
        loadHistory();
        System.out.println("\n=== Payments ===");
        boolean found = false;
        for(int i = history.size()-1; i>=0 ; i--){
            LedgerApp entry = history.get(i);
            if(entry.getAmount() < 0){
                System.out.println(entry);
                found = true;
            }
        }
        if(!found){
            System.out.println("No payment found.");
        }
    }
}
