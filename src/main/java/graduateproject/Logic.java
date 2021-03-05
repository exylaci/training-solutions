package graduateproject;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Logic {
    public static final String SUCCESSFUL = "BEADOTT";
    public static final String FAILED = "MEGHIUSULT";

    private final DataSource source;
    private final CitizensDao dao;

    public Logic(DataSource source) {
        this.source = source;
        dao = new CitizensDao(source);
    }


    public void initialize() {
        try (BufferedReader reader = Files.newBufferedReader(
                Path.of("src/main/resources/graduateproject/cities.csv"),StandardCharsets.UTF_8)) {

            new CitiesDao(source).initializeDao(reader);

        } catch (IOException e) {
            throw new IllegalStateException("Can't open the city list file!");
        }
    }


    public String getCity(String zip) {
        if (zip.isBlank()) {
            return "";
        }
        try {
            return new CitiesDao(source).getCityDao(zip);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Can't read from to CITIES data table!", e);
        }
    }


    public void insertCitizen(Citizen citizen) {
        try {
            dao.insertCitizenDao(citizen);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Can't insert to CITIZENS data table!", e);
        }
    }


    public List<String> registrationFromFile(String path, List<String> invalidLines) {
        try (Scanner fileScanner = new Scanner(Files.newInputStream(Path.of(path)))) {
            fileScanner.nextLine();
            return dao.insertCitizensFromStreamDao(fileScanner, invalidLines);
        } catch (IOException e) {
            throw new IllegalStateException("Can't open the file!", e);
        }

    }


    public boolean generate(String zip, String path) {

        try (BufferedWriter writer = Files.newBufferedWriter(
                Path.of(path), StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {

            writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám");
            writer.newLine();
            dao.selectFirst16Dao(zip, writer);
            return true;

        } catch (IOException | IllegalStateException e) {
            return false;
        }
    }


    public String getVaccine(int id) {
        return new VaccinationsDao(source).getVaccine(id);
    }


    public int getNumberOfVaccinationsById(Vaccine vaccine) {
        return dao.getNumberOfVaccinations(vaccine.getId());
    }


    public void storeVaccination(Vaccine vaccine) {
        if (vaccine.getResult().equals(SUCCESSFUL)) {
            dao.storeSuccessfulVacination(vaccine);
        } else {
            dao.storeFailedVacination(vaccine);
        }
    }


    public int getIdByTaj(Vaccine vaccine) {
        return dao.getIdByTaj(vaccine.getTaj());
    }


    public List<String> getReport() {
        return dao.getReport();
    }
}