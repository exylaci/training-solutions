package exam03retake02;

public class Todo {
    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Invalid level!");
        }
        this.text = text;
        this.state = State.NON_COMPLETED;
        this.priority = priority;
    }

    public void complete() {
        this.state = State.COMPLETED;
    }

    public boolean isNotComplete() {
        return state == State.NON_COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }
}
