package util;

import DataModel.DataFromForexApi;
import DataModel.ExchangeRate;
import Mappers.JSONMapper;
import services.FetchToTheForexAPI;
import services.SaveToCsvFile;

import java.util.Scanner;

public class CommunicateWithUser {
    String date;
    int day = 1;
    Scanner scanner = new Scanner(System.in);
    FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    ExchangeRate exchangeRate = new ExchangeRate();
    JSONMapper mapper = new JSONMapper();
    SaveToCsvFile saveToCsvFile = new SaveToCsvFile();

    public void interaction() {
        System.out.println("""
                                
                -------     Welcome in Forex App :-)     -------
                                
                Do you want to know the exchange rates for today or for another day?
                                
                Enter:
                1: Today
                2: Before
                """);
        askAboutCurrency();
        changeMoney();
        printThanksForUseApp();
    }

    private void askAboutCurrency() {
        day = Integer.parseInt(scanner.nextLine());
        switch (day) {
            case 1 -> {
                DataFromForexApi dataLatest = mapper.mapJsonToJava(fetch.getRespondsWithLatestDate());
                System.out.printf("Today: %s the %s is%5.2f. %n %n", dataLatest.getDate(), dataLatest.getBase(), exchangeRate.getExchangeRate(date));
            }
            case 2 -> {
                System.out.println("Enter the date (YYYY-MM-DD): ");
                date = scanner.nextLine();
                DataFromForexApi dataHistorical = mapper.mapJsonToJava(fetch.getRespondsWithHistoricalDate(date));
                System.out.printf("%s the %s is%5.2f. %n %n", dataHistorical.getDate(), dataHistorical.getBase(), exchangeRate.getExchangeRate(date));
            }
        }
    }

    private void changeMoney() {
        System.out.println("""
                Do you want to check exchange currency EURO -> PLN ?
                1: Yes
                2: No, Exit of Forex App
                """);
        int answer = scanner.nextInt();
        if (answer == 1) {
            System.out.println("Enter the amount of euros to exchange");
            double amount = scanner.nextDouble();
            System.out.printf("At this exchange rate you would get %5.2f zl. %n %n", exchangeRate.convertedCurrency(amount, date));
            saveDataToCSV(amount);
        } else {
            System.out.println("Visit Us again :-)");
        }
    }

    private void saveDataToCSV(double exchangeAmount) {
        System.out.println("""
                Do you want to save transactions to a CSV file?
                1: Yes
                2: No
                """);
        int answer = scanner.nextInt();
        if (answer == 1) {
            saveToCsvFile.addDataToCSV("src/main/java/files/exchangeRate.csv", exchangeAmount, date);
        } else {
            System.out.println("Visit Us again :-)");
        }
    }

    private void printThanksForUseApp() {
        System.out.println("""
                Thank you for using our application.
                We invite you again :-)
                """);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


