package com.example.restapidemo.dao;

import com.example.restapidemo.model.Book;

import java.util.List;

public interface BookDao {
    Book save(Book book);
    void update(int id,Book book);
    void deleteById(int id);
    List<Book> findAll();
    Book findById(int id);
}
