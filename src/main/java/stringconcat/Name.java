package stringconcat;

import finalmodifier.TaxCalculator;
import statements.Time;

public class Name {
    String familyName;
    String middleName;
    String givenName;
    Title title;

    public Name(String familyName, String middleName, String givenName) {
       if (isEmpty(familyName) || isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public Name(String familyName, String middleName, String givenName, Title title) {
        this(familyName,middleName,givenName);
        this.title = title;
    }

    public String concatNameWesternStyle(){
        //"Mr. John G Smith"
        return (title == null ? "" : title.getValue() + " ") + givenName + " " +
                (isEmpty(middleName) ? "" : middleName + " ") + familyName;
    }

    public String concatNameHungarianStyle(){
        String name = "";
        if (title!=null) {
            name = name = title.getValue().concat(" ");
        }
        name = name.concat(familyName).concat(" ");
        if (!isEmpty(middleName)){
            name = name.concat(middleName).concat(" ");
        }
        return name.concat(givenName);
    }

    private boolean isEmpty(String s){
        return s==null || s.length()==0;
    }
}
