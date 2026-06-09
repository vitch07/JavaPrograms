package interfaceDemo;

public class Tiger implements Animal{
    private String type;
    private String shelter;

    public void setType(String type){
        this.type = type;
    }
    public void setShelter(String shelter){
        this.shelter = shelter;
    }
    public void sounds(){
        System.out.println("Tiger roars");
    }
    public String getType(){
        return this.type;
    }
    public String getShelter(){
        return this.shelter;
    }

}
