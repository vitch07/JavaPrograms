package DOBcomparator;

public class DOBChild {
    private String fname;
    private String lname;
    private String dob;

    DOBChild(String fname, String lname, String dob){
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    String getDob(){
        return this.dob;
    }

    public String toString(){
        return "Child " + this.fname + " " + this.lname + " " + this.dob + " ";
    }

}
