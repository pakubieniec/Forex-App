package org.example;

import services.FetchToTheForexAPI;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FetchToTheForexAPI fetch = new FetchToTheForexAPI();
        System.out.println(fetch.getRespondsWithLatestDate());
        System.out.println(fetch.getRespondsWithHistoricalDate("2023-02-10"));

        System.out.println("--------------------------");
        System.out.println("Welcome in Forex App :-)");
        System.out.println("Enter the date (format YYYY-MM-DD) to check the currency rate: ");
        String date = scanner.nextLine().toLowerCase();
        if (date.isEmpty()) {
            System.out.println(fetch.getRespondsWithLatestDate());
        } else {
            System.out.println(fetch.getRespondsWithHistoricalDate(date));
        }
        System.out.println("--------------------------");
    }
}
