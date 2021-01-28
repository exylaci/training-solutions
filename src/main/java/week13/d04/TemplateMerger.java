package week13.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public static final String NAME = "{nev}";
    public static final String AGE = "{ev}";

    public String merge(Path path, List<Employee> employees) {
        if (employees == null) throw new NullPointerException("List of employees is a must!");
        try {
            String template = Files.readString(path);
            return prepareReplacedLines(template, employees);
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + path);
        }
    }

    private String prepareReplacedLines(String template, List<Employee> employees) {
        StringBuilder result = new StringBuilder(template.length() * employees.size()); //Ekkora méret biztos nem elég, de legalább ekkora viszont biztosan fog kelleni.

        for (Employee employee : employees) {
            result.append(template.replace(NAME, employee.getName())
                    .replace(AGE, "" + employee.getAge()))
                    .append("\n");
        }
        return result.toString();
    }
}
//Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
//metódust, ami felolvassa a fájlt, melynek tartalma:
//
//Az alkalmazott neve: {nev}, születési éve: {ev}
//
//Nyugodtan beolvashatod egy utasítással!Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a
//formátumban, mint ahogy a fájlban van, azaz:
//
//Az alkalmazott neve: John Doe, születési éve: 1980
//Az alkalmazott neve: Jack Doe, születési éve: 1990
//
//(Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.}