package association;

public class MainPassport {
    public static void main(String[] args){
        Person p = new Person("R","vishnu","balaji",21);
        Passport pass = new Passport("23455","India","29-10-2025","12-12-2050");
        pass.setPerson(p);
        System.out.println(pass);
    }
}
