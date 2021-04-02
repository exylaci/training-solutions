package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.stream.Collectors;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null) {
            return 0;
        }

        return s.chars()
                .filter(Character::isDigit)
                .boxed()
                .collect(Collectors.toSet())
                .size();
    }
}
