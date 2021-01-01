package collectionsmap;

import java.time.LocalDate;
import java.util.*;

public class LogParser {

    public static final String LOG_SEPARATOR = ":";
    public static final String DATE_SEPARATOR = "-";
    public static final int POSITION_OF_IPADDRESS = 0;
    public static final int POSITION_OF_DATE = 1;
    public static final int POSITION_OF_LOGIN = 2;
    public static final int POSITION_OF_YEAR = 0;
    public static final int POSITION_OF_MONTH = 1;
    public static final int POSITION_OF_DAY = 2;

    public Map<String, List<Entry>> parseLog(String log) {
        if (log == null || log.isBlank()) throw new IllegalArgumentException("Log is a must!");

        Map<String, List<Entry>> result = new HashMap<>();
        Scanner scanner = new Scanner(log);

        while (scanner.hasNext()) {
            String one = scanner.nextLine();
            Entry oneEntry = parseOneLine(one);
            if (result.containsKey(oneEntry.getIpAddress())) {
                List<Entry> temp = new ArrayList<>(result.get(oneEntry.getIpAddress()));
                temp.add(oneEntry);
                result.replace(oneEntry.getIpAddress(), temp);
            } else {
                result.put(oneEntry.getIpAddress(), List.of(oneEntry));
            }
        }

        return result;
    }

    private Entry parseOneLine(String oneLine) {
        String[] split = oneLine.split(LOG_SEPARATOR);
        if (split.length == 3) {
            return new Entry(split[POSITION_OF_IPADDRESS],
                    parseDate(split[POSITION_OF_DATE]),
                    split[POSITION_OF_LOGIN]);
        }
        throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
    }

    private LocalDate parseDate(String date) {
        String[] split = date.split(DATE_SEPARATOR);
        if (split.length == 3) {
            return LocalDate.of(parseInt(split[POSITION_OF_YEAR]),
                    parseInt(split[POSITION_OF_MONTH]),
                    parseInt(split[POSITION_OF_DAY]));
        }
        throw new IllegalArgumentException("Incorrect log: incorrect date");
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }
}
//Gyűjtsd ki az ugyanahhoz az IP-címhez tartozó napló bejegyzéseket egy szöveges naplóból.
//A napló sorokban tárolja az adatokat, egy sor egy Entry objektumnak felel meg, IP cím, dátum és login mezőkből áll.
//Írj egy log feldolgozást implementáló osztályt, LogParser néven, amely elvégzi a dátum String konvertálását,
//a sor feldolgozását, és Map-be szortírozását.
//A fő tevékenységet a (parseLog(String log)) metódus végzi, amely egy (Map<String, List<Entry>>) értéket ad vissza.
//
//Hibakezelés
//Ha a dátum String nem dolgozható fel, a metódus dobjon egy IllegalArgumentException kivételt.
//Ha a parseLog(String log) metódus bemenete olyan String, amely nem dolgozható fel, mint Entry objektum,
// szintén IllegalArgumentException kivételt dobjon.
//
//Megvalósítás
// A sorfeldolgozáshoz szükséges adatok - elemek száma, pozíciója, mező szeparátor, dátum String formátuma -
// statikus final változóként kerüljenek be a LogParser osztályba.
//
//Tippek
// Ha a sor nem dolgozható fel, vagy a dátum nem konvertálható, az egész feldolgozást töröljük
//  és kivételt dobunk a probléma megjelölésével.