package Encapsulation;

public class Doctor extends Person{
    private String Specialization;
    public void setSpecialization(String domain){
        this.Specialization = domain;
    }
    public String getSpecialization() {
        return Specialization;
    }

}

