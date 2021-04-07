# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz. A `pom.xml` tartalmát nyugodtan át lehet másolni. 
Projekt, könyvtár, repository neve legyen: `kepesitovizsga-gyakorlas`. 
GroupId: `training`, artifactId: `kepesitovizsga-gyakorlas`. Csomagnév: `hu.nive.ujratervezes.kepesitovizsga`.

A feladatok megoldásához ajánlom figyelmedbe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

A három (de ötnek számító) feladatra 3 órád van összesen!

Oldd meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő az első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Számjegyek

A NumberOfDigits osztályba írj egy `getNumberOfDigits()` metódust, amely egy egész számot vár paraméterül!
A metódus adja vissza azt, hogy ha 1-től kezdve a paraméterként átadott számig leírjuk az összes egész számot,
akkor hány számjegyet írtunk le!

## Oltási sorrend

A koronavírus vakcinák elosztási rendszerét kell modellezni ebben a feladatban attól függően, hogy éppen milyen
típusú vakcina érkezik az országba (mivel ugye egyes típusoknál vannak bizonyos prioritások, egyeseknél pedig
bizonyos kizáró tényezők.)
Írj először egy Person osztályt, melynek attribútumai a következők: String name, int age, ChronicDisease chronic és
Pregnancy pregnant! Ez utóbbi kettő két enum, mindkettőnél két lehetőség közül lehet választani: igen vagy nem.
Kell ezután egy Vaccine nevű osztály, amely kezel egy, az oltásra regisztrált emberekből álló listát.
A listát adatbázisból töltsd be a konstruktorban paraméterként kapott DataSource alapján.
Az osztályban található a `List<Person> getVaccinationList()` metódus, amelynek a későbbiekben háromféle különböző eredményt
kell visszaadnia
A következőkben hozz létre még 3 osztályt, amelyeknek az egyszerűség kedvéért 3 különböző vakcinatípus neveit add:
Pfizer, AstraZeneca és SinoPharm. Mindhárom osztály a Vaccine osztály leszármazottja és a regisztráltak listája alapján
prioritási sorrendet állít fel az emberek között, és így készíti el az adott vakcinatípussal oltandók listáját.
A következők a feltételek:
- Az alapértelmezett sorrend a regisztráció sorrendje mindhárom esetben.
- Pfizer vakcinával elsősorban és soron kívül a várandósok oltandóak, közvetlenül utánuk kell besorolni az időseket
(65 év felettiek) és csak utánuk jöhet mindenki más.
- AstraZeneca vakcinával a várandósok eleve nem olthatóak, úgyhogy őket ki kell venni a regisztráltak listájából.
Cserébe előre kell venni a krónikus betegeket, utánuk közvetlenül pedig az időseket. A végén jöhet mindenki más.
- SinoPharm vakcinával a várandósok és a krónikus betegek nem olthatóak, sőt, még az idősek is módjával. Itt előre kell
venni a fiatalokat és utánuk következhetnek az idősek. 
  
A feladat szabadon bővíthető.

## Kutyák

Ez a feladat a március 16-i vizsga adatbázis tábláját felhasználva készült.

Készíts egy DogManager osztályt, amelyben a dogs.csv fájl felhasználásával megvalósítod a következő metódusokat:

- Készíts egy `getCountryByExactDogSpecies(String name)` metódust, amely paraméterül várja egy konkrét kutyafajta nevét, és visszaadja a konkrét országot,
  ahol az a fajta őshonos! Figyelj arra, hogy a metódus kezelje azt is, ha a beérkező paraméter kis-nagybetűk szempontjából
  máshogyan van leírva, mint ahogyan a kutyafajták nevei nálad szerepelnek! Fontos azt is kezelni, ha a beérkező
  paraméter üres.
- Készíts egy `getDogsInAlphabeticalOrderByName()`metódust, amely egy Dog listában adja vissza az összes kutyafajtát, a neveik alapján abc-sorrendben!
- Írj egy `getDogStatistics()` metódust, amely visszaadja egy újabb adatszerkezetben, hogy országonként hány kutyafajta van felsorolva az eredetiben!

(A dogs.csv az `src/main/resources` könyvtárban található.)

## Húsvéti nyulak és tojások

Az eggs.csv fájlban megtalálható, hogy melyik húsvéti nyuszi hány hímes tojást hordott szét a világban.
A fájl felhasználásával írj egy `getRabbitWithMaxEggs()` metódust az Eggs osztályba, amely visszaadja a legtöbbet
dolgozó nyuszi nevét és a tojások számát!

## Építésziroda

Az ArchitectStudio osztály tárol és kezel egy adatszerkezetet, amelyben az egyszerű elérhetőség kedvéért az irodában,
egymás közötti beszélgetésben használatos "munkacímükkel" kereshetőek vissza a régebbi épülettervek.
A tervekről a következőket kell tudni:
- A Plan egy interfész, három metódust tartalmaz: `String getProjectName()`, `int calculateSquareMeter()` és `PlanType getType()`.
- Az építésziroda háromféle típusú épületre specializálódott, amelyek mind implementálják ezt az interfészt: lakóépületekre
  (ResidentialBuildingPlan), középületekre (PublicBuildingPlan) és ipari épületekre (IndustrialBuildingPlan). Ezeknek mindnek
  van egy PlanType enum attribútuma: RESIDENTIAL, PUBLIC, INDUSTRIAL. Minden tervnek van egy String projectName attribútuma is,
  amely nem egyenlő a korábban említett "munkacímmel", ez az adott építészeti projekt hivatalos neve.
- A ResidentialBuildingPlan további attribútumai a következők: House house, int stock, és int area. A House egy enum,
  amelynek három példánya a lakóházak különböző típusai szerint: FAMILY_HOUSE, APARTMENT_BUILDING, BLOCK_OF_FLATS. A stock az
  adott épület szintjeinek száma, az area pedig egy szintjének alapterülete. A `calculateSquareMeter` metódus az épület
  teljes alapterületét adja vissza: alapterület szorozva a szintek számával.
- A PublicBuildingPlan további attribútumai a következők: int stock és int area, ugyanazok érvényesek rájuk, mint a lakóépületeknél,
  a `calculateSquareMeter` metódus is ugyanúgy kell, hogy számoljon.
- Az IndustrialBuildingPlan további attribútumai a következők: int areaOfOfficeBlock, int stock, int areaOfManufacturingHall. Egy
  ipari épület felépítése a következőképpen néz ki: van egy irodaépület, amely lehet többszintes is, és van egy üzemcsarnok,
  amely mindenképpen egyszintes. A `calculateSquareMeter` metódus ennek megfelelően az irodaépület alapterületét beszorozza
  a szintek számával és ehhez adja hozzá az üzemcsarnok alapterületét.

Az építésziroda a következő metódusokat valósítja meg:
- `addPlan(String workingTitle, Plan plan)` : az iroda által kezelt adatszerkezethez egy új tervet ad úgy, hogy külön megkapja
  paraméterként a "munkacímet" és magát a tervet.
- `getPlanWithMaxSquareMeter()` : visszaadja a legnagyobb össz-alapterületű épület tervét.
- `getPlanByWorkingTitle(String workingTitle)` : munkacím alapján kikeres egy tervet.
- `getPlanByProjectName(String projectName)` : projektnév alapján keres ki egy tervet.
- `getSmallerPlans(int squareMeter)` : visszaadja a megadott paraméternél kisebb össz-alapterületű épületek terveinek listáját.
- `getListOfPlansByPlanType(PlanType type)` : visszaadja a paraméterként megadott típusú épületterveket.

Kezeld a kivételeket mindenhol, ahol csak szükséges!

## Szótár

Ezzel a feladattal egy szótár alkalmazás működését szimulálhatod.
Hozz létre egy adatbázist, amelyben egyetlen tábla lesz: ez a szótárban található szavak magyar és angol megfelelőjét tartalmazza.
A szótár működése nagyon egyszerű: kell két metódus, `getEnglishWord(String hungarianWord)` és `getHungarianWord(String englishWord)` .
Az egyik egy magyar szót vár és annak angol megfelelőjét adja vissza, a másik egy angol szót vár és annak a magyar megfelelőjét adja vissza.

(A teszteléshez szükséges SQL utasítások a resources/db/migration/V1__dictionary.sql fájlban találhatóak.)
