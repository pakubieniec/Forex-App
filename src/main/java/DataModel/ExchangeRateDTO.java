package DataModel;

import Mappers.JSONMapper;
import services.FetchToTheForexAPI;

import java.util.HashMap;
import java.util.Objects;

public class ExchangeRateDTO {
    private String ticker;
    private String date;
    private double exchangeAmount;
    private FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    private DataFromForexApi dataFrom = new DataFromForexApi();
    private JSONMapper mapper = new JSONMapper();
    private double rate;

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

    public void setFetchToTheForexApi(String date) {
        if (Objects.equals(date, null)) {
            String fetchInfo = fetch.getRespondsWithLatestDate();
            dataFrom = mapper.mapJsonToJava(fetchInfo);
        } else {
            String fetchInfo = fetch.getRespondsWithHistoricalDate(date);
            dataFrom = mapper.mapJsonToJava(fetchInfo);
        }
    }

    public ExchangeRateDTO() {
    }

    public ExchangeRateDTO(String ticker, double exchangeAmount, double rate) {
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
        ExchangeRateDTO that = (ExchangeRateDTO) o;
        return Double.compare(exchangeAmount, that.exchangeAmount) == 0 && Double.compare(rate, that.rate) == 0 && Objects.equals(ticker, that.ticker) && Objects.equals(date, that.date) && Objects.equals(fetch, that.fetch) && Objects.equals(dataFrom, that.dataFrom) && Objects.equals(mapper, that.mapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, date, exchangeAmount, rate);
    }
}
