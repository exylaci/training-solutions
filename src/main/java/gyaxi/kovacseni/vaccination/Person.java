package gyaxi.kovacseni.vaccination;


public class Person {
    private final String name;
    private final String zip;
    private final int age;
    private final String email;
    private final String taj;
    private final VaccinationType vaccine;

    public Person(String name, String zip, int age, String email, String taj, VaccinationType vaccine) {
        this.name = name;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.taj = taj;
        this.vaccine = vaccine;
    }

    public static Person parse(String all) {
        String[] parts = all.split(VaccinationList.SEPARATOR);

        return new Person(
                parts[0],
                parts[1],
                Integer.parseInt(parts[2]),
                parts[3],
                parts[4],
                parts.length > 5 ? VaccinationType.valueOf(parts[5]) : VaccinationType.NONE);
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }

    public VaccinationType getVaccine() {
        return vaccine;
    }

    public static boolean isInvalidTaj(String taj) {
        int sum = 0;
        for (int i = 0; i < 8; ++i) {
            sum += taj.charAt(i) * (i % 2 == 0 ? 3 : 7);
        }
        return sum % 10 != Integer.parseInt(taj.charAt(8) + "");
    }
}