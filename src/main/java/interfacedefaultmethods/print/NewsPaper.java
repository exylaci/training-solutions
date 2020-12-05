package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable {
    private List<String> pages = new ArrayList<>();


    public void addPage(String page){
        pages.add(page);
    }

    @Override
    public String getPage(int index) {
        return pages.get(index);
    }

    @Override
    public String getColor(int index) {
        return Printable.BLACK;
    }

    @Override
    public int getLength() {
        return pages.size();
    }
}
