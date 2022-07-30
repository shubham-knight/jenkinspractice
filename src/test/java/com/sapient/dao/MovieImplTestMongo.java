package com.sapient.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.sapient.dao.MovieImpl;
import org.sapient.facades.MovieFacade;
import org.sapient.models.Movie;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieImplTestMongo {
    private MovieFacade movieFacade;
    private Movie movie;


    @BeforeEach
    public void createMovieDaoInstance(){
        movieFacade=new MovieImpl() {
        };

        movie=new Movie("MI7","MissionImpossible7",
                "J watts","tomcruise",
                LocalDate.of(2022,8,12));

    }

    @Test
    @Tag("dev")
    public void addMovieTest(){

assertTrue(movieFacade.addMovie(movie));
    }
    @Test
    @Tag("dev")
    public void updateClaimTest(){
        System.out.println("hello");
        assertTrue(movieFacade.updateMovie( "MI7","Mission Impossible 7"));
    }




    @Test
    @Tag("dev")
    public void deleteMovieByIdTest(){

        assertTrue(movieFacade.deleteMovieByCode("MI7"));
    }
    @Test
    @Tag("dev")
    public void deleteMovieByCodeTest(){

        assertTrue(movieFacade.deleteMovieByCode("MI7"));
    }


    @AfterEach
    public void unLinkMovieInstances(){
        movie=null;
        movieFacade=null;
    }
}
