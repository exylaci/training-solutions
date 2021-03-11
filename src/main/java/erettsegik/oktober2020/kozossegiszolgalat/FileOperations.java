package erettsegik.oktober2020.kozossegiszolgalat;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileOperations {
    private DataSource source;

    public FileOperations(DataSource source) {
        this.source = source;
    }

    public void loadDataFromTextFiles() {
        loadDiakDataFromTextFile();
        loadTevekenysegDataFromTextFile();
        loadMunkaDataFromTextFile();
        loadJelentkezesDataFromTextFile();
    }

    private void loadDiakDataFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("diak.txt"), StandardCharsets.UTF_8))) {
            Dao dao = new Dao(source);
            dao.fillupDiak(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read from diak.txt file!");
        }
    }

    private void loadTevekenysegDataFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("tevekenyseg.txt"), StandardCharsets.UTF_8))) {
            Dao dao = new Dao(source);
            dao.fillupTevekenyseg(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read from tevekenyseg.txt file!");
        }
    }

    private void loadMunkaDataFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("munka.txt"), StandardCharsets.UTF_8))) {
            Dao dao = new Dao(source);
            dao.fillupMunka(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read from munka.txt file!");
        }
    }

    private void loadJelentkezesDataFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("jelentkezes.txt"), StandardCharsets.UTF_8))) {
            Dao dao = new Dao(source);
            dao.fillupJelentkezes(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read from jelentkezes.txt file!");
        }
    }
}