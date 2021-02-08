package week15.d01;

import java.util.List;

public class Bitcoin {
    List<Integer> rates;

    public Dates findBestDates(List<Integer> rates) {
        if (rates == null || rates.size() < 2) throw new IllegalArgumentException("Price list is too short!");

        this.rates = rates;
        Dates result = new Dates();

        int minRate = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int buyOnDay = 0; buyOnDay < this.rates.size() - 1; ++buyOnDay) {
            if (this.rates.get(buyOnDay) < minRate) {
                minRate = this.rates.get(buyOnDay);
                maxProfit = findAndSetFollowingMaxRate(result, buyOnDay, maxProfit);
            }
        }

        return result;
    }

    private int findAndSetFollowingMaxRate(Dates result, int buyOnDay, int max) {
        for (int saleOnDay = buyOnDay + 1; saleOnDay < rates.size(); ++saleOnDay) {
            if (rates.get(saleOnDay) - rates.get(buyOnDay) > max) {
                result.set(buyOnDay, saleOnDay);
                max = rates.get(saleOnDay) - rates.get(buyOnDay);
            }
        }
        return max;
    }
}
//Egy befektető cég szeretné megnézni, hogy az elmúlt időszakban mikor lett volna érdemes venni, illetve eladni Bitcoint.
// Készíts egy metódust, ami paraméterül várja a Bitcoin, valahány napi árfolyamát időrendi sorrendben egy listában,
// dollárban. (Egész számok listája) A metódus visszatérési értéke két szám legyen, az első hogy hányadik napon lett
// volna érdemes venni, a második pedig, hogy melyik napon lett volna érdemes eladni. Mindezt úgy, hogy a legnagyobb
// nyereségünk legyen.