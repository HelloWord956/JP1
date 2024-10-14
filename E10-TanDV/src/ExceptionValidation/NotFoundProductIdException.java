package ExceptionValidation;

public class NotFoundProductIdException extends RuntimeException {
    public NotFoundProductIdException() {
    }

    public NotFoundProductIdException(String message) {
        super(message);
    }

    public NotFoundProductIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
