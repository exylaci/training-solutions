package employee;

public class Employee {
    String name;
    String job;
    int salary;

    public Employee(String name, String job, int salary) {
        if (name==null || name.length()==0){
            throw new IllegalArgumentException("Name must not be empty.");
        }
        if (job==null || job.length()==0){
            throw new IllegalArgumentException("Job must not be empty.");
        }
        if (salary<0){
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return name + " - " + job + " - " + salary + " Ft";
    }

}
//Készítsd el az Employee osztályt és annak a toString() metódusát!
// Az osztály tartalmazza az alkalmazott nevét, foglalkozását és fizetését, melyeket konstruktorban kap meg.
// A toString() metódus az alkalmazott adatait az alábbi formában adja vissza:
//Kis Géza - minőségellenőr - 520000 Ft
//
//Hibakezelés:
//Minden adat megadása kötelező, és a fizetés csak 1000-rel osztható pozitív szám lehet. Bármilyen hiba esetén dobj IllegalArgumentException kivételt!