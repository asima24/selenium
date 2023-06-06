import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstString = "Army";
		 String secondString = "mary";
		 
		 System.out.println("Check if the firstString and secondString is anagram of each other: "+ isAnagram(firstString, secondString));
		 }
		 
		    public static boolean isAnagram(String firstString, String secondString)
		    {
		        char[] firstStringCharArray = firstString.toLowerCase().toCharArray();
		        char[] secondStringCharArray = secondString.toLowerCase().toCharArray();       
		        Arrays.sort(firstStringCharArray);
		        Arrays.sort(secondStringCharArray);
		       
		        return Arrays.equals(firstStringCharArray, secondStringCharArray);
		        
		    }
	}


