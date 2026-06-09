package wrapper;

public class mainByte {
    public static void main(String[] args){
        byte a = 11;
        Byte i = Byte.valueOf(a);
        System.out.println(i);

        Byte j = a;
        System.out.println(j);

        byte unbox = Byte.valueOf(j);
        System.out.println(unbox);
    }
}
