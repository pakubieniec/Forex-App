import DataModel.DataFromForexApi;
import DataModel.ExchangeRate;
import Mappers.JSONMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.CurrencyOperations;
import services.FetchToTheForexAPI;

public class TestExchangeRate {
    CurrencyOperations currencyOperations = new CurrencyOperations();
    FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    JSONMapper mapper = new JSONMapper();
    DataFromForexApi dateFrom = mapper.mapJsonToJava(fetch.getRespondsWithHistoricalDate("2022-12-12"));
    String date = dateFrom.getDate();

    @Test
    public void exchange100EURget469ZL18GR() {
        Assertions.assertEquals(469.18, currencyOperations.convertedCurrency(100, date));
    }

    @Test
    public void exchange330EURget1548Z28GR() {
        Assertions.assertEquals(1548.28, currencyOperations.convertedCurrency(330, date));
    }

    @Test
    public void exchange0EURget0ZL() {
        Assertions.assertEquals(0, currencyOperations.convertedCurrency(0, date));
    }

    @Test
    public void exchangeMinus50EURget0ZL() {
        Assertions.assertEquals(0, currencyOperations.convertedCurrency(-50, date));
    }
}
