package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        message += 444;
        System.out.println(message);
        boolean b = message.equals("Hello John Doe");
        boolean c = message.equals("Hello John Doe444");
        System.out.println(b);
        System.out.println(c);

        String uresString = "";
        String ketUresString = uresString + uresString;
        System.out.println(ketUresString);
        System.out.println(ketUresString.length());

        String abcde="Abcde";
        System.out.println(abcde.length());
        System.out.println(abcde.charAt(0)+", "+abcde.charAt(2));   // Ha az "első karaktere alatt a 0. pozícióban lévőt értjük.
        System.out.println(abcde.substring(0,3));
    }
}