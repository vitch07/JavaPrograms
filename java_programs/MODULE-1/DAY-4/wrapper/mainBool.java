package wrapper;

public class mainBool {
    public static void main (String[] args){
        boolean a = true;
        Boolean i = Boolean.valueOf(a);
        System.out.println(i);

        Boolean j = a;
        System.out.println(j);

        boolean unbox = j.booleanValue();
        System.out.println(unbox);
    }
}
