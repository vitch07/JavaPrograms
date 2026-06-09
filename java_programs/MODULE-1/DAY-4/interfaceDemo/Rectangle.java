package interfaceDemo;

public class Rectangle implements Shape {
    private double length;
    private double breadth;

    Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public double calculateArea(){
        return this.length * this.breadth;
    }

    public void setLength(double length){
        this.length = length;
    }
    public void setBreadth(double breadth){
        this.breadth = breadth;
    }
    public double getLength(){
        return this.length;
    }
    public double getBreadth(){
        return this.breadth;
    }

    public String toString(){
        return "the area of the measured Rectangle is " + calculateArea();
    }


}
