package Demo1;

import java.util.Comparator;

public class withRating implements Comparator<Product> {
    public int compare(Product a, Product b){
        return Double.compare(a.getRating() , b.getRating());
    }
}
