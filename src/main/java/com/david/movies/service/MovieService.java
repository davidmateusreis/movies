package com.david.movies.service;

import org.springframework.stereotype.Service;

import com.david.movies.model.Movie;

@Service
public class MovieService {

    public Movie getMovie(Long cod) {

        if (cod > 100) {
            return null;
        }

        return new Movie(
                cod,
                "Matrix",
                "Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix? Neo is contacted by Trinity (Carrie-Anne Moss), a beautiful stranger who leads him into an underworld where he meets Morpheus. They fight a brutal battle for their lives against a cadre of viciously intelligent secret agents. It is a truth that could cost Neo something more precious than his life.");
    }

}
