package Mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import DataModel.DataFromForexApi;


public class JSONMapper {
    ObjectMapper objectMapper = new ObjectMapper();

    public DataFromForexApi mapJsonToJava(String json) {
        DataFromForexApi data;
        try {
            data = objectMapper.readValue(json, DataFromForexApi.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public String mapObjectToJson(DataFromForexApi data) {
        String jsonAsString;
        try {
            jsonAsString = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonAsString;
    }
}