package com.company;

import com.company.model.MovieGenre;
import com.company.model.Movie;

import java.rmi.server.UID;
import java.util.*;
import java.util.stream.Collectors;

public class Initializer {

    public static Movie initializeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Name of the Movie");
        String name = scanner.nextLine();
        System.out.println("Please Enter the Genres(DRAMA,FANTASY,HORROR,COMEDY,THRILLER,ANIMATION)");
        String genres = scanner.nextLine();
        String[] genresOfMyMovie = genres.split(",");
        List<MovieGenre> collectionOfGenres = Arrays.stream(genresOfMyMovie)
                .map((each) -> MovieGenre.valueOf(each))
                .collect(Collectors.toList());
        Movie movie = new Movie(name,collectionOfGenres);
        return movie;
    }


}
