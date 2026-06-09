package Demo1;

import java.util.*;

public class MyCollections {
        public static void main(String[] args){
            List<String> stringList = new ArrayList<String>();
            stringList.add("vvis");
            stringList.add("balaj");
            stringList.set(0, "vishnu");
            stringList.set(1, "nbalji");
            stringList.add("Rajenderna");
            System.out.println(stringList);
            stringList.remove(2);
            Collections.sort(stringList);
            System.out.println(stringList);

            ArrayList<Byte> bytes = new ArrayList<>();
            bytes.add((byte)11);

            List<Double> doublelist = new ArrayList<>();
            doublelist.add(45.433);
            doublelist.add(56.454);
            System.out.println(doublelist);

//            LinkedList<Integer> linkedList = new LinkedList<>();
//            linkedList.add(4);
//            linkedList.add(10);
//            System.out.println(linkedList.);

            List<Product> products = new ArrayList<>();
            products.add(new Product(12,"r15","vehicle","yamaha",150000,10,3.5));
            products.add(new Product(13,"ns200","vehicle","bajaj",250000,12,4.5));
            products.add(new Product(11,"duke","vehicle","ktm",250000,7,4.2));
            products.add(new Product(15,"bullet","vehicle","royal enfield",350000,10,4));

            Collections.sort(products, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Double.compare(o1.getRating() , o2.getRating());
                }});

            System.out.println(products);
        }
}
