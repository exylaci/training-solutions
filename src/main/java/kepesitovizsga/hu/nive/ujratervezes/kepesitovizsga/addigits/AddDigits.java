package kepesitovizsga.hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {
    public int addDigits(String text) {
        if (text == null || text.isBlank()) {
            return -1;
        }

        return text
                .chars()
                .boxed()
                .map(i -> (char) ((int) i))
                .filter(Character::isDigit)
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}