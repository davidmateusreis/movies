package com.david.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    private Long cod;
	private String title;
	private String review;
    
}