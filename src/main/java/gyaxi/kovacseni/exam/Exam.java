package gyaxi.kovacseni.exam;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Exam {
    public static final int DURATION_OF_IDENTIFICATION = 1;

    private final String topic;
    private final LocalDateTime start;

    Exam(String topic, LocalDateTime start) {
        this.topic = topic;
        this.start = start;
    }

    public static int getDurationOfIdentification() {
        return DURATION_OF_IDENTIFICATION;
    }

    public String getName() {
        return topic;
    }

    public LocalDateTime getBeginTime() {
        return start;
    }

    public abstract ExamType getType();

    public abstract int getDurationOfExam();

    public List<Exam> getExamsInChronologicalOrder(List<Exam> exams) {
        return exams
                .stream()
                .sorted(Comparator.comparing(Exam::getBeginTime))
                .collect(Collectors.toList());
    }

    public abstract LocalDateTime getBeginTimeOfExam();

    public abstract LocalDateTime getEndTimeOfExam();

    public abstract Map<String, LocalDateTime> getExamsBySpecialPredicate(List<Exam> exams);
}