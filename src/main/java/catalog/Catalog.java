package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int limit) {
        if (limit < 1) throw new IllegalArgumentException("Page number must be positive");
        int pageNumber;
        int pageNumbers = 0;
        int pieces = 0;

        for (CatalogItem one : catalogItems) {
            pageNumber = one.numberOfPagesAtOneItem();
            if (pageNumber > limit) {
                pageNumbers += pageNumber;
                ++pieces;
            }
        }
        if (pieces == 0) throw new IllegalArgumentException("No page");
        return pageNumbers / pieces;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < catalogItems.size(); ++i) {
            if (catalogItems.get(i).getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(i);
                return;
            }
        }
    }

    public int getAllPageNumber() {
        int result = 0;

        for (CatalogItem one : catalogItems) {
            result += one.numberOfPagesAtOneItem();
        }
        return result;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem one : catalogItems) {
            if (one.hasAudioFeature()) {
                result.add(one);
            }
        }
        return result;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem one : catalogItems) {
            if (one.hasPrintedFeature()) {
                result.add(one);
            }
        }
        return result;
    }

    public int getFullLength() {
        int result = 0;
        for (CatalogItem one : catalogItems) {
            if (one.hasAudioFeature()) {
                result += one.fullLengthAtOneItem();
            }
        }
        return result;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem one : catalogItems) {
            if (isItContains(searchCriteria.getContributor(), one.getContributors()) ||
                    isItContains(searchCriteria.getTitle(), one.getTitles())) {

                result.add(one);
            }
        }
        return result;
    }

    private boolean isItContains(String value, List<String> list) {
        for (String one : list) {
            if (value.equals(one)) {
                return true;
            }
        }
        return false;
    }
}
//A feladat egy online könyvtár katalógus rendszerének a szimulációja.
//
// A könyvtárban vannak könyvek, zenei albumok és hangoskönyvek.
// A könyvek attribútumai között szerepel a címe, szerzője és az oldalak száma.
// Az albumok attribútumai között szerepel a címe, előadója, szerzője és hossza.
// A hangoskönyv mindkét attribútum halmazzal rendelkezik (ugyanis tároja a hozzá tartozó könyv adatait is).
//
//A feladat reprezentációjához a következő elemeket kell megvalósítani:
//
//  Feature interface:
//    Ez az interfész jelzi, ha valaminek van címe, és vannak közreműködők. Két metódussal rendelkező interface.
//    A getContributors() visszaadja a katalógus elem közreműködőit (szerzők és előadók is),
//    valamint egy getTitle() metódus ami az elem címét adja vissza.
//
//  AudioFeatures osztály:
//    Ez az osztály jellemez egy katalóguselemet, ha az audio tulajdonságokkal rendelkezik.
//    Ilyen a zenei album és hangoskönyv. Minden audio elemnek van címe, hossza, előadói, illetve szerzői.
//    Implementálja a Feature interface-t. A szerzők megadása nem kötelező (két konstruktor szükséges, overload).
//    A getContributors() metódus a szerzők és előadók közös listájával tér vissza.
//
//  PrintedFeatures osztály:
//    Ez az osztály jellemez egy katalóguselemet, ha az nyomtatott tulajdonságokkal rendelkezik.
//    A nyomtatott jellemzők a cím, az oldalszám, illetve a szerzők. Szintén a Feature-t implementálja.
//    A getContributors() itt a szerzőket adja vissza listaként.
//
//  CatalogItem osztály:
//    Minden katalógus elemnek van egy jellemzők listája melyek lehetnek akár nyomtatottak vagy audio-k.
//    Továbbá minden katalógus elemnek van ára és egy regisztrációs száma.
//
//  Catalog osztály:
//    A katalógus tartalmazza a katalógus elemek listáját és ebben az osztályban lehet különböző lekérdezéseket végrehajtani.
//    Le lehet kérdezni:
//        Az audio illetve nyomtatott jellemzőkkel rendelkező elemeket (getAudioLibraryItems(), getPrintedLibraryItems())
//        Az összoldalszámot a nyomtatottaknál (getAllPageNumber())
//        Az összhosszt az audio típusúaknál (getFullLength())
//        Az átlag oldalszámot egy bizonyos oldalszám felett (averagePageNumberOver())
//        Keresni lehet egy SearchCriteria alapján (lásd lejjebb) (findByCriteria())
//
//  SearchCriteria osztály:
//    Egy immutable osztály melynek attribútumai egy cím és egy szerző.
//    Az osztályt úgy kell megvalósítani, hogy akár cím, akár szerző alapján,
//    sőt mindkettő alapján lehessen keresni a katalógusban (statikus metódusokkal lehet létrehozni).
//
//  Validators osztály:
//    Létre kell hozni egy isBlank() és isEmpty() statikus metódust,
//    az egyik egy Stringről vizsgálja meg, null vagy üres-e,
//    a másik egy listáról dönti el, hogy null vagy üres-e.
//    Ezeket a metódusokat használhatjuk a metódusok paramétereinek ellenőrzésekor.