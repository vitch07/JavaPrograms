package logics;

import java.util.Scanner;
public class LeapYearOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int year = sc.nextInt();
		
		if (year % 400 == 0) System.out.println("This is a leap year");
		else {
			if (year % 100 == 0) System.out.println("This is not a leap year");
			else {
				if (year % 4 == 0) System.out.println("This is a leap year");
				else System.out.println("This is not a leap year");
			}
		}
		sc.close();
	}
	
}
