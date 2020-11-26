package troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    public static final String ERROR_MESSAGE_TROOPER_NEEDED = "Trooper is a must!";
    public static final String ERROR_MESSAGE_CANT_FIND = "This trooper doesn't exist!";
    public static final String ERROR_MESSAGE_EXISTS = "This trooper already exists!";
    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return new ArrayList<>(troopers);
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TROOPER_NEEDED);
        }
        if (findTrooperByName(trooper.getName()) != null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EXISTS);
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(Trooper.ERROR_MESSAGE_NAME);
        }
        if (target == null) {
            throw new IllegalArgumentException(Trooper.ERROR_MESSAGE_POSITION);
        }

        Trooper trooper = findTrooperByName(name);
        if (trooper == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CANT_FIND);
        }
        trooper.changePosition(target);
    }

    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException(Trooper.ERROR_MESSAGE_POSITION);
        }
        findClosestTrooper(target).changePosition(target);
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper one : troopers) {
            if (one.getName().equals(name)) {
                return one;
            }
        }
        return null;
    }

    private Trooper findClosestTrooper(Position target) {
        double shortestDistance = Double.MAX_VALUE;
        Trooper closestTrooper = null;
        for (Trooper one : troopers) {
            double currentDistance = one.getPosition().distanceFrom(target);
            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestTrooper = one;
            }
        }
        return closestTrooper;
    }

    private void moveTrooper(Trooper trooper, Position position) {
        trooper.changePosition(position);
    }
}
