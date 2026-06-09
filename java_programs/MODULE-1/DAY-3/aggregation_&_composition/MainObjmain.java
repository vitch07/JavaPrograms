package demo;

public class MainObjmain {
    public static void main(String[] args){
        Object o1 = new Object();
        Object o2 = new Object();

        Object o3 = o1;
        System.out.println(o1 == o2);
        System.out.println(o1 == o3);
        System.out.println(o1.equals(o3));
        System.out.println();
    }

}
