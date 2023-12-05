package DataModel;

import services.FetchToTheForexAPI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateDTO {
    private String ticker;
    private double exchangeAmount;
    private double rate = 4.2;

    public double getExchangeAmount() {
        return exchangeAmount;
    }

    public void setExchangeAmount(double exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double convertedCurrency(double exchangeAmount) {
        double result = roundTo2DecimalPlace(exchangeAmount * rate); //exchangeAmount
        return result;
    }

    public static double roundTo2DecimalPlace(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "ExchangeRateDTO{" +
                "ticker='" + ticker + '\'' +
                ", exchangeAmount=" + exchangeAmount +
                ", rate=" + rate +
                '}';
    }
}
