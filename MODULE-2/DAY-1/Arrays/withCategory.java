package Demo1;

import java.util.Comparator;

public class withCategory implements Comparator<Product> {
    public int compare(Product a, Product b){
        return b.getCategory().compareToIgnoreCase(a.getCategory());
    }
}
