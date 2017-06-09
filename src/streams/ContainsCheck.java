package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ContainsCheck {

	public static void main(String[] args) {
		
		if (Stream.of("Hello World", "Hello World Buddy", "Hello World Cool Buddy").filter(str -> str.contains("Cool1")).count() > 0){
			System.out.println("Has");
		}
		String str[] = {"Hello World", "Hello World Buddy", "Hello World Cool Buddy"};
		if (Arrays.stream(str).filter(string -> string.contains("Cool")).count() > 0)
			System.out.println("Got it");
			

	}

}
