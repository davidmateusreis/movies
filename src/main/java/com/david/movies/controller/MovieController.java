package com.david.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.movies.model.Movie;
import com.david.movies.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    
    @Autowired
	private MovieService movieService;
	
	@GetMapping("/{cod}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long cod) {
		
		if (cod < 0) {
			return ResponseEntity.badRequest().build();
		}
		
		Movie movie = this.movieService.getMovie(cod);
		
		if (movie == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(movie);
	}
}
