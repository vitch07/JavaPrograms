package logics;

import java.util.Scanner;
public class Factorial {
	public static void main(String[] args) {
		int ans = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number to know its factorial: ");
		int x = sc.nextInt();
		
		for (int i = 1; i <= x; i++) {
			ans *= i;
		}
		
		System.out.println("The factorial of the number is : "+ ans);
	}
}
