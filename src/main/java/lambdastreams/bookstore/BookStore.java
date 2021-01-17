package lambdastreams.bookstore;

import java.util.*;
import java.util.stream.Collectors;

public class BookStore {
    List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
//       return (int) books.stream().
//                map(Book::getPieces).
//                reduce(0,Integer::sum);

        return (int) books.stream().
                reduce(0, (a, next) -> a + next.getPieces(), Integer::sum);
    }

    public Optional<Book> findNewestBook() {
//        return books.stream().
//                reduce((one, next) -> one.getYearOfPublish() > next.getYearOfPublish() ? one : next);

        return books.stream().
                max(Comparator.comparingInt(Book::getYearOfPublish));
    }

    public int getTotalValue() {
        return (int) books.stream().
                reduce(0, (a, next) -> a + next.getPrice() * next.getPieces(), Integer::sum);
    }

    public List<Book> getByYearOfPublish(int year) {
        List<Book> temp = books.stream().
                filter(a -> a.getYearOfPublish() == year).
                collect(Collectors.toCollection(ArrayList::new));
//        if (temp.isEmpty()) return null;
//        return temp;

        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
//Készíts egy Book osztályt a könyv címével, kiadási évével, árával, darabszámával!
// A konstruktor is ebben a sorrendben kapja meg az adatokat.
//
//A BookStore osztály tartalmazza a könyvek listáját.
// A listát a konstruktorban kapja meg. Készítsd el benne az alábbi metódusokat streamek segítségével:
//  getNumberOfBooks(): a könyvek számát adja meg
//  findNewestBook(): a legújabb kiadású könyvet adja vissza
//  getTotalValue(): a könyvek összértékét adja meg
//
//Bónusz feladat
//
//Nézz utána a Collectors osztály groupingBy() metódusának, és készítsd el az alábbi metódust is!
//  getByYearOfPublish(int year): adott évben kiadott könyvek listáját adja vissza