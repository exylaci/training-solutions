package week09.d03;

import java.util.Random;

public class Person {
    private String name;
    private int age;
    private Present present;

    public Person(String name, int age) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty!");
        if (age < 1) throw new IllegalArgumentException("Age must be positive!");
        this.name = name;
        this.age = age;
    }

    public void setPresent(Random random) {
        if (age > 14) {
            this.present = Present.values()[random.nextInt(Present.values().length - 1) + 1];
        } else {
            this.present = Present.values()[random.nextInt(Present.values().length)];
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }
}