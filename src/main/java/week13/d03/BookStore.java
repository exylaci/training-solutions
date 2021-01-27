package week13.d03;

import java.util.*;
import java.util.stream.Collectors;

public class BookStore {

    public String getThePostActiveAuthorStream(List<Book> books) {
        if (books == null) throw new IllegalArgumentException("The bookList is a must!");

        Optional<Map.Entry<String, Integer>> result = books
                .stream()
                .filter(book -> book.getAuthor() != null)
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingInt(Book::getPages)))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue));

        if (result.isPresent()) {
            return result.get().getKey();
        } else {
            return "Senki nem írt egyetlen oldalt sem.";
        }
    }

    public String getThePostActiveAuthorForCiklus(List<Book> books) {
        if (books == null) throw new IllegalArgumentException("The bookList is a must!");

        Map<String, Integer> result = summarisingByAuthor(books);
        return selectWhoHasTheMaxPages(result);
    }

    private String selectWhoHasTheMaxPages(Map<String, Integer> result) {
        int max = -1;
        String author = "";
        for (Map.Entry<String, Integer> one : result.entrySet()) {
            if (max < one.getValue()) {
                max = one.getValue();
                author = one.getKey();
            }
        }

        if (max > 0) {
            return author;
        } else {
            return "Senki nem írt egyetlen oldalt sem.";
        }
    }

    private Map<String, Integer> summarisingByAuthor(List<Book> books) {
        Map<String, Integer> result = new HashMap<>();
        for (Book book : books) {
            if (result.containsKey(book.getAuthor())) {
                result.replace(book.getAuthor(), result.get(book.getAuthor()) + book.getPages());
            } else {
                result.put(book.getAuthor(), book.getPages());
            }
        }
        return result;
    }
}
//Legyen egy Book osztály, melynek van egy String author, String title és int numberOfPages attribútuma.
//Írj egy másik osztályban egy olyan metódust, mely visszaadja a legtöbb oldalt író szerzőt!
//
//Figyelj arra, hogy hatékony legyen az algoritmus!