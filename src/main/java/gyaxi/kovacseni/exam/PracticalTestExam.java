package gyaxi.kovacseni.exam;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticalTestExam extends Exam {

    public static final int DURATION_OF_EXAM = 3;

    public PracticalTestExam(String topic, LocalDateTime start) {
        super(topic, start);
    }

    @Override
    public ExamType getType() {
        return ExamType.PRACTICAL_TEST;
    }

    @Override
    public int getDurationOfExam() {
        return DURATION_OF_EXAM;
    }

    @Override
    public Map<String, LocalDateTime> getExamsBySpecialPredicate(List<Exam> exams) {
        return exams
                .stream()
                .filter(exam -> exam.getBeginTime().toLocalTime().isAfter(LocalTime.of(12, 0)))
                .collect(Collectors.toMap(Exam::getName, Exam::getBeginTime));
    }

    @Override
    public LocalDateTime getBeginTimeOfExam() {
        return super.getBeginTime().minusHours(getDurationOfIdentification());
    }

    @Override
    public LocalDateTime getEndTimeOfExam() {
        return super.getBeginTime().plusHours(3);
    }
}