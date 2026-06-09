package Demo1;

import java.util.Comparator;

public class withBrand implements Comparator<Product> {
    public int compare(Product a, Product b){
        if (a.getBrand().compareToIgnoreCase(b.getBrand()) == 0)
        {
         return a.getName().compareToIgnoreCase(b.getName());
        }
        else{
            return a.getBrand().compareToIgnoreCase(b.getBrand());
        }
    }
}