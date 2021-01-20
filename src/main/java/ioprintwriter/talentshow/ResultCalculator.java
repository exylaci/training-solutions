package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {
    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public void readTalents(Path path) {
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read this file!");
        }
    }

    public void calculateVotes(Path path) {
        votes.clear();
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                increaseVoteOfThisProduction(parse(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant'read this file!");
        }
        sortVotes();
    }

    public void writeResultToFile(Path path) {
        int idOfWinner = getWinnerId();
        try {
            PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8));
            for (Vote one : votes) {
                writer.print(one.getId());
                writer.print(" ");
                writer.print(getProduction(one.getId()));
                writer.print(" ");
                writer.println(one.getNumber());
            }
            writer.print("Winner: ");
            writer.println(getProduction(idOfWinner));
            writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write this file!");
        }
    }

    private void increaseVoteOfThisProduction(int id) {
        for (int i = 0; i < votes.size(); ++i) {
            if (votes.get(i).getId() == id) {
                votes.get(i).incNum();
                return;
            }
        }
        votes.add(new Vote(id, 1));
    }

    private int getWinnerId() {
        int max = 0;
        int id = 0;
        for (Vote one : votes) {
            if (one.getNumber() > max) {
                max = one.getNumber();
                id = one.getId();
            }
        }
        return id;
    }

    private String getProduction(int id) {
        for (Production one : productions) {
            if (one.getId() == id) {
                return one.getName();
            }
        }
        return "";
    }

    private void processOneLine(String oneLine) {
        String[] split = oneLine.split(" ", 2);
        int id = parse(split[0]);
        if (id > 0 && split.length > 1) {
            productions.add(new Production(id, split[1]));
        }
    }

    private int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    private void sortVotes() {
        for (int i = 1; i < votes.size(); ++i) {
            if (votes.get(i - 1).getNumber() > votes.get(i).getNumber()) {
                Vote v = votes.get(i - 1);
                votes.set(i - 1, votes.get(i));
                votes.set(i, v);
                if (i > 1) i -= 2;
            }
        }
    }
}
//Ebben a feladatban egy tehetségkutató showt fogunk szimulálni. A feladat kicsit összetettebb.
// A talents.txt tartalmazza az indulók listáját, míg
// a votes.txt a leadott szavazatokat, azaz az előadó kódját.
//
//A te feladatod, hogy készíts egy kimutatást egy fájlba.
// A fájlnak tartalmaznia a kódot az előadás nevét illetve, hogy az adott előadás hány szavazatot kapott!
// Ezen felül az utolsó sornak tartalmaznia kell a győztes nevét a következő formátumban:
// Winner: győztes neve.