package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments;

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
        comments = new ArrayList<>();
    }

    public Issue(Issue issue, CopyMode copyMode) {
        name = issue.getName();
        time = issue.getTime();
        status = issue.getStatus();
        comments = new ArrayList<>();
        if (copyMode == CopyMode.WITH_COMMENTS) {
            for (Comment one : issue.comments) {
                comments.add(new Comment(one));
            }
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
//Egy hibabejelentő rendszer egy alkalmazással kapcsolatosan bejelentett hibákat tartalmazza.
//
//Legyen egy clone.issuetracker.Issue osztály, mely a rendszerben lévő hibákat reprezentálja,
// egy name attribútummal, LocalDateTime time és egy Status status attribútummal.
// A Status egy enum NEW, IN_PROGRESS és CLOSED értékekkel.
//
//Az Issue tartalmazzon egy clone.issuetracker.Comment listát.
// A Comment tartalmazzon egy String text és egy LocalDateTime time attribútumot.
//
//A Issue osztálynak legyen egy copy konstruktora, mely kap egy
//  másik Issue példányt, valamint egy
//  CopyMode enum értéket. Ez vagy CopyMode.WITH_COMMENTS vagy CopyMode.WITHOUT_COMMENTS.
//      Előbbi esetben a megjegyzéseket is másolja, utóbbi esetben nem.
//
//A megjegyzések is copy konstruktorral legyenek másolhatóak, és ez kerüljön meghívásra (deep copy).