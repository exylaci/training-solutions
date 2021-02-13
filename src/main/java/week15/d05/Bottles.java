package week15.d05;

import java.util.ArrayList;
import java.util.List;

public class Bottles {

    private String name;
    private int year;
    private int battleNumber;
    private String attackerKing;
    private String defenderKing;
    private List<String> attackers = new ArrayList<>();
    private List<String> defenders = new ArrayList<>();
    private String attackerOutcome;
    private String battleType;
    private int majorDeath;
    private int majorCapture;
    private int attackerSize;
    private int defenderSize;
    private String attackerCommander;
    private String defenderCommander;
    private int summer;
    private String location;
    private String region;
    private String note;

    public Bottles(List<String> values) {
        name = values.get(0);
        if (!values.get(1).isBlank()) year = Integer.parseInt(values.get(1));
        if (!values.get(2).isBlank()) battleNumber = Integer.parseInt(values.get(2));
        attackerKing = values.get(3);
        defenderKing = values.get(4);
        for (int i = 5; i < 9; ++i) {
            if (!values.get(i).isBlank()) {
                attackers.add(values.get(i));
            }
        }
        for (int i = 9; i < 13; ++i) {
            if (!values.get(i).isBlank()) {
                defenders.add(values.get(i));
            }
        }
        attackerOutcome = values.get(13);
        battleType = values.get(14);
        if (!values.get(15).isBlank()) majorDeath = Integer.parseInt(values.get(15));
        if (!values.get(16).isBlank()) majorCapture = Integer.parseInt(values.get(16));
        if (!values.get(17).isBlank()) attackerSize = Integer.parseInt(values.get(17));
        if (!values.get(18).isBlank()) defenderSize = Integer.parseInt(values.get(18));
        attackerCommander = values.get(19);
        defenderCommander = values.get(20);
        if (!values.get(21).isBlank()) summer = Integer.parseInt(values.get(21));
        location = values.get(22);
        region = values.get(23);
        if (values.size() > 24) note = values.get(24);
    }

    public List<String> getAttackers() {
        return attackers;
    }

    public List<String> getDefenders() {
        return defenders;
    }

    @Override
    public String toString() {
        return "Bottles{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", battleNumber=" + battleNumber +
                ", attackerKing='" + attackerKing + '\'' +
                ", defenderKing='" + defenderKing + '\'' +
                ", attackers=" + attackers +
                ", defenders=" + defenders +
                ", attackerOutcome='" + attackerOutcome + '\'' +
                ", battleType='" + battleType + '\'' +
                ", majorDeath=" + majorDeath +
                ", majorCapture=" + majorCapture +
                ", attackerSize=" + attackerSize +
                ", defenderSize=" + defenderSize +
                ", attackerCommander='" + attackerCommander + '\'' +
                ", defenderCommander='" + defenderCommander + '\'' +
                ", summer=" + summer +
                ", location='" + location + '\'' +
                ", region='" + region + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}