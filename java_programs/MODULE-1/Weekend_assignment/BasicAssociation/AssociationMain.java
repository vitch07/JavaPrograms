package BasicAssociation;

public class AssociationMain {
    public static void main(String[] args){
        CarAssociated audi = new CarAssociated("audi");
        DriverAssociation driver = new DriverAssociation("muthu");
        driver.drive(audi);
    }
}
