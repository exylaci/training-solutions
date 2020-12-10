package week07.d4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShoppingList {
    public static final String LIST_SEPARATOR = ";";

    public long calculateSum(String path){
        try {
            List<String> shoppingList = Files.readAllLines(Path.of(path));
            return summarize(shoppingList);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant read this file: "+path);
        }
    }

    private long summarize(List<String> shoppingList) {
        long sum = 0;
        for (String one : shoppingList) {
            String[] split = one.split(LIST_SEPARATOR);
            if (split.length>2){
                sum+=getNumber(split[1])*getNumber(split[2]);
            }
        }
        return sum;
    }

    private long getNumber(String s) {
        try {
            return Long.parseLong(s);
        }catch (NumberFormatException e){
            return 0;
        }
    }

}
//A week07d04.ShoppingList osztályba írj egy
// long calculateSum(String path) metódust, mely a
// paraméterként átadott fájlból beolvassa a bevásárlólista tartalmát, és összegzi az árat.
// A fájl a következő formátumú sorokat tartalmazza:
// kenyér;2;30 ahol az első a termék neve, a második a darabszám, a harmadik az egységár.
// Azaz ezen sor esetén 2*30 = 60 értékkel kell számolni.