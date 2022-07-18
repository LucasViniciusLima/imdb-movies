package com.apishowmovies.utils;

import com.apishowmovies.domain.Content;
import com.apishowmovies.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class ImdbJsonParseUtil {
    private String json;
    public  ImdbJsonParseUtil(String json){
        this.json = json;
    }

    public List<Content> parse(){
        int initIndex = this.json.indexOf("[")+1;
        int endIndex = this.json.indexOf("]");

        String geralArray = this.json.substring(initIndex,endIndex);

        String[] strObjects = geralArray.split("},");

        List<Content> movies = new ArrayList<>();

        for(String item:strObjects){
            String localJson = item + "}";
            Movie movie = JsonConverterUtil.jsonToObject(localJson, Movie.class);
            movies.add(movie);
        }

        return movies;
    }
}
