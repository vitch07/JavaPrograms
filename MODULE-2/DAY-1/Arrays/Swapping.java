package Demo1;

import java.util.Scanner;
public class Swapping {
    public static void main(String[] args){
        int[] x = {1,2,3,4,5};
        Scanner sc = new Scanner(System.in);
        int ind1 = sc.nextInt();
        int ind2 = sc.nextInt();

        int temp;
        temp = x[ind1];
        x[ind1] = x[ind2];
        x[ind2] = temp;

        for(int a:x){
            System.out.println(a);
        }

    }
}
