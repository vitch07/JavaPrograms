package logics;

import java.util.Scanner;
import java.math.*;
public class PrimeOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to find Prime or Not");
		int a = sc.nextInt();
		boolean prime = true;
		if (a <= 0 ) System.out.println("Invalid number less than or equals to Zero");
		else {
			int limit = (int)Math.sqrt(a);
			for(int i = 2; i <= limit; i++) {
				if (a % i == 0) {
					prime = false;
					System.out.println("The number is not prime");
					break;
				}
				
			}
			
			if (prime)  System.out.println("The Number is Prime ");
		}
		sc.close();
	}
	
}
