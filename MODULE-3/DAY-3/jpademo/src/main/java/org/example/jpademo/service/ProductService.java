package org.example.jpademo.service;

import org.example.jpademo.model.Product;

import java.awt.print.Book;
import java.util.List;

public interface ProductService {
    Product save(Product product);
     List<Product> findAll();
     void update(int id,Product product);
     void delete(int id);

}
