package org.sapient.facades;

import org.sapient.models.Movie;

import java.util.List;

public interface MovieFacade {
    default boolean addMovie(Movie movie){
        return false;
    }
    default boolean updateMovie(String movieCode,String movieName){
        return false;
    }
    default List<Object> getAllMovies(){
        return null;
    }
    default boolean deleteMovieByCode(String movieCode){
        return false;
    }
}
