package com.apishowmovies.utils;

import com.apishowmovies.utils.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient implements APIClient {
    private String key;

    public ImdbApiClient(String key) {
        this.key = key;
    }

    public String getBody() throws IOException, InterruptedException {

        String urlImdb = "https://imdb-api.com/en/API/Top250Movies/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlImdb + this.key))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
