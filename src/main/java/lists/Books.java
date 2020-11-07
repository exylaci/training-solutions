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
    }

}

//    Készíts egy Books osztályt, melyben egy
//    ArrayList<String> tárolja a könyvek címeit. Írj egy
//    add(String) metódust, mely felveszi a könyvet. Legyen egy
//    List<String> findAllByPrefix(String prefix) metódusa, mely az összes olyan könyvet visszaadja,
//      mely címének eleje megegyezik a paraméterként átadott szöveggel. Legyen egy
//    List<String> getTitles() metódus, mely visszaadja a könyvek címeit.
//    Írj egy main() metódust, mely teszteli a metódusok működésé