
public class RegularExpVowels {

	  public static void main( String args[] ) {
	      String regex = "[aeiouAEIOU]";
	    
	     
	      String input="welcome";
	      
	      boolean result = input.matches(regex);
	      if(result) {
	         System.out.println("The input string contains vowels");
	      } else {
	         System.out.println("The input string does not contain vowels");
	      }
	   }
}
