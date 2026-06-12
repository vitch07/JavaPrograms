package entity.ProductDao;

public class Product {
    private String name;
    private String category;
    private String brand;

    public Product(String name, String category, String brand){
        this.name = name;
        this.category = category;
        this.brand = brand;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getName(){return this.name;}
    public String getCategory(){return this.category;}

    public String getBrand() {
        return brand;
    }
    public String toString(){
        return "The products are " + name + " " + category + " " + brand;
    }

}
