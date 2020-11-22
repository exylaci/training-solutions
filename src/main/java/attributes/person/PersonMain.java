package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person();
        person.correctData("Gábor Áron",
                "123456 AA",
                new Address("Magyarország","Világos","Rézágyú utca 1.","1848"));
        System.out.println(person.personToString());

        person.moveToAddress(new Address("Ujzéland","Oakland","23th Long street","Z-1234"));
        System.out.println(person.personToString());
    }
}
