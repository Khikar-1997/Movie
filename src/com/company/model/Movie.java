package com.company.model;

import java.rmi.server.UID;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Movie {
    private String name;
    private String uId;
    private List<MovieGenre> genres;

    public Movie(String name, List<MovieGenre> genres) {
        this.name = name;
        this.uId = UUID.randomUUID().toString();
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public List<MovieGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (uId != null ? !uId.equals(movie.uId) : movie.uId != null) return false;
        return genres != null ? genres.equals(movie.genres) : movie.genres == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", uId=" + uId +
                ", genres=" + genres +
                '}';
    }
}
