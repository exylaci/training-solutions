package week05.d2;

public class ChangeLetter {
    public final String REPLACE_FROM = "aeiou";
    public final char REPLACE_TO = '*';

    public String chhangeVowels(String input){
        if ( input==null || input.isBlank() ){
            return "";
        }

        StringBuilder result = new StringBuilder(input.length());
        result.append(input);

        for ( int i=0 ; i<result.length() ; ++i ){
            if ( REPLACE_FROM.contains( result.substring(i,i+1).toLowerCase() )){
                result.setCharAt(i,REPLACE_TO);
            }
        }

        return result.toString();
    }
}
