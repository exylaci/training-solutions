package localvariables;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b ;
        // System.out.println(b);
        b= false;
        System.out.println(b);

        int a =2;
        int i=3, j=4;
        int k=i;
        // System.out.println(s);
        String s = "Hello World";
        String t = s;
        {
            int x=0;
            System.out.println(t);
        }
        // System.out.println(x);

    }
}
