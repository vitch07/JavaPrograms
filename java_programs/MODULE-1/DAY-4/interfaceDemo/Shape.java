package interfaceDemo;

public interface Shape {
    String color = "red";
    double calculateArea();
    public static void showColor(){
        System.out.println("shape color is " + color);
    }

}
