package exception;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double result = n / m;
            System.out.println("Result is " + result);
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero is not handled");
        }
        catch(Exception e){
            System.out.println("There is an other exception ");
        }
        finally{
            sc.close();
            System.out.println("FInally block handled");
        }
        System.out.println("hi program ends");
    }
}
