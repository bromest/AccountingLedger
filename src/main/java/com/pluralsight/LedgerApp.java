package com.pluralsight;

public class LedgerApp {
    private String description;
    private double amount;
    private String vendor;
    private int debit;

    public LedgerApp(String description, double amount, String vendor, int debit) {
        this.description = description;
        this.amount = amount;
        this.vendor = vendor;
        this.debit = debit;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getVendor() {
        return vendor;
    }

    public int getDebit() {
        return debit;
    }
}