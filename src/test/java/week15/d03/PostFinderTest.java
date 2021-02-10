package week15.d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void findPosts() {
        List<Post> testData = Arrays.asList(
                new Post("My First Post", LocalDate.of(2018, 1, 6), LocalDate.of(2019, 6, 19), "Tartalom", "Pista"),
                new Post("My Article", LocalDate.of(2019, 3, 18), null, "Tartalom", "Pista"),
                new Post("I like Java", LocalDate.of(2020, 2, 20), null, "Tartalom", "Pista")
        );
        PostFinder p = new PostFinder(testData);
        System.out.println(p.findPosts("Pista"));
    }

    @Test
    void findPostsFor() {
        List<Post> testData = Arrays.asList(
                new Post("My First Post", LocalDate.of(2018, 1, 6), LocalDate.of(2019, 6, 19), "Tartalom", "Pista"),
                new Post("My Article", LocalDate.of(2019, 3, 18), null, "Tartalom", "Pista"),
                new Post("I like Java", LocalDate.of(2020, 2, 20), null, "Tartalom", "Pista")
        );
        PostFinder p = new PostFinder(testData);
        System.out.println(p.findPostsFor("Pista"));
    }
}