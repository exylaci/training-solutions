package filescanner.library;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class Library {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks(){
        return books;
    }
    public void loadFromFile(){
        try (Scanner file = new Scanner(Library.class.getResourceAsStream("books.csv"))) {
            while (file.hasNextLine()){
                Scanner line = new Scanner(file.nextLine());
                line.useDelimiter(";");
                List<String> datas = new ArrayList<>();
                while ( line.hasNext() ){
                    datas.add(line.next());
                }
                books.add(new Book(datas.get(0),datas.get(1),datas.get(2),Integer.parseInt(datas.get(3))));
            }
        }
    }

    public void add(Book books){
        this.add(books);
    }
    public void saveBooks(Path path){
    }
    public void loadBooks(Path path){
        try (Scanner file = new Scanner(path)) {
            while (file.hasNextLine()){
                Scanner line = new Scanner(file.nextLine());
                line.useDelimiter(Pattern.compile(";|(\r\n)"));
                List<String> datas = new ArrayList<>();
                while ( line.hasNext() ){
                    datas.add(line.next());
                }
                books.add(new Book(datas.get(0),datas.get(1),datas.get(2),Integer.parseInt(datas.get(3))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Library l = new Library();
        l.loadFromFile();
    }
}

// A Library osztály attribútumként egy List<Book>-ot tartalmaz.
// A loadFromFile() metódusa a classpathon található books.csv fájlból tölti be a könyvek adatait.
//   A fájl minden sora egy könyv adatait tartalmazza pontosvesszővel elválasztva.