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


## Nagybetűk

Az UpperCaseLetters osztályban a characters.txt fájl felhasználásával írd meg a `getNumberOfUpperCase(String filename)`
metódust, ami visszaadja a fájlban található mindenféle karakterek közül a nagybetűk számát!

(A characters.txt az `src/main/resources` könyvtárban található.)

## Katicák

Ebben a feladatban a Magyarországon előforduló katicafajtákkal ismerkedhetsz meg. Minden katicának az adatbázisban van egy
magyar neve, egy latin neve, egy nemzetsége, amelyhez rendszertanilag tartozik, valamint tudjuk a pöttyeinek a számát. 
A Ladybird osztályban NE tárold el külön adatszerkezetben az adatbázis adatait, hanem metódusonként külön kérdezd le azokat:
- `getLadybirdsWithExactNumberOfPoints(int number)` : paraméterként egy egész számot vár, és visszaadja az ennyi pöttyel
  rendelkező katicák nevét egy String listában.
- `getLadybirdsByNumberOfPoints()` : egy olyan adatszerkezetet ad vissza, amely növekvő sorrendben tartalmazza az egyáltalán
  előforduló pöttyök számát, és azokhoz társítva azt, hogy konkrétan hány katica rendelkezik pontosan ennyi pöttyel.
- `getLadybirdByPartOfLatinNameAndNumberOfPoints(String partOfName, int numberOfPoints)` : egy latinnév-töredék és egy 
  egész szám alapján kikeresi az ezeknek a feltételeknek megfelelő katicákat, és visszaadja őket egy olyan adatszerkezetben,
  amely a katicák minden adatát képes kezelni.
- `getLadybirdStatistics()` : egy adatszerkezetben adja vissza, hogy melyik nemzetséghez hány fajta katica tartozik

(A teszteléshez szükséges SQL utasítások a resources/db/migration/V1__ladybird.sql fájlban találhatóak.)

## A kert fáinak titkos élete

A kertben különböző gyümölcsfák találhatóak: almafa (AppleTree), cseresznyefa (CherryTree) és diófa (WalnutTree). Mivel 
ezek mindegyike fa (Tree), ezért tavasszal mindegyik kirügyezik és lesznek levelei (int leaves, konstruktorban beállítva).
Ezenkívül mindegyikről már kívülről ránézve nyilvánvaló, hogy milyen típusú gyümölcsöt terem (Fruit enum).
A fák mindegyike a napsütéses napok hatására további leveleket növeszt (`int growLeaves(int numberOfSunnyDays)`) és
gyümölcsöt érlel (`void ripenFruit(int numberOfSunnyDays)`). A levelek a következőek szerint növekednek: az almafának
minden egyes napsütéses napon 10, a cseresznyefának 20, a diófának pedig 30 levele nő. A gyümölcsök pedig csak akkor
tudnak megérni, ha a fának előbb elegendő levele nőtt, de ebben az esetben az almafán annyi kg gyümölcs terem, mint a
levelek számának 50-ed része, a cseresznyén ugyanez az arányszám 30, a diófán 10.
Végül pedig a fák más módon is részt vesznek a kert életében: madárfészkeknek adnak otthont. Méghozzá úgy, hogy minden fán
egységesen 200 levél takar el egy madárfészket. Az `int hostBirdNest()` azt adja vissza, hogy egy-egy fán összesen hány
fészek fér el.

## Számjegyek összege

A SumOfDigits osztályban írd meg a `getSumOfDigits()` metódust, amely paraméterként egy Random példányt vár. A metódus
a Random-tól kapott egész számban adja össze a számjegyeket, majd az így kapott szám számjegyeit ismét adja össze. Ezt a lépést
addig ismételje, amíg az összeg egy számjegyű nem lesz, és végül ezt az egy számjegyet adja vissza!
(Pl. ha a véletlenszám 12345, akkor a számjegyek összege először 15, majd 6, ezt adja vissza a metódus.)

## Covid oltási lista (avagy újabb bőrt húzunk le ugyanarról a témáról, kicsit másképpen :) )

Adott egy fájl (`vaccinationlist_2021-03-02_1234.csv`, az src/test/resources könyvtárban található), amely egy adott
településen egy adott napra a koronavírus elleni oltásra, időpontra behívott emberek listáját tartalmazza.
A VaccinationList osztályban olvasd be a fájlt a memóriába! Ez a következő műveleteket jelenti:
- van az osztálynak egy MetaData metadata attribútuma. A MetaData osztály tárolja az oltást szervező település
  irányítószámát, nevét és az oltás napjának dátumát. A fájlt beolvasó metódus ezeket az adatokat beállítja az attribútumban.
- van az osztálynak egy Map<LocalTime, Person> attribútuma, amelyet szintén ez a metódus tölt fel adatokkal. (A Person
  osztály értelemszerűen az oltásra behívott emberek minden fontos adatát tárolja.)
  
Ezután oldd meg az alábbi feladatokat:
1. Add vissza a 100 évnél idősebbek listáját: `getPersonsMoreThanHundredYearsOld()` !
2. Add vissza a délutánra behívottak listáját: `getAfternoonPersons()`!
3. Ellenőrizd le minden ember TAJ-számát, hogy érvényes-e: `validateTaj()`! Ha találsz esetleg érvénytelen TAJ-számot, akár többet,
   dobj kivételt a megfelelő üzenettel!
   (A TAJ-szám ellenőrzés algoritmusa:
   a TAJ-szám 1., 3., 5. és 7. számjegyét szorozd meg 3-mal, a 2., 4., 6. és 8. számjegyét 7-tel, ezeket add össze.
   Az összeget 10-zel elosztva vedd az osztás maradékát, és ha ez a számjegy megegyezik a 9. számjeggyel (cdv-kód),
   akkor ez egy érvényes TAJ-szám.)
4. Hívj be egy megadott időpontra érkező embert! Legyen egy metódus (`inviteExactPerson(LocalTime time)`), amely egy
   konkrét időpontot vár paraméterül, és a következő szöveget adja vissza: "Kedves {nev}! Ön következik. Kérem, fáradjon be!"
   Természetesen ez egy template, neked a nevet be kell helyettesítened a szövegben a megfelelő helyre.
   Azt az esetet is kezeld megfelelően, ha a paraméterként kapott időpont nem létezik a rendszerben!
5. Legyen egy metódus, amely visszaadja az oltást szervező település nevét és irányítószámát: `Town getTown()`!
6. Legyen egy metódus, amely visszaadja, az oltás dátumát: `LocalDate getDateOfVaccination()`!
7. Legyen egy metódus, amely visszaadja egy adatszerkezetben, hogy melyik típusú oltást hányan kapták az itt felsoroltak
   közül: `getVaccinationStatistics()`! Ehhez szükséged lesz egy VaccinationType enumra a megfelelő példányokkal.
   Legyen érték azok számára is, akik még nem kaptak semmilyen oltást!
   
## Álláshirdetésre jelentkezők nyilvántartása

Egy cég adatbázisban tartja nyilván a hozzá jelentkezőket (Applicant) név (külön kereszt- és vezetéknév, ebben a sorrendben),
nem, telefonszám, email, és egy mindenkinek egyénileg kiosztott kód alapján, valamint mindenkinél szerepel a táblázatban
az a skill, amelyet a jelentkező az önéletrajzában a legerősebb oldalaként megjelölt. Ezen adatok alapján a jelentkezőkről
két olyan listát is használnak, amelyek nem tartalmazzák mindenkinek minden adatát, hanem a jobb áttekinthetőség érdekében
csak a lényegeseket.
Hozz létre egy ApplicantListGenerator interfészt, amelynek egyetlen metódusa van (`List<Applicant> getListFromDatabase()`).
Ez a metódus a DataSource-ot várja paraméterül, a feladata pedig az, hogy az adatbázisból lekérdezze a szükséges adatokat és
egy listában visszaadja azokat.
Két különböző módon teszi ezt:
- A ListByApplicantsPersonal osztályban egy olyan listát készít, amelyben az összes jelentkező szerepel, de mindenki
  csak a legfontosabb személyes adataival: keresztnév, vezetéknév, telefonszám és e-mail cím.
- A ListBySkills osztályban pedig egy olyat, amelyben csak azok szerepelnek (keresztnévvel, vezetéknévvel és skill-lel),
  akiknek az egyéni képességük valamilyen három karakteres rövidítéssel leírható (hiszen a cég tudja, hogy ezek a legmenőbb
  képességek a munkaerőpiacon :) ). A szűrést természetesen akár az adatbázis-lekérdezésnél, akár Java-ban is végezheted.
Vigyázz, mert a megfelelő megvalósításokhoz különböző konstruktorokkal és az equals metódussal is lesz teendőd!

(A teszteléshez szükséges fájl: src/main/resources/db/migration/V1__applicants.sql)

## Csipkerózsika betűről-betűre

A sleepingbeauty.txt fájlban találod a Csipkerózsika című mesét. A feladat az, hogy készíts belőle statisztikát:
melyik betűből hány darab található benne. Fontos, hogy csak a betűk számítanak, az egyéb karakterek nem
kellenek, valamint hogy a nagy- és kisbetűk között ne tégy különbséget! (Tehát az "A" és az "a" egy helyre számolandó.)

(A fájl az src/main/resources könyvtárban található.)

## Piroska és a farkas... és az evés

(Ez a feladat kizárólag a benne szereplő dolgok gyakorlására szolgál, és nem azért, mert egyébként bármit is
szokás lenne így csinálni. :) )

Van egy erdő (abstract class Forest), amelyben a Piroska és a farkas című mese szereplői élnek (LittleRedRidingHood,
Wolf, Grandma, Hunter). Közülük mindenkinek van neve (String name attribútum), valamint ők egy, a Forest-ben tárolt listában vannak,
mindegyikőjükből 1 példány.
Az erdőben mindenki eszik valamit (`void eat()`):
- Piroska sétálás közben megdézsmálja a nagymamának vitt süteményt (attribútum: int cake, ebből kezdetben 10 db van, Piroska minden
  egyes alkalommal 1 db-ot eszik meg ezekből).
- A nagymama (a későbbi megmenekülése után) természetesen szintén Piroska süteményeit eszi, a nagyobb ijedtség miatt egyszerre mindig 2 db-ot.
- A farkas megeszi a nagymamát és Piroskát (törlődnek a Forest-ben tárolt listából).
- A vadásznak evés előtt fontos dolgai vannak: az `eat()` meghívásakor előbb meg kell ölnie a farkast (a farkas ekkor törlődik
  az erdei listából), majd ki kell vennie a hasából a nagymamát és Piroskát (ők ekkor újra a listához fognak tartozni, idősebbeké
  az elsőbbség!), és a vadász csak ezután vehet a Piroska által hozott süteményből (a még nagyobb ijedtség okán egyszerre 3 db-ot).
Amire mindenképpen figyelj: fontos, hogy hogyan hozod létre a Forest osztályban tárolt listát, mivel később törölni kell majd belőle. 
A másik, hogy ebben a feladatban most többször kell majd a static módosítószót és az equals() metódust is használnod.
  
## Hamupipőke szavai

Egy Object tömbben add vissza, hogy a Hamupipőke meséből a következő szavak közül melyik szerepel a legtöbbször,
és hogy pontosan hányszor is fordul elő: Hamupipőke, galamb, királyfi, mostoha, cipő (a sorrend fontos!)
A megvalósítás lépései a következők: 
- a Cinderella osztálynak legyen egy int[] attribútuma, melynek elemeiben számolhatod ezeknek a szavaknak az előfordulásait.
- olvasd be a mesét fájlból (src/main/resources/cinderella/cinderella.txt), és közben számolj az int tömbben! Figyelj arra,
  hogy ne pontos egyezést vizsgálj, hanem tartalmazást! (Tehát pl. a "királyfi" szó előfordulásaiba számítson bele
  a "királyfi", "Királyfi", "királyfié", "királyfival", stb., de pl. a Hamupipőke előfordulásaiba ne számítson bele
  a "Hamupipőkével", mert az nem pontosan az eredeti szót tartalmazza.)
- végül legyen egy metódus, amely visszaadja a korábban már említett Object tömböt!

(A feladatba azért írtam tömböket, mert a szerdai konzultáción arról volt szó, hogy lesz a vizsgán. :) )

## Hófehérke hét törpéje

Hozz létre egy Dwarf osztályt, attribútumai: String name és int age.
Majd hozz létre egy SnowWhite osztályt, amely tárol és kezel egy listát a hét törpéről! Ebben az osztályban
három metódust valósíts meg:
- `getSevenDwarfs()` : visszaadja az osztály által tárolt listát.
- `getSevenDwarfsOrderedByNames()` : visszaadja az osztály által tárolt listát úgy, hogy abban a törpék név szerinti sorrendben szerepelnek.
- `getSevenDwarfsOrderedByAges()` : visszaadja az osztály által tárolt listát úgy, hogy abban a törpék életkor szerinti sorrendben szerepelnek.

## Keresd a Békakirályfit!

Először írj egy PlayerOfTale osztályt, amely egy meseszereplőt fog reprezentálni. Attribútumai: String name, int age
és Tale tale (ez utóbbi egy enum, a következő példányokkal: CINDERELLA, FROGPRINCE, LITTLEREDRIDINGHOOD, SLEEPINGBEAUTY, SNOWWHITE)!
Ezután a FrogPrince osztályba írj egy `getPlayersOfTale(DataSource dataSource, Tale tale)` metódust, amely egy adatszerkezetben
visszaadja a paraméterként kapott mese összes szereplőjét. Ezeket természetesen a megadott DataSource segítségével olvassa
ki az adatbázisból.

(A teszteléshez szükséges fájl: src/main/resources/db/migration/V1__tales.sql)

## Matekfeladat

A Digits osztályba írj egy metódust, amely a következő matematikai feladat megoldását adja vissza:
Hány olyan kétjegyű pozitív egész szám van, amelyben az egyik számjegy 5-tel nagyobb a másiknál?

## Állatkert

Egy állatkertben a náluk gondozott állatokról (ZooAnimal) adatbázist vezetnek. Minden állatnak van neve, valamint
nyilvántartanak egy hosszúság adatot, amely csak néhány állatnál fontos (azoknál, amelyeknek valamely testrészük hosszú :) )
és egy súlyadatot, amely csak az igazán nehéz állatoknál érdekes:
- az oroszlánok (Lion) az állatkertbe kerülésükkor csak egy nevet kapnak, a többi tulajdonságuk elhanyagolható.
- a zsiráfok (Giraffe) esetében viszont már nyilvántartják a nyakuk hosszúságát is (a súlyuk nekik is elhanyagolható).
- az elefántoknál (Elephant) pedig a hosszúság értelemszerűen az ormány hosszát jelenti, illetve az előzőeken túl már fontos a súlyuk is.

A Zoo osztály reprezentálja az állatkertet. Ebben egy adatszerkezetben tárolják az állatokat, lekérdezhető formában. Az osztály
konstruktorban kapja meg az adatbázis eléréséhez szükséges adatokat. A következő metódusokat kell megvalósítani:
- `getAnimals()` : ezen a metóduson keresztül érhetjük el az adatszerkezetet.
- `loadAnimals()` : betölti az adatbázisból az állatok adatait az osztályba.
- `addAnimal(ZooAnimal animal)` : ezzel a metódussal lehet egy új állatot feltölteni az adatbázisba.
- `getHeaviestAnimalInTheZoo()` : visszaadja az állatkert legnehezebb állatát.
- `countWeights()` : összeszámolja, hogy mennyit nyomnak az állatkert állatai együttesen.
- `findExactAnimal(ZooAnimal animal)` : megkeresi a paraméterként megadott állatot (amennyiben az létezik).
- `findExactAnimalByName(String name)` : megkeresi a paraméterként megadott névvel rendelkező állatot (amennyiben az létezik).
- `getNumberOfAnimals()` : visszaadja, hogy hány állat található jelenleg az állatkertben.
- `getAnimalsOrderedByName()` : visszaad egy másik adatszerkezetet, amelyben ABC-sorrendben található az állatok neve.
- `getAnimalStatistics()` : visszaad egy másik adatszerkezetet, amelyből kiolvasható, hogy milyen fajta állatból mennyi van az állatkertben.

## Szép hosszú szavak

Adott egy szó, amely a következőhöz hasonló formában van megadva:
```
EXAM
XAMP
AMPL
MPLE
```
A feladat az, hogy a FineLongWord osztályban egy tömbben add vissza a szó betűit a megfelelő sorrendben, tehát így:
```
[E, X, A, M, P, L, E]
```
Mivel a Java nyelv beépített osztálykönyvtára erre rendkívül tág lehetőségeket biztosít, ezért kapásból három
különböző, számodra már régóta ismerős szép hosszú szóval is tesztelheted a metódusodat. :)


## Szép hosszú szavak - még egyszer ugyanaz, de megfordítva

A FineLongWordOnceAgain osztályban írj egy metódust, amely egy tömböt add vissza. Ez a tömb a következőhöz hasonló formában
kell, hogy tartalmazzon egy szép hosszú szót:
```
EXAM
XAMP
AMPL
MPLE
```
A metódus neve legyen `getFineLongWordOnceAgainButNowInAReverseWay()` (ha már "szép hosszú szó" :) ), és paraméterként 
várja magát a szót, valamint azt, hogy hány betű szélességben adja vissza a szót (a sorok száma ugye innentől kezdve adott lesz). 
Ellenőrizz rá arra is, hogy ez alapján a szám alapján a feladat megoldható-e!

## Törtek egyszerűsítése

A FractionReduction osztályba írj egy metódust, amely a következő feladat megoldását adja vissza:
Hány olyan 1-nél kisebb pozitív törtszám van, amelynek nevezője 144 és nem egyszerűsíthető?
(Ha esetleg valaki nem emlékszik a matekórákról: a tört egyszerűsítése azt jelenti, hogy a számlálóját
és a nevezőjét ugyanazzal a számmal osztjuk el egyszerre.)

## Szülői értekezlet

A múltkori állatkert azóta egy kicsit kibővült, és most már sokkal többféle állatnak ad otthont. Ezért elindították az
örökbefogadási programjukat, amelynek keretében bárki egy jelképes összegért egy általa szabadon választott állat jelképes 
örökbefogadó szülőjévé válhat. Van is már néhány lelkes jelentkező, akiket egy adatbázisban tárolnak (név, e-mail cím,
örökbefogadott állat és örökbefogadás dátuma adatokkal). Az állatkert a kapott támogatásért cserébe évi egyszer egy szülői 
értekezletet tart az örökbefogadóknak, amikor azok arra a napra ingyen belépőt kapnak és még egy beszámolót is meghallgathatnak
kedvencük viselt dolgairól. (Nem vicc, ilyet tényleg csinálnak, pl. a budapesti Állatkertben. :) ) Erre az alkalomra külön
meghívót is kiküldenek minden érintettnek. Az esemény stílusosan az Állatok Világnapján, 2021. október 4-én lesz, délután 5-kor.

A te feladatod az összes ilyen meghívólevél szövegének a legenerálása a megadott template fájl alapján 
(`src/main/resources/conferenceforadoptiveparents.txt`). A metódus neve: `getTextsOfLetters(String filename)`. Fontos,
hogy ez úgy valósuljon meg, hogy ha később bekerülnek még újabb támogatók az adatbázisba, akkor a kódon ne kelljen
semmit módosítani.

Ezenkívül (csak úgy, gyakorlásként) implementáld a következő metódusokat is:
- `getFirstAdoption()` : visszaadja az első örökbefogadást (állat, dátum).
- `getAnimalNamesReverseOrdered()` : visszaadja egy adatszerkezetben az összes, eddig örökbefogadott állat nevét, fordított
   ABC-sorrendben.
- `getExactPerson(String email)` : megkeres egy konkrét örökbefogadó szülőt az e-mail címe alapján.

## Képesítővizsga

Képzeljük el, hogy van egy vizsga (Exam), ami egyelőre tényleg csak a képzeletünkben létezik, de játsszunk el a gondolattal, hogy
ez a vizsga valamikor, valami távoli galaxisban kétféle formában is megvalósulhat: írásbeli- (TheoryTestExam) és projektvizsga (PracticalTestExam).
Minden ilyen vizsgának lesz neve, kezdési ideje, időtartama, valamint mindegyiken egy órával előbb kell megjelenni a 
személyazonosítás céljából.
A következő metódusokat valósítsd meg:
`getBeginTimeOfExam()` : azt az időt adja vissza, amikor legelőször jelen kell lenni (az azonosítás kezdetét).
`getEndTimeOfExam()` : a vizsga befejezési idejét adja vissza.
`getExamsInChronologicalOrder(List<Exam> exams)` : megkapja a megrendezendő vizsgák listáját és kezdési időpont szerinti
sorrendbe rendezve adja vissza.
`Map<String, LocalDateTime> getExamsBySpecialPredicate(List<Exam> exams)` : ennek a metódusnak kétféle megvalósulása is legyen:
a TheoryTestExam osztályban adjon vissza egy kollekciót a fejlesztőknek szóló vizsgákból, a PracticalTestExam osztályban pedig
egy kollekciót a délután megtartandó vizsgákból. (Igen, tudatában vagyok, hogy ennek a szétválasztásnak nincs semmi
értelme, de ettől még remekül lehet vele gyakorolni pár dolgot. :) )

Mindenkinek eredményes felkészülést kívánok!