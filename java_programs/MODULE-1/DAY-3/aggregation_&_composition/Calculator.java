package demo;

public class Calculator {

    public int add(int x, int y){
        return x + y;
    }
    public int add(int x, int y, int z){
        return x + y + z;
    }
    public String add(String x, String y){
        return x + y;
    }
    public float add(float x, float y){
        System.out.println("float addition");
        return (float)(x + y);
    }
    public double add(double x, double y){
        System.out.println("Double addition");
        return (double)(x + y);
    }

}
