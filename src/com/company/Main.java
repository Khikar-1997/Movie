package com.company;


import com.company.detabase.Source;
import com.company.model.Movie;
import com.company.service.MovieService;

public class Main {

    public static void main(String[] args) {
        MovieService.create();
        MovieService.create();
        System.out.println(MovieService.findAll());

    }
}


