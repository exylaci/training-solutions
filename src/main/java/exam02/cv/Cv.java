package exam02.cv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }


    public void addSkills(String... newskills) {
        for (String one : newskills) {
            skills.add(new Skill(one));
        }
    }


    public int findSkillLevelByName(String name) {
        for (Skill one : skills) {
            if (one.getName().equals(name)) {
                return one.getLevel();
            }
        }
        throw new SkillNotFoundException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }
}
//Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név, valamint skillek (hogy mihez ért az
// illető). A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.
//
//Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.
//
//A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).
//
//A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.