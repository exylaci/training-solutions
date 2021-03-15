package erettsegik.majus2020.akademikusok;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileOperation {
    private Dao dao;

    public FileOperation(DataSource source) {
        dao = new Dao(source);
    }

    public void loadDataFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("tag.txt"), StandardCharsets.UTF_8))) {
            dao.fillUpTag(reader);
        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Cannot read from tag.txt file!",e);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("tagsag.txt"), StandardCharsets.UTF_8))) {
            dao.fillUpTagsag(reader);
        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Cannot read from tag.txt file!",e);
        }
    }

}
