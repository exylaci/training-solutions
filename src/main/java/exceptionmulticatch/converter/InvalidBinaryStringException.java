package exceptionmulticatch.converter;

public class InvalidBinaryStringException extends RuntimeException {
    public InvalidBinaryStringException(Exception exception) {
        super(exception);
    }
}