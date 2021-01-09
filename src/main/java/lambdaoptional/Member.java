package lambdaoptional;

import java.util.Collections;
import java.util.List;

public class Member {
    private String name;
    private List<String> skills;
    private Sex gender;

    public Member(String name, List<String> skills, Sex gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    public Sex getGender() {
        return gender;
    }
}