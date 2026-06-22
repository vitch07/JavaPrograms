package org.example.jpademo.controller;


import org.example.jpademo.model.Product;
import org.example.jpademo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<Product> getProducts(){
        return new ResponseEntity(productService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateTheProductById(@PathVariable int id,@RequestBody Product product){
        productService.update(id,product);
        return ResponseEntity.ok(product);
    }


    @DeleteMapping("{/id}")
    public ResponseEntity<Product> deleteTheProductById(@PathVariable int id){

    }

}

