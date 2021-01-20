package schoolrecords;

public class Mark {
    MarkType markType;
    Subject subject;
    Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if ( subject==null || tutor==null ){
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        if ( !tutor.tutorTeachingSubject(subject) ){
            throw new IllegalArgumentException(tutor.getName() + " doesn't have " + subject.getSubjectName() + " subject!");
        }
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        this(  MarkType.valueOf(markType) , subject , tutor );
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)",markType.description, markType.value);
    }
}

