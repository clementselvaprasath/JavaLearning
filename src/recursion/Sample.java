package recursion;

public class Sample {

	public static void main(String[] args) {
		System.out.println("Factorial of 3 - "+factorial(3));
	}

	private static int factorial(int n){
		if(n<1){
			System.out.print("0  ");
			return 0;
		}
		System.out.print(" "+n +" ");
		return n + factorial(n-1);
	}
	
	private static int fabinaci(int n){
		if (n ==0)
			return 0;

		if(n < 3)
			return 1;
		
		return 1;
	}
}
