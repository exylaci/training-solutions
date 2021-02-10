package week15.d03;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {


    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPosts(String user) {
        return posts
                .stream()
                .filter(post -> post.getTitle() != null)
                .filter(post -> post.getContent() != null)
                .filter(post -> post.getPublishedAt().isBefore(LocalDate.now()))
                .filter(post -> post.getDeletedAt() == null || post.getDeletedAt().isAfter(LocalDate.now()))
                .filter(post -> LocalDate.now().isBefore(post.getPublishedAt()) || post.getOwner().equals(user))
                .collect(Collectors.toList());
    }

    public List<Post> findPostsFor(String user) {
        return posts
                .stream()
                .filter(post -> post.getContent() != null)
                .filter(post -> post.getTitle() != null)
                .filter(post -> post.getOwner().equals(user))
                .filter(post -> post.getPublishedAt().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }
}
//Tároljunk egy List<Post> objektumot a PostFinder osztályban, melyet konstruktor paraméterként kap meg és ezt használjuk!
//
//Implementáljunk a PostFinder osztályban egy
//
//public List<Post> findPosts(String user) metódust az alábbi módon:
//- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
//- Ha a Post publishedAt dátuma későbbi, mint a LocalDate.now(), akkor csak azokat a Post-okat adjuk vissza,
//      melyek owner-e megegyezik a megadott user-rel.
//- A content és a title nem lehet üres
//- A deletedAt értéke null kell, hogy legyen, vagy későbbi, mint a LocalDate.now().
//
//public List<Post> findPostsFor(String user) metódust az alábbi módon:
// - Csak olyan Post-ot adjunk vissza, amelynek az owner-e megegyezik a megadott user-rel
//- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
//- A content és a title nem lehet üres