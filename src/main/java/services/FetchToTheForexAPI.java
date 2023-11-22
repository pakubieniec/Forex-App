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
//        System.out.println(request);
        return getResponds(request);
    }

    public String getRespondsWithHistoricalDate(String date) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.exchangeratesapi.io/v1/" + date + "?access_key=" + API_KEY + "&symbols=PLN"))
                .GET()
                .build();
//        System.out.println(request);
        return getResponds(request);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FetchToTheForexAPI that)) return false;
        return Objects.equals(API_KEY, that.API_KEY) && Objects.equals(CLIENT, that.CLIENT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(API_KEY, CLIENT);
    }

    private String getResponds(HttpRequest request) {
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

}


