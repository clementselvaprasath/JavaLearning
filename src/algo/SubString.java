package algo;

public class SubString {

	public static void main(String[] args) {
		String str1 = "Hello Clement how are you...how";
		String str2 = "how";
		
		char [] str1Array = str1.toCharArray();
		char [] str2Array = str2.toCharArray();
/*		int foundLength = 0;
		boolean found = false;
		int indexStr = 0;
		int index = 0;
		while (index <= (str1Array.length - str2Array.length)) { 
			for(int i=index; indexStr < str2Array.length ; i++, indexStr++){
				if(str1Array[i] == str2Array[indexStr] ){
					foundLength++;
					if(foundLength == str2Array.length){
						found = true;
						System.out.println("Found - "+ found);
						break;
					}
				}else {
					foundLength = 0;
				}
			}
			index++;
			System.out.println("index -- "+index);
			indexStr = 0;
		}
*/
		//System.out.println("Found - "+ found);
		
		int subStringCharCount = 0;
		boolean found = false;
		for(int outerIndex=0; outerIndex <= (str1Array.length - str2Array.length); outerIndex++ ){
			for(int innerIndex = outerIndex, subStringIndex =0; subStringIndex < str2Array.length; subStringIndex++, innerIndex++){
				if(str1Array[innerIndex] == str2Array[subStringIndex]){
					subStringCharCount++;
					if(subStringCharCount == str2Array.length){
						System.out.println("Found");
						break;
					}
				}else {
					subStringCharCount = 0;
				}
			}
		}

	}

}
/*
Hello Clement how are you...how
*/