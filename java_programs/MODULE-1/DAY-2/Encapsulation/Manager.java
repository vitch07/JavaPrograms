package Encapsulation;

public class Manager extends Employee{
    private String team;

    Manager(){};
    Manager(String fname, String lname, int age, int empid, String department, String team){
        super(fname,lname,age,empid,department);
        this.team = team;
    }
    public void setTeam(String team){
        this.team = team;
    }
    public String getTeam(){
        return team;
    }


}
