package org.example;

import DataModel.ExchangeRate;
import DataModel.ExchangeRateDTO;
import DataModel.ExchangeRateInfo;
import DataModel.ExchangeRateInfoDTO;
import Mappers.ExchangeRateInfoMapper;
import Mappers.ExchangeRateMapper;
import services.FetchToTheForexAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FetchToTheForexAPI fetch = new FetchToTheForexAPI();
        ExchangeRateInfo exchangeRateInfo = new ExchangeRateInfo();
        ExchangeRateInfoDTO exchangeRateInfoDTO = new ExchangeRateInfoDTO();
        ExchangeRate exchangeRate = new ExchangeRate();
        ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO();
        System.out.println(fetch.getRespondsWithLatestDate());
        System.out.println(fetch.getRespondsWithHistoricalDate("2023-02-10"));

        System.out.println("--------------------------");
        System.out.println("Welcome in Forex App :-)");
        System.out.println("Enter the date (format YYYY-MM-DD) to check the currency rate: ");

        exchangeRateInfo.setDate(scanner.nextLine());
        String date = exchangeRateInfo.getDate();
        System.out.println(date);

        if (date.isEmpty()) {
            System.out.println(fetch.getRespondsWithLatestDate());
        } else {
            System.out.println(fetch.getRespondsWithHistoricalDate(date));
        }

        System.out.println("--------------------------");

        exchangeRateInfo.writeValueCurrencyExchangeToList();
        exchangeRateInfo.writeValueCurrencyExchangeToList(date);

        System.out.println(exchangeRateInfo.getListDataFromForexApi());
        System.out.println("--------------------------");
        System.out.println(exchangeRate.convertedCurrency(100));

    }
}
