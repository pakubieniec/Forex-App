import DataModel.DataFromForexApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import services.FetchToTheForexAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockitoFetchTest {
    @Mock
    private FetchToTheForexAPI fetch;
    @Test
    public void mockFetchTest() {
        String jsonLatestDate = "{\\\"success\\\":true,\\\"timestamp\\\":1577923199,\\\"historical\\\":true,\\\"base\\\":\\\"EUR\\\",\" +\n" +
                "            \"\\\"date\\\":\\\"2024-02-14\\\",\\\"rates\\\":{\\\"PLN\\\":4.34987}}";
        Mockito.when(fetch.getRespondsWithLatestDate()).thenReturn(jsonLatestDate);
        assertEquals(jsonLatestDate, fetch.getRespondsWithLatestDate());

        String jsonHistoricalDate = "{\\\"success\\\":true,\\\"timestamp\\\":1577923199,\\\"historical\\\":true,\\\"base\\\":\\\"EUR\\\",\" +\n" +
                "            \"\\\"date\\\":\\\"2020-11-02\\\",\\\"rates\\\":{\\\"PLN\\\":4.52906}}";
        Mockito.when(fetch.getRespondsWithHistoricalDate("2020-01-01")).thenReturn(jsonHistoricalDate);
        assertEquals(jsonHistoricalDate, fetch.getRespondsWithHistoricalDate("2020-01-01"));
    }
}