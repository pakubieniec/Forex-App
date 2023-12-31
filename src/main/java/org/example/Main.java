package org.example;

import DataModel.*;
import Mappers.JSONMapper;
import services.FetchToTheForexAPI;

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
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        JSONMapper jsonMapper = new JSONMapper();
        DataFromForexApi dataFromForexApi = new DataFromForexApi();
        DataFromForexApi dataFromForexApi2 = new DataFromForexApi();
        String fetchInfo = fetch.getRespondsWithHistoricalDate("2023-01-01");
        String fetchInfo2 = fetch.getRespondsWithLatestDate();
        System.out.println(fetchInfo);
        System.out.println(fetchInfo2);
        dataFromForexApi = jsonMapper.mapJsonToJava(fetchInfo);
        dataFromForexApi2 = jsonMapper.mapJsonToJava(fetchInfo2);
        System.out.println(jsonMapper.mapJsonToJava(fetchInfo));
        System.out.println(dataFromForexApi.getTimestamp());
        System.out.println(dataFromForexApi.getDate());
        System.out.println(dataFromForexApi.isHistorical());
        System.out.println(dataFromForexApi.getRates());
        System.out.println(dataFromForexApi.getBase());
        System.out.println(jsonMapper.mapJsonToJava(fetchInfo2));
        System.out.println(dataFromForexApi2.getTimestamp());
        System.out.println(dataFromForexApi2.getDate());
        System.out.println(dataFromForexApi2.isHistorical());
        System.out.println(dataFromForexApi2.getRates());
        System.out.println(dataFromForexApi2.getBase());
        System.out.println(jsonMapper.mapObjectToJson(dataFromForexApi2));
        System.out.println(dataFromForexApi2);
        System.out.println("---------------------");
    }
}
