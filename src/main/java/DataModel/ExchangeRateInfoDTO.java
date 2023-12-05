package DataModel;

import services.FetchToTheForexAPI;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateInfoDTO {
    FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    private final List<String> listDataFromForexApi = new ArrayList<>();
    private String date;

    public List<String> getListDataFromForexApi() {
        return listDataFromForexApi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void writeValueCurrencyExchangeToList() {
        listDataFromForexApi.add(fetch.getRespondsWithLatestDate());
    }

    public void writeValueCurrencyExchangeToList(String date) {
        listDataFromForexApi.add(fetch.getRespondsWithHistoricalDate(date));
    }

    @Override
    public String toString() {
        return "ExchangeRateInfoDTO{" +
                "listDataFromForexApi=" + listDataFromForexApi +
                ", date='" + date + '\'' +
                '}';
    }
}

