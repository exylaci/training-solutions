package gyaxi.kovacseni.zooadoption;

public class Connection {
    private final Adoption adoption;
    private final Person person;

    public Connection(Adoption adoption, Person person) {
        this.adoption = adoption;
        this.person = person;
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public Person getPerson() {
        return person;
    }
}