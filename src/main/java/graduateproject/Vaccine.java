package graduateproject;

import java.time.LocalDate;

public class Vaccine {

    private int id;
    private LocalDate date;
    private String vaccine;
    private String result;
    private String note;
    private String taj;
    private int numberOfVaccinations;

    public Vaccine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public int getNumberOfVaccinations() {
        return numberOfVaccinations;
    }

    public void setNumberOfVaccinations(int numberOfVaccinations) {
        this.numberOfVaccinations = numberOfVaccinations;
    }
}
