package ExceptionValidation;

public class NotFoundCustomerIdException extends RuntimeException {
    public NotFoundCustomerIdException() {
    }

    public NotFoundCustomerIdException(String message) {
        super(message);
    }

    public NotFoundCustomerIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
