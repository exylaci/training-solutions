package controliteration.dictionary;

import filescanner.library.Library;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> translations = new ArrayList<>();

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        this.translations = new ArrayList<>(translations);

//      addTranslations(translations);          // így is lehet

//      this.translations = translations;       //Így viszont nem jó, mert translations "Arrays.asList()"-tel lett
                                                //létrehozva, amihez később már nem lehet újabb elemet hpzzáadni.
    }

    public void addTranslations(List<String> newTranslations){
        for ( String oneNewWord : newTranslations ){
            if ( !translations.contains( oneNewWord ) ){
                translations.add( oneNewWord );
            }
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }
}
