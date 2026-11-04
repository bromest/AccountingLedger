package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LedgerApp {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    private String description;
    private String vendor;
    private double amount;

    public LedgerApp(String description, String vendor, double amount) {
        this.description = description;
        this.amount = amount;
        this.vendor = vendor;

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

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %.2f",
                LocalDate.now().format(dateFormat),
                LocalTime.now().format(timeFormat),
                description,
                vendor,
                amount);
    }
}