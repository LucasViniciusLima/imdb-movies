package com.apishowmovies.utils;

import com.apishowmovies.utils.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarvelAPIClient implements APIClient {
    private String key;

    public MarvelAPIClient(String key) {
        this.key = key;
    }

    public String getBody() throws IOException, InterruptedException {
        String urlMarvelAPI = "https://gateway.marvel.com:443/v1/public/series?apikey=";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlMarvelAPI + this.key))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
