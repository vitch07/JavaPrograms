package Demo1;
 import java.util.*;
public class Product {
    private int id;
    private String name;
    private String category;
    private String brand;
    private int price;
    private int discount;
    private double rating;

    Product(){}

    Product(int id, String name, String category, String brand, int price, int discount, double rating){
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
        this.rating = rating;
    }
    public String getName(){return this.name;}
    public String getCategory(){return this.category;}
    public String getBrand(){return this.brand;}
    public int getId(){ return this.id;}
    public int getPrice(){return this.price;}
    public int getDiscount(){return this.discount;}
    public double getRating(){return this.rating;}

    public String toString(){
        return this.id + " " + this.name + " " + this.category + " " + this.brand + " " + this.price +
                " " + this.discount + " " + this.rating;
    }


}
