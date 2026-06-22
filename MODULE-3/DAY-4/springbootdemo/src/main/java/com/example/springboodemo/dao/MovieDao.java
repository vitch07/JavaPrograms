package com.example.springboodemo.dao;

import com.example.springboodemo.model.Movie;

import java.util.List;

public interface MovieDao {
    void saveMovie(Movie movie);
    Movie findById(int id);
    void deleteBy(int id);
    void update(int id, Movie movie);
    List<Movie> findAll();
}
