package com.example.springboodemo.dao;

import com.example.springboodemo.model.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieDaoImpl implements MovieDao {

    Map<Integer,Movie> movies;


    @PostConstruct
    public void init(){
        movies = new HashMap<>();
        movies.put(1,new Movie(1,"Shawshank Redemption","Shashank",2012,"Comedy",5.6));
        movies.put(2,new Movie(2,"Arjun reddy","VIshnu",2014,"Love",8.0));
        movies.put(3,new Movie(3,"F1","Shashank",2012,"racing",9.0));

    }
    @Override
    public void saveMovie(Movie movie) {
        movies.put(movie.getId(),movie);
    }

    @Override
    public Movie findById(int id) {
        return movies.get(id);
    }

    @Override
    public void deleteBy(int id) {
        movies.remove(id);
    }

    @Override
    public void update(int id, Movie movie) {
            movies.put(id,movie);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies.values());
    }
}
