package DataModel;

import services.FetchToTheForexAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExchangeRateInfoDTO {
    private FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    private final List<String> listDataFromForexApi = new ArrayList<>();
    private String date;

    public ExchangeRateInfoDTO(){}

    public ExchangeRateInfoDTO(String date) {
        this.date = date;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRateInfoDTO that = (ExchangeRateInfoDTO) o;
        return Objects.equals(listDataFromForexApi, that.listDataFromForexApi) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listDataFromForexApi, date);
    }
}

