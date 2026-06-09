package logics;

public class StarPatterns {
	static void star1(int x){
		
		for (int i=0; i < x; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
		}
			System.out.println();
			}
	
	}
	
	static void star2(int x) {
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k =0 ; k < x-i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void star3(int x) {
		for(int i = x; i >= 0; i--) {
			for(int j = i; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = x-i+1 ; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void star4(int x) {
		for(int i = x; i >= 0; i--) {
			for(int j = i; j > 0; j--) {
				System.out.print("*");
			}
			for(int k = x-i+1 ; k > 0; k--) {
				System.out.print(" ");
			}
			System.out.println();
			
		}
	}
	static void star5(int x) {
		for(int i = 0; i < x; i++) {
			for(int j = i; j <= x-1; j++) {
				System.out.print(" ");
			}
			for(int k = 0 ; k < 2*i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
	
	static void star6(int x) {
		for(int i = 0; i < x; i++) {
			for(int j = i; j <= x-1; j++) {
				System.out.print(" ");
			}
			for(int k = 0 ; k < 2*i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = x-1; i > 0; i--) {
			for(int j = x-i+1; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = 0 ; k < 2 * i - 1 ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
//		star1(5);
//		System.out.println();
//		star2(5);
//		System.out.println();
//		star3(5);
//		System.out.println();
//		star4(5);
//		System.out.println();
//		star5(5);
//		System.out.println();
		star6(5);
		System.out.println();
	}
}
