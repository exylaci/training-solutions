package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {
    public void saveShoppingList(OutputStream outputStream, List<String> list) {
        if (outputStream == null || list == null) throw new IllegalArgumentException("Parameter cannot benull!");

        try {
            Writer writer = new OutputStreamWriter(new BufferedOutputStream(outputStream));

            for (String one : list) {
                writer.write(one + "\n");
            }

            writer.close();

        } catch (IOException e) {
            throw new IllegalStateException("Can't write!", e);
        }
    }

    public List<String> loadShoppingList(InputStream inputStream) {
        if (inputStream == null) throw new IllegalArgumentException("Input stream is a must!");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            List<String> result = new ArrayList<>();
            String oneLine;

            while ((oneLine = reader.readLine()) != null) {
                result.add(oneLine);
            }
            return result;

        } catch (IOException e) {
            throw new IllegalStateException("Can't read!", e);
        }
    }
}
//Az ioconvert.shopping csomagba készíts egy ShoppingListManager osztályt!
// A saveShoppingList() metódusa a
// paraméterül kapott OutputStream-re kiírja a
// szintén paraméterül kapott List<String> tartalmát szövegként, minden elemet külön sorba.
//
// A loadShoppingList() metódusa a paraméterül kapott Inputstream-ből beolvassa a bevásárlólista tartalmát,
// amit szöveglistaként ad vissza.