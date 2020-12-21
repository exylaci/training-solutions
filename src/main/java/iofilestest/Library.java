package iofilestest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void saveBooks(Path path) {
        check(path, false);
        try (DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Book one : books) {
                writer.writeUTF(one.getAuthor());
                writer.writeUTF(one.getTitle());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write to file!", e);
        }
    }

    public void loadBooks(Path path) {
        check(path, true);
        books.clear();
        try (DataInputStream reader = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            while (reader.available() > 0) {
                String author = reader.readUTF();
                String title = reader.readUTF();
                add(new Book(author, title));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!", e);
        }
    }

    private void check(Path path, boolean isLoad) {
        if (path == null) {
            throw new IllegalArgumentException("Path is a must!");
        }
        if (isLoad && !Files.exists(path)) throw new IllegalArgumentException("File doesn't exist!");
    }

    public List<Book> getBooks() {
        return books;
    }
}
//Készíts egy Book osztályt, amely a könyv címét és szerzőjét tartalmazza.
//
//A Library osztály a könyvek listáját attribútumként tárolja.
// Könyveket lehet hozzáadni az add(Book...) metódusával, mely
//  csak azokat a könyveket adja a listához, amelyek még nem voltak benne.
// Az osztály aktuális állapotát szöveges fájlba lehet menteni,
// illetve fájlból be lehet tölteni az ott lévő könyveket.
//
//Készítsd el a teszteket is a Library osztályhoz.