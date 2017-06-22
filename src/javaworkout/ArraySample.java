package javaworkout;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySample {

	public static void main(String[] args) {
		String [] strArray = {"A","B", "C", "D"};
		
		int [] intArray = {1,7,8,9};
		
/*		for(int i : intArray){
			for(int j=0; j<i; j++)
				System.out.print("*");
			System.out.println("");
		}*/
		
		// NESTED for
		Arrays.stream(intArray)
		.forEach(e -> {
			IntStream.range(0, e)
			.forEach(i -> {System.out.print("*");});
			System.out.println("");
		});
		
		
		
		//===================================================================
/*		String str1 = "abcdeefghhe";
		char[] str1Source = str1.toCharArray();
		char[] str1Array = new char[str1.length()];
		int temp = 1;
		boolean matchFound = false;
		str1Array[0] = str1Source[0];
		for(int i =1; i< str1.length();i++){
			matchFound = false;
			for(int j =i; j>0;j--){
				if(str1Source[i]==str1Source[j-1]){
					System.out.println("Match" + str1Source[i] + "" + str1Source[j]);
					matchFound= true;
					break;
				}
			}
			if(matchFound == false)
				str1Array[temp++]=str1Source[i];
		}
		
		System.out.print(str1Array);*/
		//===================================================================		
	}
}
