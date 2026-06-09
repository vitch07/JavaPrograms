package Encapsulation;

public class Employee extends Person {
    protected int empid;
    protected String department;

    Employee(){};
    Employee(String fname,String lname,int age,int empid, String department ){
        super(fname,lname,age);
        this.empid = empid;
        this.department = department;
    }

    public void setDetails(){
        System.out.println(this.empid + "is belonging to this " + this.department);
    }
}
