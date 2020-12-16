package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {
    public void saveTransactions(Path path, List<Transaction> transactions) {
        if (path == null || transactions == null || transactions.size() == 0) {
            throw new IllegalArgumentException("Path and transaction list are a must!");
        }
        try {
            ZipOutputStream ziped = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)));
            for (Transaction one : transactions) {
                ziped.putNextEntry(new ZipEntry(String.format("%d", one.getId())));
                ziped.write((one.getTime().toString() + "\n").getBytes(StandardCharsets.UTF_8));
                ziped.write((one.getAccount() + "\n").getBytes(StandardCharsets.UTF_8));
                ziped.write((one.getAmount() + "\n").toString().getBytes(StandardCharsets.UTF_8));
                ziped.closeEntry();
            }
            ziped.flush();
            ziped.close();
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Can't write this file!", e);
        } catch (ZipException e) {
            throw new IllegalStateException("Can't create new entry in ZIP file!", e);
        } catch (IOException e) {
            throw new IllegalStateException("Baj van!", e);
        }
    }
}
//Az iozip.transactions csomagba készíts egy
//
// Transaction immutable osztályt, melyben a
// tranzakció azonosítója (long id), a
// tranzakció pontos időpontja (LocalDateTime time), az érintett
// bankszámla száma (String account) és a
// tranzakció összege (double amount) található.
//
//A TransactionFileManager osztály
// saveTransactions() metódusa a paraméterként kapott
// Path-ra elmenti a Transaction listában kapott tranzakciókat tömörítve. Minden tranzakció
// külön szöveges fájlba kerüljön! A
// fájl neve a tranzakció azonosítója legyen!
// Tartalma sortöréssel (\n) elválasztva az
// időpont, a
// bankszámlaszám és az
// összeg.
//
//Például:
//2018-02-13T15:08:43
//10092365-37255375-33310000
//23000.0