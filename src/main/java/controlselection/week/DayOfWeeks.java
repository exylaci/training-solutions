package controlselection.week;

public class DayOfWeeks {

    public String whichDay(String day){
        switch (day.toLowerCase()){
            case "hétfő":return "hét eleje";
            case "kedd":
            case "szerda":
            case "csütörtök": return "hét közepe";
            case "péntek": return "majdnem hétvége";
            case "szombat":
            case "vasárnap": return "hét vége";
        }
        throw new IllegalArgumentException("Invalid day: " + day);
    }
}
//Írj egy metódust, mely várja a hét neveit, és
// hétfő esetén azt adja vissza, hogy "hét eleje" van,
// kedd, szerda és csütörtök esetén, hogy "hét közepe" van,
// pénteken "majdnem hétvége", és
// szombat és vasárnap esetén "hét vége"!
//
//Figyelj arra, hogy ne számítson a kis- és nagybetű különbség!
//
//Ha nem ismert a nap, dobj kivételt a következő módon:
//throw new IllegalArgumentException("Invalid day: " + day);