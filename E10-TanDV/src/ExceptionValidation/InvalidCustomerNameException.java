package ExceptionValidation;

public class InvalidCustomerNameException extends RuntimeException {
    public InvalidCustomerNameException() {
        ;
    }

    public InvalidCustomerNameException(String message) {
        super(message);
    }

    public InvalidCustomerNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
