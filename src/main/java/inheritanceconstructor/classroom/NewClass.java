package inheritanceconstructor.classroom;

public class NewClass extends ClassRoom{

    public NewClass() {
        super("valahol",300,Facility.CHALKBOARD); //Ez csak az öröklődés default konstruktor példa miatt
        //this("valahol",300,Facility.CHALKBOARD);               //Mert így "szebb" lenne.
    }

    public NewClass(String location, int capacity, Facility facility) {
        super(location, capacity, facility);
    }
}
