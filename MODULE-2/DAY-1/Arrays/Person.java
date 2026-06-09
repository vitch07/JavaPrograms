package Demo1;

import java.util.Comparator;
public class Person implements Comparable<Person>, Comparator<Person> {
    private String name;
    private String fname;
    private String lname;
    private int age;

    Person(){};
    Person(String name, String fname, String lname, int age){
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

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

    public String getLname(){
        return this.lname;
    }
    public String getFname(){
        return this.fname;
    }

    @Override
    public int hashCode() {
        return fname.hashCode() + lname.hashCode();
    }

    public String toString(){
        return "fname "+ fname + " lname " +  lname + " age" + age;
    }
    public int compareTo(Person p){
        return this.age - p.age;
    }
    public int compare(Person p, Person o){
        return o.getLname().compareTo(p.getLname());
    }

}

