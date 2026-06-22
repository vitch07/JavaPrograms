package com.example.springboodemo.controller;


import com.example.springboodemo.dao.MovieDao;
import com.example.springboodemo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    MovieDao movieDao;

    @RequestMapping("/i")
        public ResponseEntity<Movie> movieById(@RequestParam int id){
        return ResponseEntity.status(201).body(movieDao.findById(id));
    }

    @RequestMapping("")
    public List<Movie> getAllMovies()
    {
        return movieDao.findAll();
    }
}
