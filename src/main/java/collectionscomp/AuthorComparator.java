package collectionscomp;

import java.util.Comparator;

public class AuthorComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Book) o1).getAuthor().compareTo(((Book) o2).getAuthor());
    }
}