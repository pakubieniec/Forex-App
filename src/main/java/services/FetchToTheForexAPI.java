package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class FetchToTheForexAPI {
    final String API_KEY = "eef4870f3bb05e362ad7b62b2f593612";
    final HttpClient CLIENT = HttpClient.newBuilder().build();

    public String getRespondsWithLatestDate() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.exchangeratesapi.io/v1/latest?access_key=" + API_KEY + "&symbols=PLN"))
                .GET()
                .build();
        return getResponds(request);
    }

    public String getRespondsWithHistoricalDate(String date) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.exchangeratesapi.io/v1/" + date + "?access_key=" + API_KEY + "&symbols=PLN"))
                .GET()
                .build();
        return getResponds(request);
    }

    private String getResponds(HttpRequest request) {
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

}


