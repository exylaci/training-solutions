package week14.d04;

import java.util.List;

public class ContractCreator {

    public Contract template;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        template = new Contract(client, monthlyPrices);
    }

    public Contract create(String name) {
        return new Contract(name, template.getMonthlyPrices());
    }

    public Contract getTemplate() {
        return template;
    }

    public static void main(String[] args) {
        ContractCreator c = new ContractCreator("név", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        Contract contract = c.create("másnév");
        contract.getMonthlyPrices().set(1, 56);
        System.out.println(contract);
        System.out.println(c.getTemplate().getMonthlyPrices());
    }
}
//Legyen egy szerződés (Contract) osztály, melynek van egy String client és egy List<Integer> monthlyPrices attribútuma.
// Az előbbi a szerződő neve, a második pedig a havonta fizetendő összeg.Legyen egy ContractCreator osztály, melynek van
// egy ContractCreator(String client, List<Integer> monthlyPrices) konstruktora, mely létrehoz egy szerződéssablont, a
// paraméterként megadott adatokkal, melyet összesen EGY attribútumban tárolj!Majd írj egy create(String name) metódust,
// mely a sablon alapján létrehoz egy új szerződést, de a nevet kicseréli a paraméterként megadott névre.Próbáld ki,
// hogy a visszaadott szerződésben módosítod a 12. havi értéket. Ha egy új szerződést a sablon alapján, akkor a 12 havi
// érték az eredeti sablon alapján van kitöltve?