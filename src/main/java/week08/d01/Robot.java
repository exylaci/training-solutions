package week08.d01;

public class Robot {
    private Position position = new Position();

    public Position move(String directions) {
        directions = directions.toUpperCase();
        for (int i = 0; i < directions.length(); ++i) {
            oneStep(directions.charAt(i));
        }
        return new Position(position);
    }

    private void oneStep(char direction) {
        switch (direction) {
            case 'J':
                position.increaseX();
                return;
            case 'B':
                position.decreaseX();
                return;
            case 'F':
                position.increaseY();
                return;
            case 'L':
                position.decreaseY();
                return;
            default:
                throw new IllegalArgumentException("Unknown direction!");
        }
    }
}
//A feladatban egy robot mozgását fogjuk szimulálni.
// Képzelj el egy koordináta rendszert, ahol a robot az origóban van.
// A robot négy irányba képes mozogni fel, le, balra és jobbra.
// A week08d01.Robot osztályban írj egy move() metódust ami egy karaktersorozatot vár.
// pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb.
// A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója.
// A feladat szabadon bővíthető osztályokkal és metódusokkal. Bónusz kiegészítés,
// hogyha más karaktert is tartalmaz a paraméter String nem csak a FLBJ valamelyikét,
// akkor dobjunk IllegalArgumentExceptiont!