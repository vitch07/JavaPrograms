package logics;

import java.util.Scanner;
public class LargestOfThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number a, b , c: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if (a > b) {
			if (a > c) {
				System.out.println("A is the greatest");
			}
			else {
				System.out.println("C is the Greatest");
			}
		}
		else {
			if (b > c) System.out.println("B is the greatest");
			else System.out.println("C is the Greatest");
		}
		sc.close();
	}
}
