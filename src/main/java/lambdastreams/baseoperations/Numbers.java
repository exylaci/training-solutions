package lambdastreams.baseoperations;

import java.util.*;

public class Numbers {
    private List<Integer> list;

    public Numbers(List<Integer> list) {
        this.list = list;
    }

    public Optional<Integer> min() {
        return list.stream().min((one, two) -> one.compareTo(two));
    }

    public Integer sum() {
        return list.stream().reduce(0, Integer::sum, (one, two) -> one + two);
    }

    public Collection<Object> getDistinctElements() {
//        return list.stream().collect(Collectors.toCollection(HashSet::new));
        return list.stream().collect(HashSet::new, Set::add, Set::addAll);
    }

    public boolean isAllPositive() {
        return list.stream().allMatch(a->a>0);
    }
}
//Készíts egy Numbers osztályt, amely egész számokból álló listát tárol. A listát a konstruktoron át kapja meg.
//Készíts metódusokat az alábbi számítások elvégzésére:
//
//    min(): a legkisebb szám,
//    sum(): az elemek összege,
//    isAllPositive(): megvizsgálja, hogy minden elem pozitív-e,
//    getDistinctElements(): az összes különböző elemet pontosan egyszer tartalmazó kollekció.
//
//Az összes metódus kizárólag stream műveleteket használjon.