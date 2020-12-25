package week06.d03;

public class WordEraser {
    public static final String SPLITTER = " ";

    public String eraseWord(String words, String word) {
        checkInput(words);
        checkInput(word);

        StringBuilder result = new StringBuilder(words.length());
        String[] split = words.split(SPLITTER);

        for (String one : split) {
            if (!word.equals(one)) {
                result.append(one).append(SPLITTER);
            }
        }
        return result.toString().trim();
    }

    private void checkInput(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Inputs cannot be empty!");
        }
    }
}
//A WordEraser osztályban
// legyen egy eraseWord(String words, String word) metódus,
// mely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előforulását kitörli belőle.
// A words paraméterben a szavak szóközzel vannak elválasztva.
// A metódus térjen vissza a törölni kívánt szavak nélküli Stringgel.
//
// (Mellőzzük a replace és replaceAll használatát!)