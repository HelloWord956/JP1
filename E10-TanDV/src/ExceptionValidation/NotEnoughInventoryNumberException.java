package ExceptionValidation;

public class NotEnoughInventoryNumberException extends RuntimeException {
    public NotEnoughInventoryNumberException() {
    }

    public NotEnoughInventoryNumberException(String message) {
        super(message);
    }

    public NotEnoughInventoryNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
