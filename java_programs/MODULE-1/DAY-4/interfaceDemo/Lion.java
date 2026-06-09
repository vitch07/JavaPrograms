package interfaceDemo;

public class Lion implements Animal{
    private String type;
    private String shelter;

    public void setType(String type){
        this.type = type;
    }
    public void setShelter(String shelter){
        this.shelter = shelter;
    }
    public void sounds(){
        System.out.println("Lion roars");
    }
    public String getType(){
        return this.type;
    }
    public String getShelter(){
        return this.shelter;
    }

}

