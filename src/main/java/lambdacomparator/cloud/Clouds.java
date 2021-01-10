package lambdacomparator.cloud;

import java.awt.event.ItemEvent;
import java.text.Collator;
import java.util.*;

public class Clouds {

    private List<CloudStorage> cloudStorages;

    public Clouds() {
        cloudStorages = new ArrayList<>();
    }

    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudStorages) {
        if (cloudStorages == null || cloudStorages.isEmpty()) throw new IllegalArgumentException("List is a must!");

        List<CloudStorage> temp = new ArrayList<>(cloudStorages);
        Collections.sort(temp, Comparator.comparing(
                CloudStorage::getProvider, Collator.getInstance(new Locale("hu", "HU"))));
        return temp.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudStorages) {
        if (cloudStorages == null || cloudStorages.isEmpty()) throw new IllegalArgumentException("List is a must!");

        return Collections.min(cloudStorages,
                Comparator.comparing((CloudStorage::getPeriod), Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength)))
                        .thenComparingDouble(CloudStorage::getPrice));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> cloudStorages) {
        if (cloudStorages == null || cloudStorages.isEmpty()) throw new IllegalArgumentException("List is a must!");

        List<CloudStorage> temp = new ArrayList<>(cloudStorages);
        Collections.sort(temp, Comparator.reverseOrder());

        List<CloudStorage> result = new ArrayList<>();
        for (int i = 0; i < Math.min(temp.size(), 3); ++i) {
            result.add(temp.get(i));
        }
        return result;
    }
}
//Különböző felhő tárhely szolgáltatókat szeretnénk összehasonlítani, ezért a CloudStorage osztályban eltároljuk a
// különböző adataikat. A tárhely mérete GB-ban adott, az árak pedig mindenhol ugyanabban a pénznemben. A PayPeriod enum
// a fizetési gyakoriság, ahol a length értéke a hossz hónapokban megadva (lifetime esetén 60 hónap). Az ingyenes
// csomagok esetén a fizetési gyakortiság nincs megadva. A CloudStorage implementálja a Comparable interfészt, a
// természetes rendezettségét az 1000 GB-ra eső éves díj nagysága adja.
//
//A Clouds osztály metódusai a paraméterként kapott listából bizonyos szempont szerint a legjobba(ka)t adják vissza.
// Amennyiben több ugyanolyan van, akkor közülük bármelyik visszaadható.
//
//    alphabeticallyFirst(): a szolgáltató neve alapján betűrendben a legelső CloudStorage. Kis-nagybetű nem számít.
//    bestPriceForShortestPeriod(): a legrövidebb időszakra vonatkozó legolcsóbb CloudStorage. Ha van ingyenes, akkor
//    azok közül bármelyik megadható.
//    worstOffers(): a természetes rendezettség szerinti 3 legrosszabb ajánlat.