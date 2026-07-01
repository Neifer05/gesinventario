package exceptions;

public class InvalidCampAccountException extends RuntimeException {
    public InvalidCampAccountException(String message) {
        super(message);
    }
}