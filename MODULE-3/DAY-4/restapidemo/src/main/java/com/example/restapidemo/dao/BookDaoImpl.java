package com.example.restapidemo.dao;

import com.example.restapidemo.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookDaoImpl implements BookDao{
    Map<Integer,Book> books;

    @PostConstruct
    public void init(){
        books = new LinkedHashMap<>();
        books.put(1,new Book(1,"psychology of money",
                "james clear","Good books"));
        books.put(2,new Book(2,"psychology","billgates","billgatesbooks"));
    }
    @Override
    public Book save(Book book) {
        books.put(book.getId(),book);
        return books.get(book.getId());
    }

    @Override
    public void update(int id,Book book) {
        books.put(id,book);
    }

    @Override
    public void deleteById(int id) {
        books.remove(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById(int id) {
        return books.get(id);
    }
}
