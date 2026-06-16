package dao;

import entity.Book;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public interface BookJdbcDao {
    public int save(Book b);
    public Book findbyId(int id);
    public void deleteById(int id);
    public void update(Book book);
    public void deleteAll();
    public Collection<Book> findAll();
    public Collection<Book> findByAuthor(String author);
    public Collection<Book> findByTitle(String title);
    public Collection<Book> sortByTitleAsc();
    public Collection<Book> sortByTitleDesc();
}

