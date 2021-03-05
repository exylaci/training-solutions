package graduateproject;

public class Citizen {
    public static final String FIELD_SEPARATOR = ";";
    public static final int POSITION_NAME = 0;
    public static final int POSITION_ZIP = 1;
    public static final int POSITION_AGE = 2;
    public static final int POSITION_EMAIL = 3;
    public static final int POSITION_TAJ = 4;
    public static final int NUMBER_OF_PARTS = 5;

    private String name;
    private String zip;
    private int age;
    private String email;
    private String taj;

    public Citizen() {
    }

    public Citizen(String all) {
        String[] parts = all.trim().split(FIELD_SEPARATOR);
        if (parts.length != NUMBER_OF_PARTS) {
            throw new IllegalArgumentException("Invalid data!");
        }
        name = parts[POSITION_NAME];
        zip = parts[POSITION_ZIP];
        try {
            age = Integer.parseInt(parts[POSITION_AGE]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid data!");
        }
        email = parts[POSITION_EMAIL];
        taj = parts[POSITION_TAJ];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%s;%s", name, zip, age, email, taj);
    }
}
