package algo;

public class AnagramSubstring {

	public static void main(String[] args) {
		System.out.println("  ----   "+hasAnagramSubstring("wergdhfjabcgjgh", "abc"));

	}

	public static boolean hasAnagramSubstring(String src1, String target1)
	{
		char target[] = target1.toCharArray();
		char src[] = src1.toCharArray();
		
	    if(target.length > src.length) return false;
	    
	    int srcLen = src.length, targetLen = target.length;
	    int[] targetCount = new int [128];
	    int [] count= new int[128] ;
	    int i, j; 
	    //initialize
	    for(i = 0; i < target.length; ++i){
	        ++targetCount[target[i]];
	        ++count[src[i]];
	    }
	    //loop
	    i = 0;
	    while(true){
	        //check if substring is an anagram
	        for(j = 0; j < targetLen; ++j){
	            if(count[target[j]] != targetCount[target[j]]) break;
	        }
	        if(j == targetLen) return true;
	        //slide window
	        if(i + 1 + targetLen > srcLen) break;
	        --count[src[i]];
	        ++count[src[i + targetLen]];
	        ++i;
	    }
	    
	    return false;
	}
}
