package BasicAggregatrion;

public class EmployeeAggregation {
    private String fname;
    private String lname;
    private String empid;

    EmployeeAggregation(String fname,String lname, String empid){
        this.fname = fname;
        this.lname = lname;
        this.empid = empid;
    }

    public void setFname(String name){this.fname = name;}
    public void setLname(String name) {this.lname = name;}
    public void setEmpid(String id) {this.empid = id;}

    public String getFname(){return this.fname;}
    public String getLname(){return this.lname;}


    public String toString(){
        return "Employee details are: "+ fname + " "+ " "+ lname + " " + empid + " ";
    }
}
