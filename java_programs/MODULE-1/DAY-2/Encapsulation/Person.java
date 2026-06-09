package Encapsulation;

public class Person {
    protected String fname;
    protected String lname;
    protected int age;

    Person(){
    }
    Person(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public void setFname(String n){
        this.fname = n;
    }
    public String getFname(){
        return fname;
    }
    public void setLname(String l){
        this.lname = l;
    }
    public String getLname(){
        return lname;
    }
    public void setAge(int x){
        this.age = x;
    }
    public int getAge(){
        return this.age;
    }

    public void eat(){
        System.out.println(this.fname + this.lname + " can eat now");
    }

    public void walk(){
        System.out.println(this.fname + this.lname + " is walking");
    }

    public void talk(){
        System.out.println(this.fname + this.lname + " is talking");
    }
}
