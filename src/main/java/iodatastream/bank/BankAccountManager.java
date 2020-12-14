package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {
    public void saveAccount(BankAccount bankAccount, Path path) {
        try {
            DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(
                    path.resolve(bankAccount.getAccountNumber() + ".dat"))));
            writer.writeUTF(bankAccount.getAccountNumber());
            writer.writeUTF(bankAccount.getOwner());
            writer.writeDouble(bankAccount.getBalance());
            writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write this file!", e);
        }
    }

    public BankAccount loadAccount(InputStream inputStream) {
        try {
            DataInputStream reader = new DataInputStream(new BufferedInputStream(inputStream));
            return new BankAccount(reader.readUTF(), reader.readUTF(), reader.readDouble());
        } catch (IOException e) {
            throw new IllegalStateException("Can't read this file!", e);
        }
    }
}
//Az iodatastream.bank csomagba készítsd el a BankAccount osztályt, melyben attribútumként a
//  számlaszám (String), a
//  tulajdonos neve (String) és az
//  egyenleg (double) szerepel!
//  A konstruktor mindhárom attribútumot várja, valamint mindegyikhez van getter.
//
//Készíts egy BankAccountManager osztályt, melyben csak 2 metódus van. A
//  saveAccount() metódus egy
//  BankAccount példány állapotát menti a
//  bankszámla számával megegyező nevű .dat kiterjesztésű fájlba DataOutputStream segítségével.
//  Paraméterként megkapja a mentési mappát is Path objektumknt.
//
//  A loadAccount() ugyanilyen szerkezetű fájlból betölti egy
//  BankAccount adatait, és paraméterként csak egy
//  InputStream-et vár.
//
//A fájl minden adatot tartalmazzon az alábbi sorrendben: számlaszám, tulajdonos neve, egyenleg!