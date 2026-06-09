package logics;

public class fibonnaci {
	static int fib(int x) {
		if (x < 0) return 0;
		if (x == 0 || x == 1)
		{ return 1;}
		return fib(x-1) + fib(x-2);
	}

	public static void main(String[] args) {
		fib(5);
		for(int i=0; i < 5; i++) {
			System.out.println(fib(i) + " ");
		}
	}
}
