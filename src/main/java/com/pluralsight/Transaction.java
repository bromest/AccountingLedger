package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalDate localDate;
    private LocalTime localTime;
    private final String description;
    private final String vendor;
    private final double amount;

    public Transaction(String description, String vendor, double amount) {
        this.description = description;
        this.amount = amount;
        this.vendor = vendor;
        this.localDate = localDate.now();
        this.localTime = localTime.now();
    }

    public Transaction(String description, String vendor, double amount, LocalDate localDate, LocalTime localTime) {
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.localDate = (localDate != null) ? localDate :localDate.now();
        this.localTime = (localDate != null) ? localTime :localTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    // every data format will be like this
    public String toString() {
        return String.format("%s | %s | %s | %s | %.2f",
                localDate.format(dateFormat),
                localTime.format(timeFormat),
                description,
                vendor,
                amount);
    }
}