package ExceptionValidation;

public class InvalidOrderCodeException extends RuntimeException {
    public InvalidOrderCodeException() {
    }

    public InvalidOrderCodeException(String message) {
        super(message);
    }

    public InvalidOrderCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
