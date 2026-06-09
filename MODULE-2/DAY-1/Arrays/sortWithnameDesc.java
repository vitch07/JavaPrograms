package Demo1;


import java.util.Comparator;

public class sortWithnameDesc implements Comparator<Product> {
    public int compare(Product a, Product b){
        return b.getName().compareTo(a.getName());
    }
}