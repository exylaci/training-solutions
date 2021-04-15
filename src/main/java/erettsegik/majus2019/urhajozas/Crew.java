package erettsegik.majus2019.urhajozas;

import java.time.LocalDate;

public class Crew {
    private final String missionName;
    private final LocalDate missionDate;
    private final String astronautName;
    private final String country;
    private final Sex sex;

    public Crew(String missionName, LocalDate missionDate, String astronautName, String country, Sex sex) {
        this.missionName = missionName;
        this.missionDate = missionDate;
        this.astronautName = astronautName;
        this.country = country;
        this.sex = sex;
    }

    public String getMissionName() {
        return missionName;
    }

    public LocalDate getMissionDate() {
        return missionDate;
    }

    public String getAstronautName() {
        return astronautName;
    }

    public String getCountry() {
        return country;
    }

    public Sex getSex() {
        return sex;
    }
}