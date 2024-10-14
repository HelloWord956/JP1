package ExceptionValidation;

public class NotFoundOrderIdException extends RuntimeException {
    public NotFoundOrderIdException() {
    }

    public NotFoundOrderIdException(String message) {
        super(message);
    }

    public NotFoundOrderIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
