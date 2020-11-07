package lists;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private ArrayList<String> books = new ArrayList<>();

    public void add(String title){
        books.add(title);
    }

    public List<String> findAllByPrefix(String prefix){
        List<String> samePrefix = new ArrayList<>();
        for (String oneBook: books) {
            if (oneBook.toLowerCase().substring(0,prefix.length()).equals( prefix.toLowerCase() )){
                samePrefix.add(oneBook);
            }
        }
        return samePrefix;
    }

    public List<String> getTitles(){
        return books;
    }

    public void removeByPrefix(String prefix){
        books.removeAll(findAllByPrefix(prefix));
    }
    
    public void removeByPrefixEgyenkent(String prefix){
        try {
            for ( String oneBook : books ) {
                if ( oneBook.toLowerCase().substring(0,prefix.length()).equals( prefix.toLowerCase() )){
                    books.remove(oneBook);
                }
            }
        } catch (Exception e){
            System.out.println("Nem lehet bejárás közben törölni a listából! " +e);
        }
    }

    public static void main(String[] args) {
        Books books = new Books();
        books.add("Aranyember");
        books.add("Kőszivű ember fiai");
        books.add("Arany sárkány");
        books.add("Nem mind Arany ami fénylik");
        books.add("Aranyoskám");
        books.add("Robotuniverzum");
        books.add("Acélbarlangok");
        books.add("aranyásók");
        books.add("ARANY");
        System.out.println(books.getTitles().toString());
        System.out.println();
        System.out.println(books.findAllByPrefix("Arany").toString());

        System.out.println("Bonus 2.");
//        books.removeByPrefix("Arany");
//        System.out.println(books.getTitles().toString());

        books.removeByPrefixEgyenkent("Arany");
        System.out.println(books.getTitles().toString());
    }
}

//    Készíts egy Books osztályt, melyben egy
//    ArrayList<String> tárolja a könyvek címeit. Írj egy
//    add(String) metódust, mely felveszi a könyvet. Legyen egy
//    List<String> findAllByPrefix(String prefix) metódusa, mely az összes olyan könyvet visszaadja,
//      mely címének eleje megegyezik a paraméterként átadott szöveggel. Legyen egy
//    List<String> getTitles() metódus, mely visszaadja a könyvek címeit.
//    Írj egy main() metódust, mely teszteli a metódusok működésé

//    A Books osztálynak legyen egy
//    removeByPrefix(String prefix) metódusa mely kiveszi a könyvet a címének első pár karaktere alapján
//    (az összes előfordulást).
//    Mi van akkor, ha egy ciklusban mész végig az elemeken, és ha a feltételnek megfelel az elem
//        azonnal törölni próbálod? Hogyan lehet ezt kikerülni? Használd a removeAll() metódust!
