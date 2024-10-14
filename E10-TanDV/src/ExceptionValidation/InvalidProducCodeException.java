package ExceptionValidation;

public class InvalidProducCodeException extends RuntimeException {
    public InvalidProducCodeException() {
    }

    public InvalidProducCodeException(String message) {
        super(message);
    }

    public InvalidProducCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
