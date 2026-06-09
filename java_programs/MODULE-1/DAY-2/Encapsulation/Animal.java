package Encapsulation;

public class Animal {
    protected String name;
    protected String type;

    Animal(){}
    Animal(String name, String type){
        this.name = name;
        this.type = type;
    }
    void setName(String name){
        this.name = name;
    }
    void setType(String type){
        this.type = type;
    }
    void sound(){
        System.out.println("ANimal makes sound");
    }
    void sound1(){
        System.out.println(name + " ANimal makes sound");
    }

}
