package Ui;

import DaoPattern.ProductDao;
import DaoPattern.ProductDaoImp;
import entity.ProductDao.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainProduct {
    public static void main(String[] args){
        Product p1 = new Product("Airconditioner","appliances","voltas");
        Product p2 = new Product("Fridge","appliances","samsung");
        Product p3 = new Product("washMachine","appliances","IBM");
        Product p4 = new Product("cooker","vessels","ikea");
        Product p5 = new Product("motorbike","vehicles","bajaj");
        ProductDao product_list = new ProductDaoImp();
        product_list.save(p1);
        product_list.save(p2);
        product_list.save(p3);
        product_list.save(p4);
        product_list.save(p5);


//        Predicate<Product> categoryPredicate = new Predicate<>()
//            {
//            public boolean test(Product product){
//                return product.getCategory().equalsIgnoreCase("appliances");
//                }
//            };
//        List<Product> categoryTypes = product_list.stream()
//                .filter(categoryPredicate).toList();


        Iterable<Product> categoryTypes = new ArrayList<>();
            categoryTypes = product_list.findByCategory("appliances");
        System.out.println((List<Product>)categoryTypes);
        }
    }


