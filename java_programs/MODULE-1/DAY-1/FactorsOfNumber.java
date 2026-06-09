package logics;

import java.util.Scanner;
public class FactorsOfNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number 1 to find the factor: ");
		int a = sc.nextInt();
		for(int i = 1;i <= (int)(a/2)+1; i++) {
			if (a % i == 0) System.out.println(i);
		}
		System.out.println(a);
		sc.close();
	}
}
