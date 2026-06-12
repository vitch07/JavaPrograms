package DaoPattern;

import entity.ProductDao.Product;

public interface ProductDao {
    public void save(Product product);
    public Iterable<Product> findByName(String name);
    public Iterable<Product> findByBrand(String brand);
    public Iterable<Product> findByCategory(String category);
}
