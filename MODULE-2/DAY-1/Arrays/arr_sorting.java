package Demo1;

import java.util.Arrays;

public class arr_sorting {
    public static void main(String[] args){
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 2;
        arr[2] = 30;
        arr[3] = 49;
        arr[4] = 5;
        System.out.println("array before sorting");
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("arrays after sorting");
        System.out.println(Arrays.toString(arr));




        char[] newchar = new char[3];
        newchar[0] = 'c';
        newchar[1] = 'a';
        newchar[2] = 'b';
        System.out.println("array before sorting");
        System.out.println(Arrays.toString(newchar));
        Arrays.sort(newchar);
        System.out.println("arrays after sorting");
        System.out.println(Arrays.toString(newchar));
//        for(char c: newchar) System.out.println(c);


//        byte by[] = new byte[3];
//        by[0] = 1;
//        by[2] = 3;
//        for(byte b:by) System.out.println(b);
//
//        String[] s = new String[4];
//        s[0] = "Vishnu";
//        s[1] = "balaji";
//        s[2] = "r";

    }
}
