package gyaxi.orokles.airport;

public abstract class Person {
    private final String name;
    private Integer age;

    protected Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    protected Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public abstract Type getType();

    public void becomeOlder() {
        ++age;
    }
}
