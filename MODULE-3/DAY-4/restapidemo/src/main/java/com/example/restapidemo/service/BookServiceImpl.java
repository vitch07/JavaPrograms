package com.example.restapidemo.service;

import com.example.restapidemo.dao.BookDao;
import com.example.restapidemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book addsave(Book book) {
            return bookDao.save(book);
    }

    @Override
    public void updateBook(int id, Book book) {
            bookDao.update(id,book);
    }

    @Override
    public void deleteByIdBook(int id) {
            bookDao.deleteById(id);
    }

    @Override
    public List<Book> get() {
        return bookDao.findAll();
    }

    @Override
    public Book findByIdBook(int id) {
        return bookDao.findById(id);
    }
}
