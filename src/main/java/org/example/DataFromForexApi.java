package org.example;

import java.util.Objects;

public class DataFromForexApi {
    private boolean success;
    private int timestamp;
    private boolean historical;
    private String base;
    private String date;
    private Object rates;

    public DataFromForexApi() {
    }

    public DataFromForexApi(boolean success, int timestamp, boolean historical, String base, String date, Object rates) {
        this.success = success;
        this.timestamp = timestamp;
        this.historical = historical;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isHistorical() {
        return historical;
    }

    public void setHistorical(boolean historical) {
        this.historical = historical;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getRates() {
        return rates;
    }

    public void setRates(Object rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "DataFromForexApi{" +
                "success=" + success +
                ", timestamp=" + timestamp +
                ", historical=" + historical +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", rates=" + rates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataFromForexApi that = (DataFromForexApi) o;
        return success == that.success && timestamp == that.timestamp && historical == that.historical && Objects.equals(base, that.base) && Objects.equals(date, that.date) && Objects.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, timestamp, historical, base, date, rates);
    }
}
