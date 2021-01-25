package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Company {

    List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    List<Project> projects;
    List<Employee> employees;

    public Company(InputStream employeesFile, InputStream projectsFile) {
        projects = loadProjectsFromFile(projectsFile);
        employees = loadEmployesFromFile(employeesFile);
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        Project projectFromList = findProjectInList(project);
        Employee employeeFromList = findEmployeeInList(employee);
        timeSheetItems.add(new TimeSheetItem(employeeFromList, projectFromList, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String fullname, int year, int month) {
        Map<Project, Long> summary = summarizing(fullname, year, month);
        List<ReportLine> result = new ArrayList<>();
        for (Project project : projects) {
            result.add(new ReportLine(project, summary.getOrDefault(project, 0L)));
        }
        return result;
    }

    public void printToFile(String fullname, int year, int month, Path report) {
        Map<Project, Long> summary = summarizing(fullname, year, month);
        long total = summary.values().stream().mapToLong(value -> value).sum();

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(report))) {
            writeToFile(writer, new DataPackedIntoAClass(fullname, year, month, total, summary));
        } catch (IOException e) {
            throw new IllegalStateException("Can't write to " + report);
        }
    }

    private void writeToFile(PrintWriter writer, DataPackedIntoAClass dataPackedIntoAClass) throws IOException {
        writer.printf("%s\t%d-%02d\t%d\n",
                dataPackedIntoAClass.getFullname(),
                dataPackedIntoAClass.getYear(),
                dataPackedIntoAClass.getMonth(),
                dataPackedIntoAClass.getTotal());
        for (
                Project project : projects) {
            if (dataPackedIntoAClass.getSummary().containsKey(project)) {
                writer.printf("%s\t%d\n",
                        project,
                        dataPackedIntoAClass.getSummary().get(project));
            }
        }
    }

    private Map<Project, Long> summarizing(String fullname, int year, int month) {
        checkEmployee(fullname);
        return timeSheetItems
                .stream()
                .filter(timeSheetItem -> timeSheetItem.getEmployee().getName().equals(fullname))
                .filter(timeSheetItem -> timeSheetItem.getBeginDate().getYear() == year &&
                        timeSheetItem.getBeginDate().getMonthValue() == month)
                .collect(Collectors.groupingBy(
                        TimeSheetItem::getProject,
                        Collectors.summingLong(TimeSheetItem::hoursBetweenDates)));
    }

    private void checkEmployee(String fullname) {
        if (fullname == null) throw new IllegalArgumentException("Name is a must!");

        for (Employee employee : employees) {
            if (employee.getName().equals(fullname)) {
                return;
            }
        }
        throw new IllegalArgumentException(fullname + " not exists!");
    }

    private List<Employee> loadEmployesFromFile(InputStream employeesFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(employeesFile))) {
            List<Employee> result = new ArrayList<>();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                result.add(new Employee(oneLine));
            }
            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from this source!");
        }
    }

    private List<Project> loadProjectsFromFile(InputStream projectsFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(projectsFile))) {
            List<Project> result = new ArrayList<>();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                result.add(new Project(oneLine));
            }
            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from this source!");
        }
    }

    private Employee findEmployeeInList(Employee employee) {
        for (Employee one : employees) {
            if (one.getName().equals(employee.getName())) {
                return one;
            }
        }
        return employee;
    }

    private Project findProjectInList(Project project) {
        for (Project one : projects) {
            if (one.getName().equals(project.getName())) {
                return one;
            }
        }
        return project;
    }
}
//Timesheet projekt
//
//A feladatban egy cég munkaidő nyilvántartását kell megvalósítani. A cégen belül vannak alkalmazottak illetve
// projektek. A cél, hogy az egyes alkalmazottak, egyes projekteken végzett munkaidejét megfelelő formátumban egy
// fájlba kiírjuk. A várt formátumot megtalálod a tesztesetek adatai között.
//
//UML osztálydiagram
//
//Részletes leírás
//
//A timesheet csomagba dolgozz! A Company osztály tartalmazza a projekteket, alkalmazottakat, valamint annak listáját,
// hogy ki min mettől-meddig dolgozott. A projekteket és alkalmazottak neveit egy-egy fájlból kell beolvasni a
// konstruktorban, (alkalmazottnál vezeték-, keresztnevet külön-külön).
//
//Az addTimeSheetItem metódusban lehet új elemet felvenni. Fontos, hogy itt az időpontok mindig egy napra essenek,
// valamint a mikortól korábbi időpont legyen mint a meddig. Ilyen elemeket bármikor hozzáadhatunk a nyilvántartáshoz.
// Ezeket a TimeSheetItem konstruktorában kell ellenőrizni.
//
//A következőképp lehet ellenőrizni, hogy két időpont ugyanarra a napra esik-e:
//  beginDate.toLocalDate().equals(endDate.toLocalDate())
//
//Így lehet ellenőrizni, hogy az egyik dátum a másik dátum után van-e:
//  beginDate.isAfter(endDate)
//
//A TimeSheetItem osztályban érdemes megvalósítani a hoursBetweenDates() metódust is. Két dátum között eltelt órák
// számát a következőképp lehet kiszámítani:
//  Duration.between(beginDate, endDate).toHours()
//
//A LocalDateTime objektumtól az évet a beginDate.getYear(), a hónapot a beginDate.getMonthValue() metódussal lehet
// lekérni.
//
//A calculateProjectByNameYearMonth() metódus adja vissza, hogy az adott alkalmazott az adott évben és hónapban melyik
// projekten mennyit dolgozott.
//
//A megfelelő projekt-óra párok kialakításához segítségedre lehet a RiportLine kiegészítő osztály és ezeket az elemeket
// tárolhatod egy listában. Ezt a listát érdemes először összeállítani, ahol a megfelelő projekt ideje folyamatosan
// növelhető.
//
//A printToFile() metódus írja ki az előző eredményét fájlba! Fontos, hogy csak olyan alkalmazott adatait engedjük
// kiírni, aki valóban a cégnél dolgozik! A projektek felsorolásánál csak azokat írjuk ki amin valóban dolgozott!
//
//A fájl formátuma:
//  John Connor 2013-01 14
//  Java    10
//  C++ 4
//
//Ez azt jelenti, hogy John Connor 2013 januárjában összesen 14 órát dolgozott, ebből 10 órát a Java projekten, 4 órát
// a C# projekten.
//
//Különösen ügyeljünk arra, hogy rövid metódusaink legyenek, és ne legyen benne blokkok egymásba ágyazása két szintnél
// mélyebben!