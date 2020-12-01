package inheritanceconstructor.classroom;

public class Course {
    public int participants;
    public Facility facilityNeeded;

    public Course(int participants, Facility facilityNeeded) {
        this.participants = participants;
        this.facilityNeeded = facilityNeeded;
    }

    public int getParticipants() {
        return participants;
    }

    public Facility getFacilityNeeded() {
        return facilityNeeded;
    }
}
