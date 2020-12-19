package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {
    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features = Arrays.asList(features);
    }

    public List<Feature> getFeatures() {
        return List.copyOf(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    //megírandók
    public int numberOfPagesAtOneItem() {
        int result = 0;
        for (Feature one : features) {
            if (one instanceof PrintedFeatures) {
                result += ((PrintedFeatures) one).getNumberOfPages();
            }
        }
        return result;
    }

    public int fullLengthAtOneItem() {
        int result = 0;
        for (Feature one : features) {
            if (one instanceof AudioFeatures) {
                result += ((AudioFeatures) one).getLength();
            }
        }
        return result;
    }

    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        for (Feature one : features) {
            result.addAll(one.getContributors());
        }
        return result;
    }

    public List<String> getTitles() {
        List<String> result = new ArrayList<>();
        for (Feature one : features) {
            result.add(one.getTitle());
        }
        return result;
    }

    public boolean hasAudioFeature() {
        for (Feature one : features) {
            if (one instanceof AudioFeatures) return true;
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature one : features) {
            if (one instanceof PrintedFeatures) return true;
        }
        return false;
    }
}
