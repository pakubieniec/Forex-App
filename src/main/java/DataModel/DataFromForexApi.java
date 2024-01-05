package DataModel;
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

    public boolean isSuccess() {
        return success;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public boolean isHistorical() {
        return historical;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
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
