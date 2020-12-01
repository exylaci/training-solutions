package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    private List<Object> items = new ArrayList<>();
    private static int cursor = 0;

    public void putItem(Object item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = 0;
    }

    public boolean hasNext() {
        return cursor < items.size();
    }

    public Object next() {
        if (!hasNext()) {
            throw new ArrayIndexOutOfBoundsException("No more item!");
        }
        ++cursor;
        return items.get(cursor - 1);
    }

    public boolean contains(Object item) {
        for (Object one : items) {
            if (one.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int getCursor() {
        return cursor - 1;
    }
}