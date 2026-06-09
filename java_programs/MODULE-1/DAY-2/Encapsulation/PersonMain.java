package Encapsulation;

public class PersonMain {
    public static void main(String[] args) {
        Person member1 = new Person();

        member1.setFname("Vishnu");
        member1.setLname("Balaji");
        member1.setAge(23);

        int age1 =  member1.getAge();
        System.out.println(age1);
        member1.eat();
        member1.walk();


    }
}