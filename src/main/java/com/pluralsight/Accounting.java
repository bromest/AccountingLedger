package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Accounting {

    static Scanner input = new Scanner(System.in);
    static ArrayList<> cart = new ArrayList<>();
    static ArrayList<> products = new ArrayList<>();

    public static void main(String[] args) {
        homeScreen();
    }
public static void homeScreen(){
        char choice;

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
            choice = input.next().charAt(0);
            switch (choice){
                case 'D':

            }
        }
}
}
