package org.example.ordermanagementjpa.repository;

import org.example.ordermanagementjpa.dto.ProductResponseDto;
import org.example.ordermanagementjpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
