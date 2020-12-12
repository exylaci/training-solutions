package temperatures;

public class Temperatures {
    private byte[] data = new byte[0];

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double sum = 0;
        for (int i = 0; i < data.length; ++i) {
            sum += data[i];
        }
        return sum / data.length;
    }

    public double getMonthAverage() {
        double sum = 0;
        for (int i = Math.max(data.length - 30, 0); i < data.length; ++i) {
            sum += data[i];
        }
        return sum / (data.length - Math.max(data.length - 30, 0));
    }
}
//Az előző 365 nap hőmérsékleti adatait fájlban tároljuk.
// A Temperatures osztály attribútumában ezek találhatók egy byte[]-ben.
// Az osztály konstruktorban kapja meg a hőmérsékleti adatokat.
// A getYearAverage() metódusa a teljes év átlaghőmérsékletét adja vissza, a
// getMonthAverage() az utolsó 30 napét.
//
// Készíts egy TemperatureReader osztályt, mely egyetlen
// readTemperatures() metódusa bináris fájlból beolvassa az eltárolt hőmérsékleteket,
// és egy Temperatures példánnyal tér vissza!
//
// Ugyanennek mintájára készíts egy TemperaturesWriter osztályt, amelynek a
// writeTemperatures() metódusa a paraméterként kapott
// Temperatures példányból bináris fájlba írja a hőmérsékleti adatokat!