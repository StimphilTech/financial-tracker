package com.pluralsight;

import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
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
    public class Transaction {

    }

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
    public static void main(String[] args) {
        loadTransactions(FILE_NAME);



        Scanner scanner = new Scanner(System.in);
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
                case "D" -> addDeposit(scanner);
                case "P" -> addPayment(scanner);
                case "L" -> ledgerMenu(scanner);
                case "X" -> running = false;
                default -> System.out.println("Exit the Application ");
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
    public static void loadTransactions(String fileName) {
        // TODO: create file if it does not exist, then read each line,
        //       parse the five fields, build a Transaction object,
        //       and add it to the transactions list.




        try {
            FileReader fileReader = new FileReader("transactions.csv");
        }
        ( BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            {
            String line;


            System.out.println("That file exist\n");
            System.out.println("2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50\n");
            System.out.println("2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00\n");
            System.out.println("2023-04-16|14:30:45|Grocery shopping|Walmart|-120.35\n");
            System.out.println("2024-04-17|09:05:10|Gasoline|Shell|-45.00\n");
            System.out.println("2024-04-18|12:30:00|Monthly rent payment|ABC Apartments|-2000.00/\n");
            System.out.println("2024-04-19|15:20:30|Dinner with friends|Cheesecake Factory|-85.20\n");
            System.out.println("2024-04-21|08:45:00|Salary deposit|ABC Company|5000.00\n");
            System.out.println("2024-04-23|14:00:15|Haircut|Mario's Barber Shop|-35.00\n");
            System.out.println("2024-04-24|16:10:00|Online course subscription|Udemy|-70.00\n");

            while (!((line = BufferedReader.readLine()) == null)) {
                System.out.println(line);

                BufferedReader.close();

                catch (IOException FILE_NAME) {
                    System.out.println("Exit The Application.");
                    FILE_NAME.printStackTrace();




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
    private static void addDeposit(Scanner scanner) {
        // TODO
        boolean running = true;
        while (running) {

        System.out.println("Transactions");
            DateTimeFormatter fmt =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("T)Provide the date and time like this: yyyy-MM-dd HH:mm:ss");
        System.out.println("D) Description");
        System.out.println("V) Vendor");
        System.out.println("A) Amount");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> ();
                case "D" -> ();
                case "P" -> ();
                case "R" -> (scanner);
                case "X" -> running = false;
                default -> System.out.println("Exit The Application");

    } SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Same prompts as addDeposit.
     * Amount must be entered as a positive number,
     * then converted to a negative amount before storing.
     */
    private static void addPayment(Scanner scanner) {
         boolean running = true;
                       while (running) {
                //            System.out.println("Ledger");
                //            System.out.println("Choose an option:");
                //            System.out.println("A) All");
                //            System.out.println("D) Deposits");
                //            System.out.println("P) Payments");
                //            System.out.println("R) Reports");
                //            System.out.println("H) Home");
                //
                //            String input = scanner.nextLine().trim();
                //
                //            switch (input.toUpperCase()) {
                //                case "A" -> displayLedger();
                //                case "D" -> displayDeposits();
                //                case "P" -> displayPayments();
                //                case "R" -> reportsMenu(scanner);
                //                case "H" -> running = false;
                //                default -> System.out.println("Invalid option");
    }

    /* ------------------------------------------------------------------
       Ledger menu
       ------------------------------------------------------------------ */
    private static void ledgerMenu(Scanner scanner) {
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
                case "R" -> reportsMenu(scanner);
                case "H" -> running = false;
                default -> System.out.println("Invalid option");
            }
        } private static void ledgerMenu(Scanner scanner) {
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
                                case "R" -> reportsMenu(scanner);
                                case "H" -> running = false;
                                default -> System.out.println("Invalid option");
                            }
    }

    /* ------------------------------------------------------------------
       Display helpers: show data in neat columns
       ------------------------------------------------------------------ */
    private static void displayLedger()


    { /* TODO – print all transactions in column format  */ }

    private static void displayDeposits() { /* TODO – only amount > 0               */ }

    private static void displayPayments() { /* TODO – only amount < 0               */ }

    /* ------------------------------------------------------------------
       Reports menu
       ------------------------------------------------------------------ */
    private static void reportsMenu(Scanner scanner) {
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
                case "2" -> { Period period1m = Period.ofMonths(1); }
                case "3" -> {/* TODO – year-to-date report   */ }
                case "4" -> { Period period1y = Period.ofYears(1);  }
                case "5" -> {/* TODO – prompt for vendor then report "Search by Vendor then report": */ }
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
        boolean running = true;
        while (running) {
            System.out.println("CustomSearch");
            System.out.println("Choose an option:");
            System.out.println("S) Start Date");
            System.out.println("E) End Date");
            System.out.println("D) Description");
            System.out.println("V) Vendor");
            System.out.println("A) Amount");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "S" -> ();
                case "E" -> ();
                case "D" -> customSearch(scanner);
                case "V" -> ;
                case "A" ->
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
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

