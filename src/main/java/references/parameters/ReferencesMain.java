package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1;
        Person person2;
        person1 = new Person("Gábor Áron",(byte)36);
        person2 = person1;
        person2.setName("Valaki Más");

        System.out.printf("%s (%d)\n",person1.getName(),person1.getAge());
        System.out.printf("%s (%d)\n",person2.getName(),person2.getAge());

        int i1;
        int i2;
        i1 = 24;
        i2 = i1;
        ++i2;
        System.out.println( i1 );
        System.out.println( i2 );

        Person person3 = new Person("harmadik személy",(byte)55);
        person1 = person3;
        System.out.printf("%s (%d)\n",person1.getName(),person1.getAge());
        System.out.printf("%s (%d)\n",person2.getName(),person2.getAge());
    }

}
