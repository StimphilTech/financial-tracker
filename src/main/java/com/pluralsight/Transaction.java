package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

   private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(double amount, LocalDate date, String description, LocalTime time, String vendor) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.time = time;
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
//        return "Transaction{" +
//                "amount=" + amount +
//                ", date=" + date +
//                ", time=" + time +
//                ", description='" + description + '\'' +
//                ", vendor='" + vendor + '\'' +
//                '}';

        return date+"|"+time+"|"+description+"|"+vendor+"|"+amount;


    }
}
