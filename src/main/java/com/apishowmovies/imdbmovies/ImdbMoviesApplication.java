package com.apishowmovies.imdbmovies;

import com.apishowmovies.utils.HTMLGenerator;
import com.apishowmovies.utils.ImdbApiClient;
import com.apishowmovies.utils.ImdbJsonParseUtil;
import com.apishowmovies.utils.JsonConverterUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.apishowmovies.domain.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@SpringBootApplication
public class ImdbMoviesApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        String imdbKey = "k_4w2dm5vq";

        String json = new ImdbApiClient(imdbKey).getBody();

        List<Content> contentList = new ImdbJsonParseUtil(json).parse();
        contentList.sort(null);

        PrintWriter printWriter = new PrintWriter("index.html");
        new HTMLGenerator(printWriter).generate(contentList);

        printWriter.close();
    }

}

//String marvelKey = "9ff9c1eae697404d478e589c8cd2a09b";
//String json = new MarvelAPIClient(marvelKey).getBody();
//List<Content> contentList = new MarvelSeriesJsonParser(json).parse();
