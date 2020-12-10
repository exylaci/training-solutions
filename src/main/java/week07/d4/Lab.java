package week07.d4;

import java.time.LocalDate;

public class Lab {
    private String title;
    private Completed completed;
    private LocalDate completedAt;

    public enum Completed {NOT_COMPLETED, COMPLETED};

    public Lab(String title) {
        this.title = title;
        completed=Completed.NOT_COMPLETED;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        completed=Completed.COMPLETED;
        this.completedAt = completedAt;
    }

    public void completed(LocalDate completedAt){
        completed=Completed.COMPLETED;
        this.completedAt=completedAt;
    }

    public void completed(){
        completed=Completed.COMPLETED;
        this.completedAt=LocalDate.now();
    }

    @Override
    public String toString() {
        return  "Lab{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", completedAt=" + completedAt +
                '}';
    }

    public Completed getCompleted() {
        return completed;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }
}
//Mai junior/mid-level feladat:
//Hozz létre egy week07d04.Lab nevű osztályt, ami azt tárolja el, hogy melyik feladattal készültél el.
// Három attribútuma:
// title ami a tananyag neve, egy
// completed, hogy elkészültél-e vele, és a
// completedAt , ami azt tárolja, hogy mikor.
//
// Legyen két konstruktora!
// Az egyik csak a címet várja, ekkor úgy állítsa be a példányt, hogy még nem készültél el.
// Legyen egy másik, ami várja a címet és a dátumot. Ekkor azt állítsa be, hogy elvégezted a gyakorlati feladatot.
//
// Írj egy complete metódust, ami kap egy dátumot, és beállítja, hogy elvégezted a gyakorlati feladatot.
// Legyen egy complete metódusa, ami semmit nem vár, ez azt állítja be, hogy MOST végezted el a gyakorlati feladatot.
//
// Írd meg a toString metódusát is! (edited)
