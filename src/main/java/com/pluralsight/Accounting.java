package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Accounting {

    static Scanner input = new Scanner(System.in);
    static ArrayList<LedgerApp>  A = new ArrayList<>();

    public static void main(String[] args) {
        homeScreen();
    }
public static void homeScreen(){
        String choice;

        do{
            System.out.println(
                    """
                     === KAL Bank ===
                     === Welocom ===
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
                    break;
                case "L":
                    break;
                case "X":
                    break;
                default:
                    System.out.println("please enter a correct letter");
            }
        } while (!choice.equalsIgnoreCase("X"));
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

            LedgerApp currentDeposit = new LedgerApp(description,amount,vendor);
            System.out.print("Deposit: " + currentDeposit);

            writer(currentDeposit);

        } catch (Exception e) {
            System.out.println("Error reading products file.");
        }
    }
    public static void writer(LedgerApp currentDeposit){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter("transactions.csv", true));
            br.write(String.format("%s \n", currentDeposit));
            br.newLine();

        } catch (Exception e) {
            System.out.println("Error writing products file.");
        }
    }
}
