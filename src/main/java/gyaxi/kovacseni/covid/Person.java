package gyaxi.kovacseni.covid;

public class Person {
    private String name;
    private int age;
    private ChronicDisease chronic;
    private Pregnancy pregnant;

    protected Person(String name, int age, ChronicDisease chronic, Pregnancy pregnant) {
        this.name = name;
        this.age = age;
        this.chronic = chronic;
        this.pregnant = pregnant;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean notPregnant() {
        return !pregnant.isPregnant();
    }

    public boolean hasChronicDisease() {
        return chronic.hasChronicDisease();
    }

    public boolean isHealthy() {
        return !chronic.hasChronicDisease();
    }

    public boolean isYoung() {
        return age <= 65;
    }
}