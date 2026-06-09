package logics;

import java.util.Scanner;
public class StudentGradesBasedOnMarks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the marks to show the grade:  ");
		int mark = sc.nextInt();
		if (mark > 101) System.out.println("Invalid mark");
		if (mark <= 100 && mark > 90) System.out.println("Your grade is O");
		else if (mark <= 90 && mark > 80) System.out.println("Your grade is A+");
		else if (mark <= 80 && mark > 70) System.out.println("Your grade is A");
		else if (mark <= 70 && mark > 60) System.out.println("Your grade is B+");
		else if (mark <= 60 && mark >= 50) System.out.println("Your grade is B");
		else System.out.println("Sry you re fail");
		sc.close();
		
	}
}
