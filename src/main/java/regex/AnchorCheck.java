package regex;

import java.util.regex.Pattern;

public class AnchorCheck {
    public static void main(String[] args) {

        //Elejéhez kötés így működik
        System.out.println(Pattern.compile("^ba").matcher("baka").find());
        //Így nem működik (Hiába teszek vagy nem teszek elé backslasheket.)
        System.out.println("baka".matches("^ba"));
        System.out.println("baka".matches("\\^ba"));

        //Végéhez kötés így működik
        System.out.println(Pattern.compile("ka$").matcher("baka").find());
        //Így nem működik (Hiába teszek vagy nem teszek elé backslasheket.)
        System.out.println("baka".matches("ka\\$"));
        System.out.println("baka".matches("ka$"));

        //Meg tudom kerülni, de miért nem működik a $ és a ^ horgony?!
        System.out.println("baka".matches(".*ka"));
        System.out.println("baka".matches("ba.*"));

    }
}