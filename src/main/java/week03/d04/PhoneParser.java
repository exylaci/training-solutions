package week03.d04;

public class PhoneParser {

    public static final String SPLITTER = "-";

    public Phone parse(String string) {
        String[] split = string.split(SPLITTER);
        if (split.length > 1) {
            return new Phone(split[0], split[1]);
        }
        return null;
    }

    public static void main(String[] args) {
        PhoneParser pp = new PhoneParser();
        Phone p = pp.parse("01-23456789");
        System.out.println(p.getPrefix() + "-" + p.getNumber());
    }
}
//Írj egy Phone oszályt, melynek van egy
// prefix és egy
// number String attribútuma!
//
// Írj egy PhoneParser osztályt egy
// parse(String) metódussal, ami
//  beolvas egy 10-1234567 formátumú szöveget, és
//  visszaad egy Phone objektumot, feltöltve a prefix értékét 10, a number értékét 1234567 értékekkel!