package week15.d02;

public class Question {
    private String question;
    private String answer;
    private int score;

    public Question(String question, String answer, int score) {
        this.question = question;
        this.answer = answer;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                "}\n";
    }
}
