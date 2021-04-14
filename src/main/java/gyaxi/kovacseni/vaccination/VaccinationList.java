package gyaxi.kovacseni.vaccination;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VaccinationList {
    public static final String SEPARATOR = ";";
    private MetaData metaData;
    private Map<LocalTime, Person> inviteds = new TreeMap<>();

    public void readFromFile(BufferedReader br) throws IOException {
        readMetaData(br);
        readEmptyLineAndHeader(br);
        readinvitations(br);
    }

    public Map<LocalTime, Person> getVaccinations() {
        return inviteds;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    private void readMetaData(BufferedReader br) throws IOException {
        String firstLine = br.readLine();
        String secondLine = br.readLine();

        int cutPointFirstLine = firstLine.indexOf(",");
        int cutPointSecondLine = secondLine.indexOf(":");
        metaData = new MetaData(
                firstLine.substring(cutPointFirstLine - 4, cutPointFirstLine),
                firstLine.substring(cutPointFirstLine + 2).replace(" településre", ""),
                LocalDate.parse(secondLine.substring(cutPointSecondLine + 2), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    private void readEmptyLineAndHeader(BufferedReader br) throws IOException {
        br.readLine();
        br.readLine();
    }

    private void readinvitations(BufferedReader br) throws IOException {
        String oneLine;
        while ((oneLine = br.readLine()) != null) {
            int cutPoint = oneLine.indexOf(SEPARATOR);
            inviteds.put(
                    LocalTime.parse(oneLine.substring(0, cutPoint), DateTimeFormatter.ofPattern("H:mm")),
                    Person.parse(oneLine.substring(cutPoint + 1)));
        }
    }

    public List<Person> getPersonsMoreThanHundredYearsOld() {
        return inviteds
                .values()
                .stream()
                .filter(person -> person.getAge() > 100)
                .collect(Collectors.toList());
    }

    public List<Person> getAfternoonPersons() {
        return inviteds
                .entrySet()
                .stream()
                .filter(entryset -> entryset.getKey().isAfter(LocalTime.of(12, 0)))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public void validateTaj() {
        String invalids = inviteds
                .values()
                .stream()
                .map(Person::getTaj)
                .filter(Person::isInvalidTaj)
                .collect(Collectors.joining(", "));

        if (!invalids.isBlank()) {
            throw new IllegalArgumentException(invalids + ", ");
        }
    }

    public String inviteExactPerson(LocalTime time) {
        if (inviteds.containsKey(time)) {
            return String.format("Kedves %s! Ön következik. Kérem, fáradjon be!",
                    inviteds.get(time).getName());
        }
        throw new IllegalArgumentException("Invalid time!");
    }

    public Town getTown() {
        return metaData.getTown();
    }

    public LocalDate getDateOfVaccination() {
        return metaData.getDate();
    }

    public Map<VaccinationType, Integer> getVaccinationStatistics() {
        return inviteds
                .values()
                .stream()
                .collect(Collectors.toMap(
                        Person::getVaccine,
                        v -> 1,
                        Integer::sum));
    }
}