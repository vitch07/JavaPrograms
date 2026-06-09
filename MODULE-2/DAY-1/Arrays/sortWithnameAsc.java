package Demo1;

import java.util.Comparator;

public class sortWithnameAsc implements Comparator<Product> {
        public int compare(Product a, Product b){
            return a.getName().compareTo(b.getName());
        }
}
