package DataModel;

import services.FetchToTheForexAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExchangeRateInfo {
    private String date;

    public ExchangeRateInfo() {
    }

    public ExchangeRateInfo(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "ExchangeRateInfo{" +
                "date='" + date + '\'' +
                '}';
    }
}