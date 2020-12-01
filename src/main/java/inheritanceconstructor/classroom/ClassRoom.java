package inheritanceconstructor.classroom;

public class ClassRoom extends Room {
    private Facility facility;

    /* Nincs default kontruktor, ezért az az öröklődő osztályban sem lehet.
       Ha abban akarunk paraméter nélküli konstruktort, akkor azt kézzel kell létrehozni
           és abban is ezt a konstruktort kell meghívni.
    */
    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }

    public boolean isSuitable(Course course) {
        return course.getFacilityNeeded() == facility;
    }

    public Facility getFacility() {
        return facility;
    }
}
