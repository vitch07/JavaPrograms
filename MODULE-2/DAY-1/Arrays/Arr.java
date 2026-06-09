package Demo1;
import javax.naming.NameNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Arr {
    public static void main(String[] args){
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
//        arr[4] = 5;
        for(int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }
        int[] arr1 = new int[3];
        Arrays.fill(arr,10);

        char[] newchar = new char[3];
        newchar[0] = '1';
        newchar[1] = 'a';
//        newchar[2] = 'b';
        for(char c: newchar) System.out.println(c);

        byte by[] = new byte[3];
        by[0] = 1;
        by[2] = 3;
        for(byte b:by) System.out.println(b);
    
        String[] s = new String[4];
        s[0] = "Vishnu";
        s[1] = "balaji";
        s[2] = "r";

        Scanner sc = new Scanner(System.in);
        try{
            boolean found = false;
        System.out.println("Enter the name: ");
        String name = sc.next();
        for(String n : s) {
            if (n != null && name.equalsIgnoreCase(n)) {
                found = true;
                System.out.println("Welcome " + name);
                break;
            }
        }
        if (!found) throw new NameNotFoundException("Invalid name");
        }catch (NameNotFoundException e){
            System.out.println("You are not allowed " + e.getMessage());
        }
//        for(String values: s) System.out.println(values);





    }
}
