package logics;

import java.util.Scanner;
public class PrintSumOfFactors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to find the factor: ");
		int a = sc.nextInt();
		int cnt =  a;
		for(int i = 1;i <= (int)(a/2)+1; i++) {
			if (a % i == 0) cnt += i;
		}
		System.out.println(cnt);
		sc.close();
	}
}
