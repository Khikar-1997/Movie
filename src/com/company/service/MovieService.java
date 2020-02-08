package com.company.service;

import com.company.Initializer;
import com.company.detabase.Source;
import com.company.model.Movie;

import java.util.LinkedList;

public class MovieService {

    public static boolean create() {
        Movie movie = Initializer.initializeMove();
        boolean bool = false;
        for (int i = 0; i < movie.getGenres().size(); i++) {
            if (Source.movies.containsKey(movie.getGenres().get(i))) {
                Source.movies.get(movie.getGenres().get(i)).add(movie);
                bool = true;
            } else {
                LinkedList<Movie> movies = new LinkedList<>();
                movies.add(movie);
                Source.movies.put(movie.getGenres().get(i), movies);
                bool = true;
            }
        }
        return bool;
    }

}
