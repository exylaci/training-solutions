package introinheritance.employee;

public class BigBoss extends Boss{
    private double bonus;

    public BigBoss(String name, String address, double salary, int numberOfEmployees, double bonus) {
        super(name, address, salary, numberOfEmployees);
        this.bonus = bonus;
    }

    public double getSalary(){
        return super.getSalary()+bonus;
    }

    public double getBonus() {
        return bonus;
    }

}
