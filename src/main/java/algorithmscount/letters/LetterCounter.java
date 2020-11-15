package algorithmscount.letters;

public class LetterCounter {

    public int countLetters(String text , char what){
        int counter = 0;
        for ( int i=0 ; i<text.length() ; ++i ){
            if ( text.charAt(i) == what ){
                ++counter;
            }
        }
        return counter;
    }

}
