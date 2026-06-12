package DaoPattern;

import entity.ProductDao.Product;

import java.util.ArrayList;

public class ProductDaoImp implements ProductDao{
    private ArrayList<Product> products;

    public ProductDaoImp(){
        products = new ArrayList<>();
    }
    public void save(Product p){
        products.add(p);
    }

    public Iterable<Product> findByName(String name){
            ArrayList<Product> result = new ArrayList<>();
                for (Product p: products) {
                    if (p.getName().equalsIgnoreCase(name)) {
                        result.add(p);
                    }
                };
            return result;
    }

    public Iterable<Product> findByBrand(String name){
        ArrayList<Product> result1 = new ArrayList<>();
        for(Product p: products){
            if(p.getBrand().equalsIgnoreCase(name)){
                result1.add(p);
            }
        }
        return result1;
    }

    public Iterable<Product> findByCategory(String name){
//        ArrayList<Product> res = new ArrayList<>();
//        for(Product p: products){
//            if(p.getCategory().equalsIgnoreCase(name)){
//                res.add(p);
//            }
//        }
//        return res;

        return products.stream()
                .filter((Product product) -> product.getCategory().equalsIgnoreCase(name)).toList();
    }



}

