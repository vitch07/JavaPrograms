package Demo1;
import java.util.*;
public class PersonMain {
    public static void main(String[] args){
        Person[] people = {
                new Person("vishnu","balaji","a",21),
                new Person("Harsh","bharti","r",22),
                new Person("selvaraj","nikassh","b",20),
                new Person("mani","kandan","c",19)
        };
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, new Person()); // if we implement like this we cant able to declare it for lname,fname,etc
        System.out.println(Arrays.toString(people));

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();


    }
}
