package com.pluralsight;

import java.util.Scanner;
import java.io.*;

public class Accounting {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        homeScreen();
    }
public static void homeScreen(){
        String choice;

        do{
            System.out.println(
                    """
                     \n === KAL Bank ===
                      === Welcome ===
                     D. Add Deposit
                     P. Make payment
                     L. Ledger
                     X. Exit
                     Choose an option:
                     """
            );
             choice = input.nextLine();
            switch (choice){
                case "D":
                    addDeposit();
                    break;
                case "P":
                    payment();
                    break;
                case "L":
                    ledger();
                    break;
                case "X":
                    System.out.println("Thank you for coming! \nGood bye");
                    break;
                default:
                    System.out.println("please enter a correct letter");
            }
        } while (!choice.equalsIgnoreCase("X"));
}
    public static void writer(LedgerApp currentDeposit){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter("transactions.csv", true));
            String current = currentDeposit.toString();

            br.write(current);

            br.newLine();

            br.close();

        } catch (Exception e) {
            System.out.println("Error writing products file.");
        }
    }
    public static void addDeposit(){
        try {
            System.out.print("Please enter the deposit amount: ");
            double amount = input.nextDouble();
            input.nextLine();

            System.out.print("Please enter the deposit description: ");
            String description = input.nextLine();

            System.out.print("Please enter the deposit vendor: ");
            String vendor = input.nextLine();

            LedgerApp currentDeposit = new LedgerApp(description,vendor,amount);
            System.out.print("Deposit: " + currentDeposit);

            writer(currentDeposit);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading products file.");
        }
    }

    public static void payment(){
        try {
            System.out.print("Please enter the payment amount: ");
            double amount = input.nextDouble()* -1;
            input.nextLine();

            System.out.print("Please enter the payment description: ");
            String description = input.nextLine();

            System.out.print("Please enter the payment vendor: ");
            String vendor = input.nextLine();

            LedgerApp currentPayment = new LedgerApp(description,vendor,amount);
            System.out.print("Payment: " + currentPayment);

            writer(currentPayment);

        } catch (Exception e) {
            System.out.println("Error writing products file.");
        }
    }
    public  static void ledger(){
        String Lchoice;// stands for ledger choice
        while(true){
            System.out.println(
                    """
                     \n=== Ledger === 
                     A. All
                     D. Deposit
                     P. Payment
                     R. Reports
                     H. Home
                     Choose an option:
                     """
            );
            Lchoice = input.nextLine();
            switch (Lchoice){
                case "A":
                    LoadHistory.displayAll();
                    break;
                case "D":
                    LoadHistory.displayDeposit();
                    break;
                case "P":
                    LoadHistory.displayWithdraw();
                    break;
                case "R":
                    Reports.reports();
                    break;
                case "H":
                    homeScreen();
                    break;
                default:
                    System.out.println("please enter a correct letter");
            }
        }
    }
}