import java.util.*;

import javax.swing.JOptionPane;

public class PasswordValidator {

    // A utility function to check
    // whether a password is valid or not
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
    public static boolean checkStrengthOfPassword(String input)
    {
        // Checking lower alphabet in string
        int n = input.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                          '*', '(', ')', '-', '+'));
        for (char i : input.toCharArray())
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
    
    
 // adding more characters to suggest
    // strong password
    static StringBuilder add_more_char(
                        StringBuilder str, int need)
    {
        int pos = 0;
        Random randm = new Random();
         
        // all 26 letters
        String low_case = "abcdefghijklmnopqrstuvwxyz";
 
        for (int i = 0; i < need; i++) {
            pos = randm.nextInt(1000) % str.length();
            str.setCharAt(pos,low_case.charAt(
                            randm.nextInt(1000) % 26));
        }
        return str;
    }
    
    				/*=================Suggest Strong Password===================*/
    
    // make powerful String
    static StringBuilder suggester(int l, int u, int d,
                              int s, StringBuilder str)
    {
        Random randm = new Random();
         
        // all digits
        String num = "0123456789";
 
        // all lower case, uppercase and special
        // characters
        String low_case = "abcdefghijklmnopqrstuvwxyz";
        String up_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String spl_char = "@#$_()!";
 
        // position at which place a character
        int pos = 0;
 
        // if there is no lowercase char in input String, add it
        if (l == 0) {
             
            // generate random integer under String length()
            pos = randm.nextInt(1000) % str.length();
 
            // generate random integer under 26 for indexing of a to z
            str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
                                        % 26));
        }
 
        // if there is no upper case char in input String, add it
        if (u == 0) {
            pos = randm.nextInt(1000) % str.length();
            str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
                                        % 26));
        }
 
        // if there is no digit in input String, add it 
        if (d == 0) {
            pos = randm.nextInt(1000) % str.length();
            str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
                                        % 10));
        }
 
        // if there is no special character in input String, add it
        if (s == 0) {
            pos = randm.nextInt(1000) % str.length();
            str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
                                        % 7));
        }
 
        return str;
    }
 
    /* make_password function :This function is used 
    to check strongness and if input String is not
    strong, it will suggest*/
    static StringBuilder generate_password(int n, StringBuilder p)
    {
         
        // flag for lower case, upper case, special
        // characters and need of more characters
        int l = 0, u = 0, d = 0, s = 0, need = 0;
 
        // password suggestions.
        StringBuilder suggest = null;
        
        /*suggest 10 strong Strings */
        for (int i = 0; i < 2; i++) {
            suggest = suggester(l, u, d, s, p);
            need = 8 - suggest.length();
            if (need > 0)
                suggest = add_more_char(suggest, need);
            System.out.println(suggest);
        }
		return suggest;
    }
    
    public static void main(String[] args)
    {
        String input = "GeeksforGeeks!@12";
        checkStrengthOfPassword(input);
        
        StringBuilder input_String = new StringBuilder("geek@2018");
        generate_password(input_String.length(), input_String);
    }
}
