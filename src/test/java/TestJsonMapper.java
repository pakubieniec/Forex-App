import Mappers.JSONMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.FetchToTheForexAPI;

public class TestJsonMapper {
    JSONMapper jsonMapper = new JSONMapper();
    FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    String json = "{\"success\":true,\"timestamp\":1577923199,\"historical\":true,\"base\":\"EUR\"," +
            "\"date\":\"2020-01-01\",\"rates\":{\"PLN\":4.255381}}";

    @Test
    public void mapJsonToObjectIsEqualsObject() {
        Assertions.assertEquals(jsonMapper.mapJsonToJava(json), fetch.getRespondsWithHistoricalDateObj("2020-01-01"));
    }

    @Test
    public void mapJsonToObjectIsEqualsmapJsonFromFetchApi() {
        Assertions.assertEquals(jsonMapper.mapJsonToJava(json), jsonMapper.mapJsonToJava(fetch.getRespondsWithHistoricalDate("2020-01-01")));
    }

    @Test
    public void jsonIsEqualsmapObjectToJson() {
        Assertions.assertEquals(json, jsonMapper.mapObjectToJson(fetch.getRespondsWithHistoricalDateObj("2020-01-01")));
    }

    @Test
    public void jsonIsEqualsmapObjectToJsonFromFetchApi() {
        Assertions.assertEquals(json, jsonMapper.mapObjectToJson(jsonMapper.mapJsonToJava(fetch.getRespondsWithHistoricalDate("2020-01-01"))));
    }
}

