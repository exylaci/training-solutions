package controlselection.consonant;

public class ToConsonant {

    public char convertToConsonant(char c){
        switch (c){
            case 'a','e','i','o','u': ++c;
        }
        return c;
    }

}
