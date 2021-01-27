package week13.d03;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Books {
    private List<Book> books = new ArrayList<>();

    public Books(List<Book> books) {
        this.books = books;
    }

    public String getThePostActiveAuthorStream() {
        return books
                .stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet()
                .stream()
                .max((a, b) -> (int) (a.getValue() - b.getValue()))
                .get()
                .getKey();
    }

    public String getThePostActiveAuthorForCiklus() {

        Map<String, Integer> result = new HashMap<>();
        for (Book book : books) {
            if (result.containsKey(book.getAuthor())) {
                result.replace(book.getAuthor(), result.get(book.getAuthor()) + book.getPages());
            } else {
                result.put(book.getAuthor(), book.getPages());
            }
        }

        int max = 0;
        String author = "";
        for (Map.Entry<String, Integer> one : result.entrySet()) {
            if (max < one.getValue()) {
                max = one.getValue();
                author = one.getKey();
            }
        }
        return author;

    }


}
