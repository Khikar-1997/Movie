package com.company.service;

import com.company.Initializer;
import com.company.detabase.Source;
import com.company.model.Movie;
import com.company.model.MovieGenre;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Movie> findAll() {
        Collection<LinkedList<Movie>> values = Source.movies.values();
        List<Movie> collect = values.stream()
                .flatMap((each) -> each.stream())
                .collect(Collectors.toList());
        return collect;
    }

    public static List<Movie> findAllByGenre(String genre) {
        MovieGenre movieGenre = MovieGenre.valueOf(genre);
        return Source.movies.get(movieGenre);
    }

    public static Movie findByUID(String uid) {
        List<Movie> collect = Source.movies.values().stream()
                .flatMap((each) -> each.stream())
                .collect(Collectors.toList());
        List<Movie> collect1 = collect.stream()
                .filter((each) -> each.getuId().equals(uid))
                .collect(Collectors.toList());
        return collect1.get(0);
    }

}
