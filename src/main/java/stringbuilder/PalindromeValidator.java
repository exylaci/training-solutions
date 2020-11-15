package stringbuilder;

public class PalindromeValidator {
    public boolean isPalindrome(String param){
        if ( param==null ){
            throw new IllegalArgumentException("Text must not be null!");
        }
        String source = param.trim().toLowerCase();
        StringBuilder reverse = new StringBuilder(param.length());
        reverse.append(source);
        return reverse.reverse().toString().equals( source );
    }
}
