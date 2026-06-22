package com.example.restapidemo.controller;

import com.example.restapidemo.model.Book;
import com.example.restapidemo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceimp;

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.ok(bookServiceimp.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id){
        return new ResponseEntity<>(bookServiceimp.findByIdBook(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.status(201).body(bookServiceimp.addsave(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updates(@PathVariable int id, @RequestBody Book book){
        bookServiceimp.updateBook(id,book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletes(@PathVariable int id){
        bookServiceimp.deleteByIdBook(id);
        return ResponseEntity.noContent().build();
    }
}
