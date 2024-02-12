package services;

import services.FetchToTheForexAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SaveDataFromForexApiToList {
    private final FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    private final List<String> listDataFromForexApi = new ArrayList<>();

    public List<String> getListDataFromForexApi() {
        return listDataFromForexApi;
    }

    public void writeValueCurrencyExchangeToList() {
        listDataFromForexApi.add(fetch.getRespondsWithLatestDate());
    }

    public void writeValueCurrencyExchangeToList(String date) {
        listDataFromForexApi.add(fetch.getRespondsWithHistoricalDate(date));
    }

    @Override
    public String toString() {
        return "SaveDataFromForexApiToList{" +
                "listDataFromForexApi=" + listDataFromForexApi +
                '}';
    }
}
