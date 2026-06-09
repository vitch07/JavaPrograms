package Encapsulation;

class Deer extends Animal{
    public void sound(){
        System.out.println(name + " usually dont make sound");
    }
}
public class DeerMain {
    public static void main(String[] args) {
        Animal ani = new Deer();
        ani.setName("Deer");
        ani.sound1();

    }
}