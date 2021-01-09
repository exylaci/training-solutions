package lambdaintro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    private String name;
    private List<String> skills;
    private Sex gender;
    private List<String> messages = new ArrayList<>();

    public Member(String name, List<String> skils, Sex sex) {
        this.name = name;
        this.skills = skils;
        this.gender = sex;
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

    public List<String> getMessages() {
        return messages;
    }

    public void sendMessage(String s) {
        messages.add(s);
    }
}