package Demo1;

import java.util.*;
public class withDiscount implements Comparator<Product>{
    public int compare(Product a, Product b){
        return a.getDiscount() - b.getDiscount();
    }
}
