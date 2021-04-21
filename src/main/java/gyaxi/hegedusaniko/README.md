Algoritmizálási feladatok, tömbök gyakorlása tesztesetekkel

Kellemes időtöltést kívánok!

## Exercise 7.1: lastindexof

Írj egy lastIndexOf nevű metódust, mely paraméterül kap egy egész számoból álló tömböt és egy egész számot. A metódus
adja vissza a paraméterül kapott szám utolsó indexét. Ha a tömb nem tartalmaz ilyen számot, a visszatérési érték -1 
legyen.
Pl.  {74, 85, 102, 99, 101, 85, 56} tömb esetén a 85 utolsó indexe 5.

## Exercise 7.2: range

Írj egy range nevű statikus metódust, mely egy egész számokból álló tömböt kap, és a benne szereplő számok terjedelmével
tér vissza. Egy tömb terjedelme a legkisebb és legnagyobb számok közötti különbség +1. Tehát, ha a legnagyobb szám 15, a 
legkisebb pedig 4, akkor a terjedelme 12 (mert 15 - 4 + 1).
A tömb negatív számokat is tartalmazhat, és tételezzük fel, hogy legalább egy elemet tartalmaz. Ilyenkor a visszatérési 
érték 1.

## Exercise 7.3: countinrange

Írj egy countInRange metódust, ami egy egész számokból álló tömböt, egy minimum és egy maximum értéket vár. A metódus 
számolja meg, hogy a két érték közé hány darab elem esik.
Pl ({14, 1, 22, 17, 36, 7, -43, 5}, 4, 17) bemenő paraméterek esetén az eredmény 3 legyen!

## Exercise 7.4: issorted

Legyen egy isSorted nevű statikus metódus, mely lebegőpontos számokból álló tömböt vár paraméterként, és eldönti, hogy 
a számok növekvő sorrendben vannak-e. Pl {1.5, 4.3,4.3, 7.0, 19.5, 25.1, 46.2} esetén igazzal tér vissza, különben hamisal.
Feltételezzük, hogy a tömnek van legalább egy eleme. Az egy elemű tömböt sorba rendezettnek tekintjük(true).

## Exercise 7.5: mode

Írj egy mode nevű metódust, mely egy egész számokat tartalmazó tömbből visszaadja a leggyakrabban előforduló számot. 
Tételezzük fel, hogy a tömb legalább egy elemet tartalmaz. Az elemek intervalluma legyen 0-100, ha nem így van, dobjunk 
kivételt.
Pl {27, 15, 15, 11, 27} tömb esetén a visszatérési érték 15.

## Exercise 7.6: standarddev

Írj egy standardDeviation nevű metódust, mely egy lebegőpontos számokból álló tömb elemeinek a szórását adja vissza, amit 
így kell kiszámolni:  
az egyes elemek és a tömb átlaga közti különbségek négyzeteit kell összeadni, majd a kapott értéket elosztani a tömb
mérete-1 értékkel, és ennek a négyzetgyökét venni.
Feltételezzük, hogy a tömbnek legalább 2 eleme van!

## Exercise 7.7: kthlargest

Írj egy kthLargest(int[] numbers, int k) metódust, mely azt az elemet adja vissza egy egyedi elemeket tartalmazó tömbből, 
amelyiknél k-val több nagyobb szám van.
Pl ha a paraméterek {74, 85, 102, 99, 101, 56, 84} tömb és k=2, akkor a keresett elem a 99 (mert nála van kettővel több
nagyobb szám (101 és 102)
Feltételezzük, hogy 0 <= k < tömb.length

## Exercise 7.8: median

Írj egy median(int[] numbers) metódust, mely egy egész számokból álló tömböt kap paraméterként, és visszaadja a tömb 
mediánját. A medián a sorba rendezett adatok közül
a) páratlan elemszám esetén a középső érték, vagy másképpen: a medián az az érték, amely a sorba rendezett adatokat két 
egyenlő részre osztja.
b) páros elemszám esetén a két középső érték számtani közepe
Pl { 1,3,2,1,3,1,3} esetén 2 (mert sorban{1,1,1,2,3,3,3})
{10,20,30,40} esetén 25 (20 és 30 számtani közepe)

## Exercise 7.9: mingap

Írj egy int minGap(int[] arr) metódust, mely megkeresi és visszaadja a sorozatban két egymás utáni elem közötti legkisebb
különbséget. (Ne rendezd a tömböt!) 
Pl {1,3,6,7,12} esetén 1 a legkisebb különbség(7-6)
A különbség negatív is lehet, pl {3,5,11,4,8} esetén -7(4-11).
Ha a tömb mérete kisebb, mint 2, a visszatérési érték 0 legyen.

## Exercise 7.10: percenteven

Írj egy metódust percentEven(int[]arr) névvel, mely valós számként adja vissza, hogy a tömbben szereplő számok hány százaléka 
páros.
Pl {6,2,9,11,3} -> 40.0
Ha nincs benne páros, vagy üres a tömb, térjen vissza 0.0 értékkel

## Exercise 7.11: isunique

Írj egy isUnique metódust, mely azt mondja meg, hogy az átadott tömb elemei egyediek-e vagy sem.
Pl {3,8,12,1,2,9,17,43,-8} - uniqe
{4,7,2,3,-50,3} - nem unique
Nulla vagy 1 elemű tömb unique lesz.

## Exercise 7.12: priceisright

Írj egy priceIsRight(int[] bids, int price) metódust, mely liciteket fogad egész számokból álló tömbben, és egy egész számot (kikiáltási ár). A metódus válassza ki a a legkedvezőbb ajánlatot, vagyis az árhoz legközelebb eső licitet, de ez a licit alulról közelítse az árat.(Vagyis úgy legyen közelebb hozzá, hogy kisebb nála) Pl {200,300,250,999} licitek és price =280 bemenő paraméterek esetén 250 legyen a visszatérés, ne pedig 300! Ha az összes licit nagyobb, mint a kikiáltási ár, térjen vissza -1-gyel. Feltételezzük, hogy a tömb tartalmaz min egy elemet, és a bemenő paraméterek mindegyike >= 1. A tömb tartalmát ne módosítsd!

## Exercise 7.13: longestsortedsequence

Írj egy longestSortedSequence metódust, mely az átadott tömbben megkeresi azt a leghosszabb részt, ami nem csökkenő, rendezett, és ennek hosszával tér vissza. Pl {3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12} esetén ez 4, mert keresett rész:-3, 0, 14, 207 négy elem hosszúságú {17, 42, 3, 5, 5, 5, 8, 2, 4, 6, 1, 19} esetén 5, mert: 3, 5, 5, 5, 8 a keresett rész, öt elem hosszú

## Exercise 7.14: contains

Írj egy contains(int[] a1, int[] a2) nevű statikus metódust, mely két egész számokból álló tömböt vár. A metódus azt adja vissza, hogy a paraméretként átadott első tömb tartalmazza-e a másodikat teljes egészében (ugyanazok a számok ugyanolyan sorrendben). Pl:a1:{1,6,2,1,4,1,2,1,8} a2:{1,2,1} a3:{2,1,2} esetén contains(a1,a2) -> true, de contains(a1,a3) -> false Tételezzük fel, hogy minkét tömb legalább 1 elemű. Ne használj String-et!

## Exercise 7.15: collapse

Legyen egy collapse nevű metódus, mely az átadott egész számokbó átadott tömbből létrehoz egy újat, oly módon, hogy a paraméterként kapott tömbben levő számokat sorban, kettesével összeadja. Pl: {7,2,8,9,4,13,7,1,9,10} -> {9,17,17,8,19} Páratlan számú tömb esetén az utolsó szám bekerül az újba: Pl: {1,2,3,4,5} -> {3,7,5} A metódus nem változtassa meg az eredeti tömböt!

## Exercise 7.16: append

Az append metódus kap két, egész számokból álló tömböt, és az elsőhöz hozzáfűzi a másodikat. Pl: a1:{2,4,6} és a2: {1,2,3,4,5} append(a1,a2)-> {2,4,6,1,2,3,4,5} append(a2,a1) -> {1,2,3,4,5,2,4,6}

## Exercise 7.17: vowelcount

A statikus vowelCount metódus egy String-et kap paraméterül, és vissztér egy egész számokból álló tömbbel, melynek tagjai a String-ben szereplő magánhangzók megszámlált értékei. Az angol abc alapján dolgozik, és a betűk indexe rendre:{a,e,i,o,u} Pl vowelCount("i think, therefore i am") ezzel térjen vissza: {1, 3, 3, 1, 0}

## Exercise 7.18: evenbeforeodd

Írj egy evenBeforeOdd metódust, mely a kapott egész számokból álló tömböt úgy rendezi át, hogy a párosak legyenek elöl. A a páros számok sorrendje mindegy, csak ők legyenel elöl. Pl: [5, 4, 2, 11, 9, 10, 4, 7, 3] egy lehetséges megoldása: [4, 2, 10, 4, 5, 11, 9, 7, 3] Kerüld az Arrays.sort, vagy bármilyen ideiglenes tömb használatát!

## Exercise 7.19: wordlengths

## Exercrise 7.20: magicSquare

Write a method called isMagicSquare that accepts a two-dimensional array of integers as a parameter and returns true if it is a magic square. A square matrix is a magic square if it is square in shape (same number of rows as columns, and every row the same length), and all of its row, column, and diagonal sums are equal. For example, [[2, 7, 6], [9, 5, 1], [4, 3, 8]] is a magic square because all eight of the sums are exactly 15.



@forrás:https://practiceit.cs.washington.edu/