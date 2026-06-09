package interfaceDemo;

public class MainShape {
    public static void main(String[] args){
    Shape s = new Triangle(12,12);
        System.out.println(s.toString());
    Shape r = new Rectangle(10,10);
        System.out.println(r.toString());
}
}
