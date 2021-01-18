package week12.d01;

import java.util.Arrays;

public class GradeRounder {
    public int[] roundGrades(int[] grades) {
        if (grades == null) return null;

        int[] result = new int[grades.length];
        for (int i = 0; i < grades.length; ++i) {
            if (grades[i] < 40 ||grades[i]>100) {
                result[i] = grades[i];
            } else {
                result[i] = (int) Math.max(
                        Math.round(grades[i] * 2 / 10.0) * 10 / 2,      // szándékosan, (a megértés kedvéért) nem egyszerűsítettem a "*2/10.0"-et.
                        grades[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GradeRounder g = new GradeRounder();
        System.out.println(Arrays.toString(new int[]{39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}));
        System.out.println(Arrays.toString(g.roundGrades(new int[]{39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50})));
    }
}
//Készíts egy GradeRounder osztályt, amiben van egy int[] roundGrades(int[] grades) metódus.
// A grades tömb pontszámokat tartalmaz 0 és 100 között.
//
// A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint:
// Ha a pontszám és az 5 következő többszöröse közötti különbség kisebb, mint 3, akkor kerekítsük fel a számot az
// 5 következő többszörösére. Fontos: a 40 pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni.
//
// Példa: a pontszám 84. 85 - 84 kevesebb mint 3, így felfelé kerekítünk.
// lelele nem kerekitunk.