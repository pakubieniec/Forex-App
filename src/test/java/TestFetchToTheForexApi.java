import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.FetchToTheForexAPI;

public class TestFetchToTheForexApi {
    FetchToTheForexAPI fetch = new FetchToTheForexAPI();

    String presentDay = fetch.getRespondsWithLatestDate();
    String pastDay = fetch.getRespondsWithHistoricalDate("2022-09-10");

    @Test
    public void checkPresentDay() {
        Assertions.assertEquals(presentDay, fetch.getRespondsWithLatestDate());
    }

    @Test
    public void checkPastDay() {
        Assertions.assertEquals(pastDay, fetch.getRespondsWithHistoricalDate("2022-09-10"));
    }
}
