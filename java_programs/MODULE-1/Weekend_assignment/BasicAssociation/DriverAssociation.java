package BasicAssociation;

public class DriverAssociation {
    private String name;


    DriverAssociation(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void drive(CarAssociated c){
        System.out.println(name + "  driver drives the car " + c.getName());
    }

}
