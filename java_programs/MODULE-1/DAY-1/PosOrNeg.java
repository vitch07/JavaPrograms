package logics;

import java.util.Scanner;
public class PosOrNeg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int number = sc.nextInt();
		if (number == 0) System.out.println("THe Number is neither Postive nor Negative. ");
		else {
			if (number < 0) System.out.println("The Number is Negative.");
			else System.out.println("The number is Positive");
		}
		sc.close();
	}
}
