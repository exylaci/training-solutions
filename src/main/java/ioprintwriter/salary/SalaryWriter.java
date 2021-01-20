package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {
    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = new ArrayList<>(names);
    }

    public void writeNamesAndSalaries(Path path) {
        try {
            PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path));
            for (String one : names) {
                writer.print(one + ": ");
                writer.println(getSalary(one));
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write this file!", e);
        }
    }

    private int getSalary(String one) {
        String[] split = one.split(" ");
        switch (split[0].replace(".", "")) {
            case "Dr":
                return 500000;
            case "Mr":
            case "Mrs":
                return 200000;
            default:
                return 100000;
        }
    }
}
//Ebben a feladatban emberek fizetését kell meghatároznod titulus alapján.
// A SalaryWriter osztály konstruktorban kap egy név listát.
// A writeNamesAndSalaries(Path file) metódus kiírja a fájlba név: összeg formátumban.
// A fizetések a következő képpen alakulnak:
//
//    Ha tartalmazza a név a "Dr" előtagot, akkor 500000
//    Ha a "Mr" vagy "Mrs" előtagot akkor 200000
//    Különben 100000