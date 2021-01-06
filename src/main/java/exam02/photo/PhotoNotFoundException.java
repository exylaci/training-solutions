package exam02.photo;

public class PhotoNotFoundException extends RuntimeException {
    public PhotoNotFoundException(String message) {
        super(message);
    }
}