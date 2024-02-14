package DataModel;

import Mappers.JSONMapper;
import services.FetchToTheForexAPI;

import java.util.HashMap;
import java.util.Objects;

public class ExchangeRate {
    private String ticker;
    private String date;
    private double exchangeAmount;
    private double rate;

    public ExchangeRate() {
    }

    public ExchangeRate(String ticker, double exchangeAmount, double rate) {
        this.ticker = ticker;
        this.exchangeAmount = exchangeAmount;
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "ticker='" + ticker + '\'' +
                ", exchangeAmount=" + exchangeAmount +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Double.compare(exchangeAmount, that.exchangeAmount) == 0 && Double.compare(rate, that.rate) == 0 && Objects.equals(ticker, that.ticker) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, date, exchangeAmount, rate);
    }
}
