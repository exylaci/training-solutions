package exam02.cv;

public class Skill {
    public static final String SPLITTER = "\\(";
    private String name;
    private int level;

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public Skill(String skill) {
        String[] parts = skill.split(SPLITTER);
        this.name = parts[0].trim();
        this.level = Integer.parseInt(parts[1].replace(")", "").trim());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}