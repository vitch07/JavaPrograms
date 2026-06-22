package org.example.jpademo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "jpaProduct")
public class Product {
    @Id
    @GeneratedValue()
    private int id;
    @Column(name = "product_name",nullable = false)
    private String product_name;
    private String product_description;
    private String product_type;


    public Product(){}
    public Product(int id,String product_name,String product_description,String product_type){
        this.id = id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_type = product_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}
