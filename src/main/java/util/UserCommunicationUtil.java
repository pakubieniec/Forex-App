package util;

import DataModel.DataFromForexApi;
import DataModel.ExchangeRate;
import Mappers.JSONMapper;
import services.CurrencyOperations;
import services.FetchToTheForexAPI;
import services.SaveToCsvFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserCommunicationUtil {
    private String date;
    private int day = 1;
    private final Scanner scanner = new Scanner(System.in);
    private final FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    private final CurrencyOperations currencyOperations = new CurrencyOperations();
    private final JSONMapper mapper = new JSONMapper();
    private final SaveToCsvFile saveToCsvFile = new SaveToCsvFile();

    public void interaction() {
        System.out.println("""
                                
                -------     Welcome in Forex App :-)     -------
                                
                Do you want to know the exchange rates for today or for another day?
                                
                Enter:
                1: Today
                2: Before
                """);
        askAboutCurrency();
    }

    private void askAboutCurrency() {
        try {
            day = Integer.parseInt(scanner.nextLine());
            switch (day) {
                case 1 -> {
                    DataFromForexApi dataLatest = mapper.mapJsonToJava(fetch.getRespondsWithLatestDate());
                    System.out.printf("Today: %s the %s is%5.2f. %n %n", dataLatest.getDate(), dataLatest.getBase(), currencyOperations.getExchangeRate(date));
                    askToChangeMoney();
                }
                case 2 -> {
                    System.out.println("Enter the date (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    DataFromForexApi dataHistorical = mapper.mapJsonToJava(fetch.getRespondsWithHistoricalDate(date));
                    System.out.printf("%s the %s is%5.2f. %n %n", dataHistorical.getDate(), dataHistorical.getBase(), currencyOperations.getExchangeRate(date));
                    askToChangeMoney();
                }
                default -> {
                    badAnswer();
                }
            }
        } catch (NumberFormatException e) {
            printTryAgainApp();
        }
    }

    private void badAnswer() {
        try {
            boolean flag = true;
            while (flag) {
                System.out.println("No correct number. Enter 1 or 2.");
                day = Integer.parseInt(scanner.nextLine());
                if (day == 1 || day == 2) {
                    changeMoney();
                    flag = false;
                }
            }
        } catch (NumberFormatException e) {
            printTryAgainApp();
        }
    }

    private void askToChangeMoney() {
        try {
            System.out.println("""
                    Do you want to check exchange currency EURO -> PLN ?
                    1: Yes
                    2: No, Exit of Forex App
                    """);
            int answer = scanner.nextInt();
            if (answer == 1) {
                System.out.println("Enter the amount of euros to exchange");
                changeMoney();
            } else {
                printThanksForUseApp();
            }
        } catch (InputMismatchException e) {
            e.getMessage();
            printThanksForUseApp();
        }
    }

    private void changeMoney() {
        try {
            double amount = scanner.nextDouble();
            boolean flag = true;
            while (flag) {
                if (amount > 0) {
                    System.out.printf("At this exchange rate you would get %5.2f zl. %n %n", currencyOperations.convertedCurrency(amount, date));
                    saveDataToCSV(amount);
                    printThanksForUseApp();
                    flag = false;
                } else {
                    System.out.println("You pass the wrong value");
                    System.out.println("Enter the correct amount of euros to exchange");
                    amount = scanner.nextDouble();
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
            System.out.println("You have entered incorrect data");
            printTryAgainApp();
        }
    }

    private void saveDataToCSV(double exchangeAmount) {
        try {
            System.out.println("""
                    Do you want to save transactions to a CSV file?
                    1: Yes
                    2: No
                    """);
            int answer = scanner.nextInt();
            if (answer == 1) {
                saveToCsvFile.addDataToCSV("src/main/java/files/exchangeRate.csv", exchangeAmount, date);
                printThanksForUseApp();
            }
        } catch (NumberFormatException e) {
            e.getMessage();
            printThanksForUseApp();
        }
    }

    private void printThanksForUseApp() {
        System.out.println("""
                --------------------------------------
                Thank you for using our application.
                We invite you again :-)
                --------------------------------------
                """);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printTryAgainApp() {
        System.out.println("""
                --------------------------------------
                You didn't enter the correct number.
                --------------------------------------
                If you want to use the application,
                try turning it on again.
                --------------------------------------
                NEXT TIME - Please enter the required data.
                --------------------------------------
                """);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



