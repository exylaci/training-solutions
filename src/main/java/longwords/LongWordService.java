package longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writeWithoutStringWriter(Writer writer, List<String> words) {
        try {
            for (String one : words) {
                writer.write(one);
                writer.write(";" + one.length() + "\n");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write to this channel!");
        }
    }

    public String writeWithStringWriter(List<String> words) {
        StringWriter writer = new StringWriter();
        writeWithoutStringWriter(writer, words);
        try {
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write to StringWriter!");
        }
        return writer.toString();
    }
}
