package demo;

public class Person {
    protected String name;
    protected String fname;
    protected String lname;

    protected int age;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public boolean equals(Object o){
        Person p1 = (Person) o;
        return this.fname.equalsIgnoreCase(p1.fname) && this.lname.equalsIgnoreCase(p1.lname);
    }

    @Override
    public int hashCode() {
        return fname.hashCode() + lname.hashCode();
    }

    public String toString(){
        return "fname "+ fname + "lname " +  lname;
    }
}
