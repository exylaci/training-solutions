package exam04retake.hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String text) {
        if (text == null) return false;

        int numberOfDigits = (int) text
                .chars()
                .filter(Character::isDigit)
                .count();

        return numberOfDigits * 2 > text.length();
    }
}
