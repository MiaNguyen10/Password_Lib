import java.util.*;

public class PasswordValidator {

    // A utility function to check whether a password is valid or not
	/*Password should not contain any space.
	Password should contain at least one digit(0-9).
	Password length should be between 4 to 15 characters.
	Password should contain at least one lowercase letter(a-z).
	Password should contain at least one uppercase letter(A-Z).
	Password should contain at least one special character ( @, #, %, &, !, $, etc….). */
    public static boolean isValid(String password)
    {
    	/*=====================check the validity of a Password===================*/
        // for checking if password length
        // is between 8 and 15
        if (!((password.length() >= 4)
              && (password.length() <= 15))) {
            return false;
        }
  
        // to check space
        if (password.contains(" ")) {
            return false;
        }
        if (true) {
            int count = 0;
  
            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {
  
                // to convert integer to string
                String str1 = Integer.toString(i);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
  
        // for special characters
        if (!(password.contains("@") || password.contains("#")
              || password.contains("!") || password.contains("~")
              || password.contains("$") || password.contains("%")
              || password.contains("^") || password.contains("&")
              || password.contains("*") || password.contains("(")
              || password.contains(")") || password.contains("-")
              || password.contains("+") || password.contains("/")
              || password.contains(":") || password.contains(".")
              || password.contains(", ") || password.contains("<")
              || password.contains(">") || password.contains("?")
              || password.contains("|"))) {
            return false;
        }
  
        if (true) {
            int count = 0;
  
            // checking capital letters
            for (int i = 65; i <= 90; i++) {
  
                // type casting
                char c = (char)i;
  
                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
  
        if (true) {
            int count = 0;
  
            // checking small letters
            for (int i = 90; i <= 122; i++) {
  
                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
  
        // if all conditions fails
        return true;
    }
                              /*=================Check Strength of Password===================*/
    public static boolean checkStrengthOfPassword(String password)
    {
        // Checking lower alphabet in string
        int n = password.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                          '*', '(', ')', '-', '+'));
        for (char i : password.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }
       
        // Strength of password
        if (hasDigit && hasLower && hasUpper && specialChar
            && (n >= 8)) 
        	return true; //Strong pass
        else
            //System.out.print("Your password is Weak");
        	return false; 
    }
    
     
    				/*=================Suggest Strong Password===================*/
    
    public static StringBuilder generatePassword(String pass) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        int length = 5;
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));
     
        for(int i = 4; i< length ; i++) {
           password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        
        // Creating array of string length
        char[] ch = new char[pass.length()];
        StringBuilder s = new StringBuilder(ch.length);
        
        // Copy character by character into array
        for (int i = 0; i < pass.length(); i++) {
            ch[i] = pass.charAt(i);
        }
  
        // Printing content of array
        for (char c : ch) {
        	s.append(c);
        }
        s.append(password);
        return s;
     }
    
    
    public static void main(String[] args)
    {
        String input = "Ha";
        checkStrengthOfPassword(input);
        
        System.out.println(generatePassword(input));
        
        
        
    }
}
