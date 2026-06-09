package logics;

import java.util.Scanner;
public class CountTheFactors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to find the factor: ");
		int a = sc.nextInt();
		int cnt =  1;
		for(int i = 1;i <= (int)(a/2)+1; i++) {
			if (a % i == 0) cnt += 1;
		}
		System.out.println(cnt);
		sc.close();
	}
}
