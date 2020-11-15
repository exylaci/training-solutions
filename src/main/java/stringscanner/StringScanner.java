package stringscanner;

import java.util.Scanner;

public class StringScanner {
    public final String ERROR_MESSAGE = "Incorrect parameter string!";
    public int readAndSumValues(String intString, String delimiter){

        Scanner s = new Scanner(intString);
        if ( !isEmpty(delimiter) ){
            s.useDelimiter(delimiter);
        }
        int sum=0;
        while (s.hasNext()){
            if ( !s.hasNextInt() ) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            sum += s.nextInt();
        }
        return sum;
    }

    public int readAndSumValues(String intString){
        return readAndSumValues(intString,null);
    }

    public String filterLinesWithWordOccurrences(String text, String word){
        if ( isEmpty(text) || word==null ) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if ( isEmpty(word) && !word.contains(" ") ) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        Scanner sc = new Scanner(text);
        StringBuilder sb = new StringBuilder(text.length());

        while ( sc.hasNext() ){
            String s = sc.nextLine();
            if ( s.contains(word) ){
                sb.append(s);
                sb.append("\n");
            }
        }
        int l = sb.length();
        if (l>0) {
            --l;
        }
        return sb.substring(0,l).toString();
    }

    private boolean isEmpty(String s){
        return s==null || s.isBlank();
    }
}
