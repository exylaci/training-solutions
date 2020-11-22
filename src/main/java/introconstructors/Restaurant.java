package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        capacity = numberOfTables * 4;
        prepareMenu();
    }

    private void prepareMenu(){
        menu.add("Rhús");
        menu.add("fasírt");
        menu.add("pörkölt");
        menu.add("nokedli");
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
