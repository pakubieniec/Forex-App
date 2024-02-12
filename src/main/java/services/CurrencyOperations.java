package services;

import DataModel.DataFromForexApi;
import DataModel.ExchangeRate;
import Mappers.JSONMapper;

import java.util.HashMap;
import java.util.Objects;

public class CurrencyOperations {
//    private double exchangeAmount;
    private FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    private DataFromForexApi dataFrom = new DataFromForexApi();
    private JSONMapper mapper = new JSONMapper();

    public double getExchangeRateToBeConverted(String date) {
        setFetchToTheForexApi(date);
        HashMap maps = (HashMap) dataFrom.getRates();
        return (double) maps.get("PLN");
    }

    public double getExchangeRate(String date) {
        setFetchToTheForexApi(date);
        HashMap maps = (HashMap) dataFrom.getRates();
        return roundTo2DecimalPlace((double) maps.get("PLN"));
    }

    private void setFetchToTheForexApi(String date) {
        if (Objects.equals(date, null)) {
            String fetchInfo = fetch.getRespondsWithLatestDate();
            dataFrom = mapper.mapJsonToJava(fetchInfo);
        } else {
            String fetchInfo = fetch.getRespondsWithHistoricalDate(date);
            dataFrom = mapper.mapJsonToJava(fetchInfo);
        }
    }
    public double convertedCurrency(double exchangeAmount, String date) {
        if (exchangeAmount <= 0) {
            System.out.println("You have entered an incorrect amount. The amount cannot be negative or zero.");
            return 0;
        } else {
            double result = exchangeAmount * getExchangeRateToBeConverted(date); //exchangeAmount
            return roundTo2DecimalPlace(result);
        }
    }

    private double roundTo2DecimalPlace(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
