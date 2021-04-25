package gyaxi.kovacseni.exam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheoryTestExam extends Exam {

    public static final int DURATION_OF_EXAM = 1;

    public TheoryTestExam(String topic, LocalDateTime start) {
        super(topic, start);
    }

    @Override
    public ExamType getType() {
        return ExamType.THEORY_TEST;
    }

    @Override
    public int getDurationOfExam() {
        return DURATION_OF_EXAM;
    }

    @Override
    public Map<String, LocalDateTime> getExamsBySpecialPredicate(List<Exam> exams) {
        return exams
                .stream()
                .filter(exam -> exam.getName().contains("fejlesztő"))
                .collect(Collectors.toMap(Exam::getName, Exam::getBeginTime));
    }

    @Override
    public LocalDateTime getBeginTimeOfExam() {
        return super.getBeginTime().minusHours(getDurationOfIdentification());
    }

    @Override
    public LocalDateTime getEndTimeOfExam() {
        return super.getBeginTime().plusHours(1);
    }
}