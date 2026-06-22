package com.example.restapidemo.service;

import com.example.restapidemo.model.Book;

import java.util.List;

public interface BookService {
    public Book addsave(Book book);
    public void updateBook(int id,Book book);
    public void deleteByIdBook(int id);
    List<Book> get();
    Book findByIdBook(int id);
}
