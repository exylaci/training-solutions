package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String newWord, List<String> translations){
        for ( int i=0 ; i<dictionaryItems.size() ; ++i ){
            if ( dictionaryItems.get(i).getWord().equals(newWord) ){
                dictionaryItems.get(i).addTranslations(translations);
                return;
            }
        }
        dictionaryItems.add( new DictionaryItem( newWord,translations ));
    }

    public List<String> findTranslations(String word){
        for ( DictionaryItem one : dictionaryItems ){
            if ( one.getWord().equals(word) ){
                return one.getTranslations();
            }
        }
        return new ArrayList<String>();
    }



}
