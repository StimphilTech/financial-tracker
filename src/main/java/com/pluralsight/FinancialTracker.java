package com.pluralsight;

import jdk.jfr.DataAmount;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * Capstone skeleton – personal finance tracker.
 * ------------------------------------------------
 * File format  (pipe-delimited)
 *     yyyy-MM-dd|HH:mm:ss|description|vendor|amount
 * A deposit has a positive amount; a payment is stored
 * as a negative amount.
 */
public class FinancialTracker {
    static Scanner scanner;
    /* ------------------------------------------------------------------
       Shared data and formatters
       ------------------------------------------------------------------ */
    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transactions.csv";

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    /* ------------------------------------------------------------------
       Main menu
       ------------------------------------------------------------------ */
    public static void main(String[] args) throws IOException {
        loadTransactions();
        //for(Transaction T:transactions){
            //System.out.println(T);
        //}

       scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to TransactionApp");
            System.out.println("Choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D" -> addDeposit();
                case "P" -> addPayment();
                case "L" -> ledgerMenu();
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    /* ------------------------------------------------------------------
       File I/O
       ------------------------------------------------------------------ */

    /**
     * Load transactions from FILE_NAME.
     * • If the file doesn’t exist, create an empty one so that future writes succeed.
     * • Each line looks like: date|time|description|vendor|amount
     */
    public static void loadTransactions() throws IOException {
        // TODO: create file if it does not exist, then read each line,
        //       parse the five fields, build a Transaction object,
        //       and add it to the transactions list.
        File file = new File (FILE_NAME);
        if (!file.exists()){
            file.createNewFile();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String input;

            while((input = reader.readLine()) != null) {
                String[] token = input.split("\\|");
                LocalDate date = LocalDate.parse(token [0]);//add DateFMT
                LocalTime time = LocalTime.parse(token [1]);//add Time_FMT
                String desc = (token [2]);
                String vendor = (token [3]);
                double amt = Double.parseDouble(token [4]);

                transactions.add (new Transaction(amt,date,desc,time,vendor));


            }
            reader.close();

        } catch (IOException e) {
            System.out.println("File cannot be read");;

        }
    }

    /* ------------------------------------------------------------------
       Add new transactions
       ------------------------------------------------------------------ */

    /**
     * Prompt for ONE date+time string in the format
     * "yyyy-MM-dd HH:mm:ss", plus description, vendor, amount.
     * Validate that the amount entered is positive.
     * Store the amount as-is (positive) and append to the file.
     */
    private static void addDeposit() {
        // TODO
        //Comments: Ask the user for the date\time\desc\amt
        //Localdate.parse(User Input,DATE_FMT)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){ //do not use try with resources , use normal try/catch

        System.out.println("Please provide date using \"yyyy-MM-dd\"");
        String userDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(userDate, DATE_FMT);
        System.out.println("Please provide the Time");
        String userTime = scanner.nextLine();
        LocalTime time = LocalTime.parse(userTime,TIME_FMT);
        System.out.println("Please provide the description");
        String desc = scanner.nextLine();
        System.out.println("Please provide the vendor");
        String vendor = scanner.nextLine();

            System.out.println("Please provide the amount");
        double amt = Double.parseDouble(scanner.nextLine());



        // Finish asking everything and then finish to add the transaction array list
        //Bufferedwriter.Appending a new line to a BufferedWriter

            //create the transaction object (a new object(
            Transaction t = new Transaction(amt, date, desc, time, vendor);
            //write the transaction to the file
            writer.write(t + "\n");



    } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Same prompts as addDeposit.
     * Amount must be entered as a positive number,
     * then converted to a negative amount before storing.
     */
    private static void addPayment() {
        // TODO

        try(FileWriter fileWriter = new FileWriter(FILE_NAME); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            bufferedWriter.write("Please provide the date using \"yyyy-MM-dd\"");
            bufferedWriter.write("Please provide the time using \"HH:mm:ss\"");


            //TODO:
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());

        } //end of try catch


    }//enter payment instead of enter deposit


    /* ------------------------------------------------------------------
       Ledger menu
       ------------------------------------------------------------------ */
    private static void ledgerMenu() {
        boolean running = true;

        while (running) {
            System.out.println("Ledger");
            System.out.println("Choose an option:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> reportsMenu();
                case "H" -> running = false;
                default -> System.out.println("Invalid option");
            } //end of the switch statment


        } //end of the while-loop
    }

    /* ------------------------------------------------------------------
       Display helpers: show data in neat columns
       ------------------------------------------------------------------ */
    private static void displayLedger() { /* TODO – print all transactions in column format */

        //enhanced for-loop
        for(Transaction t: transactions){
            System.out.println(t);
        }

    }

    private static void displayDeposits() { /* TODO – only amount > 0               */ }

    private static void displayPayments() { /* TODO – only amount < 0               */ }

    /* ------------------------------------------------------------------
       Reports menu
       ------------------------------------------------------------------ */
    private static void reportsMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {/* TODO – month-to-date report */ }
                case "2" -> {/* TODO – previous month report */ }
                case "3" -> {/* TODO – year-to-date report   */ }
                case "4" -> {/* TODO – previous year report  */ }
                case "5" -> {/* TODO – prompt for vendor then report */ }
                case "6" -> customSearch(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Reporting helpers
       ------------------------------------------------------------------ */
    private static void filterTransactionsByDate(LocalDate start, LocalDate end) {
        // TODO – iterate transactions, print those within the range
    }

    private static void filterTransactionsByVendor(String vendor) {
        // TODO – iterate transactions, print those with matching vendor
    }

    private static void customSearch(Scanner scanner) {
        // TODO – prompt for any combination of date range, description,
        //        vendor, and exact amount, then display matches
    }

    /* ------------------------------------------------------------------
       Utility parsers (you can reuse in many places)
       ------------------------------------------------------------------ */
    private static LocalDate parseDate(String s) {
        /* TODO – return LocalDate or null */
        return null;
    }

    private static Double parseDouble(String s) {
        /* TODO – return Double   or null */
        return null;
    }
}
