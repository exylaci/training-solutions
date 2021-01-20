package collectionsqueue.job;

public class NoJobException extends IllegalStateException {
    public NoJobException(String message) {
        super(message);
    }
}