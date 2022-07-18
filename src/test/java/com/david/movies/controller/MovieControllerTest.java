package com.david.movies.controller;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.david.movies.model.Movie;
import com.david.movies.service.MovieService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class MovieControllerTest {
    
    @Autowired
    private MovieController movieController;

    @MockBean
    private MovieService movieService;

    @BeforeEach
    public void setup() {

        standaloneSetup(this.movieController);
    }

    @Test
    public void shouldReturnSuccess_WhenGetMovie() {

        when(this.movieService.getMovie(1L)).thenReturn(new Movie(1L, "Matrix", "No review"));

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/movies/{cod}", 1L)
            .then()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldReturnNotFound_WhenGetMovie() {

        when(this.movieService.getMovie(5L)).thenReturn(null);

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/movies/{cod}", 5L)
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void shouldReturnBadRequest_WhenGetMovie() {

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/movies/{cod}", -1L)
            .then()
            .statusCode(HttpStatus.BAD_REQUEST.value());

        verify(this.movieService, never()).getMovie(-1L);
    }
}