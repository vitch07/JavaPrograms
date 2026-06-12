package Iterator;

import java.util.Iterator;

public class MyRangeMain {
    public static void main(String[] args){
        MyRange myrange = new MyRange(10,20);
        for(Integer m: myrange){
            System.out.println(m);
        }
    }
}
