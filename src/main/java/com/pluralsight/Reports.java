package com.pluralsight;

import java.time.LocalDate;

import static com.pluralsight.Accounting.input;
import static com.pluralsight.LoadHistory.history;
import static com.pluralsight.LoadHistory.loadHistory;

public class Reports {
    public static void reports(){

        int rChoice;
    do{
        System.out.println(
                """
                 \n=== Reports Menu ===
                 1. Month To Date
                 2. Previous Month
                 3. Year To Date
                 4. Previous Year
                 5. Search by Vendor
                 0. Back (Return to Ledger)
                 Choose an option:
                 """
        );
        rChoice = input.nextInt();
        input.nextLine();

        switch (rChoice) {
            case 1:
                monthToDate();
                break;
            case 2:
                previousMonth();
                break;
            case 3:
                yearToDate();
                break;
            case 4:
                previousYear();
                break;
            case 5:
                byVendor();
                break;
            case 0:
                break;
            default:
                System.out.println("please enter a valid option");
        }
    } while (rChoice == 0);
    }
    public static void monthToDate(){
        loadHistory();
        LocalDate currentDate = LocalDate.now();

        System.out.println("\n=== Month To Date Reports === ");

        boolean found = false;

        for(int i = history.size() - 1 ; i>=0 ; i--){

            LedgerApp entry = history.get(i);

            String[] section = entry.toString().split("\\|");
            LocalDate entryDate = LocalDate.parse(section[0].trim());


            if(entryDate.getDayOfYear() == currentDate.getDayOfYear() &&  entryDate.getMonth() == currentDate.getMonth()) {
                    System.out.println(entry);
                    found = true;
            }
        }
        if (!found){
        System.out.println("No transaction found on this Date.");
        }
    }
    public static void previousMonth() {
        loadHistory();
        LocalDate target = LocalDate.now().minusMonths(1);

        System.out.println("\n=== Previous Month Reports === ");

        boolean found = false;

        for (int i = history.size() - 1; i >= 0; i--) {
            LedgerApp entry = history.get(i);
            String[] section = entry.toString().split("\\|");
            LocalDate entryDate = LocalDate.parse(section[0].trim());

            if (entryDate.getYear() == target.getYear() && entryDate.getMonthValue() == target.getMonthValue()) {
                System.out.println(entry);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transaction found for previous month.");
        }
    }
    public static void yearToDate(){
        loadHistory();

        int currentYear = LocalDate.now().getYear();

        System.out.println("\n=== Year To Date Reports === ");
        boolean found = false;

        for (int i = history.size() - 1; i >= 0; i--) {

            LedgerApp entry = history.get(i);

            String[] section = entry.toString().split("\\|");
            LocalDate entryDate = LocalDate.parse(section[0].trim());

            if (entryDate.getYear() == currentYear) {
                System.out.println(entry);
                found = true;
            }
            if (!found) {
                System.out.println("No transaction found this current year.");
            }
        }
    }
    public static void previousYear(){
        loadHistory();
        int targetYear = LocalDate.now().getYear() - 1;
        System.out.println("\n=== Previous Year Reports === ");
        boolean found = false;

        for(int i = history.size() - 1; i >= 0; i--){

            LedgerApp entry = history.get(i);

            String[] section = entry.toString().split("\\|");
            LocalDate entryDate = LocalDate.parse(section[0].trim());

            if (entryDate.getYear() == targetYear) {
                System.out.println(entry);
                found = true;
            }
            if (!found) {
                System.out.println("No transaction found this year.");
            }
        }
    }
    public static void byVendor(){
        loadHistory();
        input.nextLine();

        System.out.println("Enter vendor name: ");
        String vendorName = input.nextLine().trim();

        System.out.println("\n=== Vendor: " + vendorName + "=== ");
        boolean found = false;

        for (int i = history.size() - 1; i >= 0; i--) {
            LedgerApp entry = history.get(i);

            if(entry.getVendor().equalsIgnoreCase(vendorName)){
                System.out.println(entry);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transaction found for this vendor.");
        }
    }
}
