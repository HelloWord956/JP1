package Validator;

import Entity.Order;
import Exception.OrderValidationException;

import java.util.regex.Pattern;

public class OrderValidator {
    private static final String ID_PATTERN = "^ORDPM[0-9]{8}$";

    public static void validate(Order order) throws OrderValidationException {
        if (!Pattern.matches(ID_PATTERN, order.getId())) {
            throw new OrderValidationException("Order ID is invalid!");
        }
    }
}
