package org.example.jpademo.service;

import org.example.jpademo.model.Product;
import org.example.jpademo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;


@Service
public class ProductServiceimp implements ProductService{
    private ProductRepository productRepository;

    ProductServiceimp(ProductRepository productrepo){
        this.productRepository = productrepo;
    }
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(int id,Product product) {
        Product product1 = productRepository.findById(id).get(); //findById gives Optional obj so wej use .get()
        product1.setProduct_name(product.getProduct_name());
        product1.setProduct_description(product.getProduct_description());
        product1.setProduct_type(product.getProduct_type());

        productRepository.save(product1);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
