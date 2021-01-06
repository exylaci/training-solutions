package exam02.photo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotoCollection {
    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... newPhotos) {
        for (String one : newPhotos) {
            photos.add(new Photo(one));
        }
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo one : photos) {
            if (one.getName().equals(name)) {
                one.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException("Can't find this photo" + name);
    }

    public int numberOfStars() {
        int result = 0;
        for (Photo one : photos) {
            result += one.getQuality().getStars();
        }
        return result;
    }

    public List<Photo> getPhotos() {
        return Collections.unmodifiableList(photos);
    }
}
//Írj egy Photo osztályt, melynek van egy neve és egy minősítése! Létre lehet hozni csak névvel, vagy névvel és
// minősítéssel. A minősítés egy Quality enum, hogy a felhasználó hány csillagot adott rá, lehet ez Quality.NO_STAR,
// Quality.ONE_STAR és Quality.TWO_STAR. A Photo osztály implementálja a Qualified interfészt, melynek definiált a
// Quality getQuality() és a void setQuality(Quality) metódusa.
//
//Írj egy PhotoCollection osztályt, mely a fotók egy listáját tartalmazza! Fotókat lehet hozzáadni névvel, ekkor még
// nem kapnak csillagot. Az addPhoto() metódus legyen varargs-os!
//
//Írj egy starPhoto() metódust, mely kikeresi a megfelelő nevű fotót, és beállítja rajta a paraméterként átadott
// minősítést! Ha nem talál a megadott névvel fotót, PhotoNotFoundException kivételt dob. Ez egy saját kivétel,
// terjessze ki a RuntimeException osztályt!
//
//Írj egy numberOfStars() metódust, mely visszaadja, hogy a képeken összesen mennyi csillag van! Ha nincs minősítése,
// akkor 0 csillag. Ha a minősítése Quality.ONE_STAR, akkor egy csillaggal kell számolni. Ha a minősítése
// Quality.TWO_STAR, akkor két csillaggal kell számolni.
//
//Tartsd be az elnevezési konvenciókat! A megoldásban csak foreach-eket használj!