package Demo1;
import java.util.Arrays;
public class ProductMain {
    public static void main(String[] args){
        Product[] products = {new Product(1,"AirConditioner","Appliances","Daikin",15000,30,4.5),
                new Product(2,"Fridge","Appliances","samsung",10000,40,4),
                new Product(3,"Kurta Dress","Dressing","Lewis",1500,50,5),
                new Product(4,"Cups and spoons","vessels","ikea",2000,30,4),
                new Product(5,"Cooker","vessels","ikea",4000,30,4),

        };
        System.out.println("Before the discounts: ");
        System.out.println(Arrays.toString(products));
        Arrays.sort(products, new withDiscount());
        System.out.println("After the discounts: ");
        System.out.println(Arrays.toString(products));

        System.out.println("Before the Rating: ");
        System.out.println(Arrays.toString(products));
        Arrays.sort(products, new withRating());
        System.out.println("After the Rating: ");
        System.out.println(Arrays.toString(products));

        System.out.println("Before the Name ascending order: ");
        System.out.println(Arrays.toString(products));
        Arrays.sort(products, new sortWithnameAsc());
        System.out.println("After the Name ascending order: ");
        System.out.println(Arrays.toString(products));

        System.out.println("Before the Brand asc order: ");
        System.out.println(Arrays.toString(products));
        Arrays.sort(products, new withBrand());
        System.out.println("After the Brand ascending order: ");
        System.out.println(Arrays.toString(products));

        System.out.println("Before the Category: ");
        System.out.println(Arrays.toString(products));
        Arrays.sort(products, new withCategory());
        System.out.println("After the Category ascending order: ");
        System.out.println(Arrays.toString(products));


    }
}
