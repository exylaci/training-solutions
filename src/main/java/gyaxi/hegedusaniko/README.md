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



@forrás:https://practiceit.cs.washington.edu/