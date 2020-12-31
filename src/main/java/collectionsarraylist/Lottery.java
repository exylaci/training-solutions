package collectionsarraylist;

import java.util.*;

public class Lottery {
    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount)
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");

        Set<Integer> result = new HashSet<Integer>(lotteryType);
        Random rnd = new Random();
        while(result.size()<lotteryType){
            int next = rnd.nextInt(ballCount)+1;
            result.add(next);
        }

        return List.copyOf(result);
    }
}
//Implementálj egy lottó gépet, ahol megadható a lottó típusa (ötös, hatos, stb.)
// és az is, hogy hány számból válasszon (golyók száma).
//
// Írj egy osztályt, amely létrehozza a golyókat (List<Integer> értékek),
// összekeveri,
// majd megcsinálja a "húzást", azaz kiválaszt a lottó típusának megfelelő számú golyót,
// majd a kihúzott számokat növekvő sorba rendezi és úgy adja vissza.

//A húzást a selectWinningNumbers(int lotteryType, int ballCount) metódus végzi,
// amely egy (List<Integer>) értéket ad vissza.
//
//Hibakezelés
// Ha a selectWinningNumbers(int lotteryType, int ballCount) metódust rossz paraméterekkel hívták meg
// (több vagy ugyanannyi számot kellene kihúzni, mint amennyit generál),
// a metódus dobjon egy IllegalArgumentException kivételt.

//Megvalósítás
// Maximálisan használjuk ki a megfelelő kollekció nyújtotta lehetőségeket!
// A visszaadott számok pozitív egész számok, és nem lehetnek nagyobbak, mint amennyi golyó van.
// A golyók számozása egytől kezdődik. Ugyanaz a szám nem szerepelhet kétszer.
//
//publikus metódusok:
//  public List<Integer> selectWinningNumbers(int lotteryType, int ballCount)
//
//Tippek
// Nézz utána, hogyan lehet List típusok esetén az elemeket rendezni (mi ennek a feltétele?),
// a rendezettséget megszüntetni.