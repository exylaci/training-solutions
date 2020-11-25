package javabeans;

public class Pet {
    private String name;
    private String color;
    private int age;
    private boolean purebred;

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public boolean isPurebred() {
        return purebred;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPurebred(boolean purebred) {
        this.purebred = purebred;
    }
}