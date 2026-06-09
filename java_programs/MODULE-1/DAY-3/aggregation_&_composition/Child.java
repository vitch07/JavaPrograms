package demo;


class ChildMain extends Parent {
     void display() {
        System.out.println("Child");
    }
}

public class Child{
    public static void main(String[] args){
        Parent chi = new ChildMain();
        chi.display();
    }

}
