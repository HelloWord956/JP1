package Validator;

import Entity.Customer;
import Exception.CustomerValidationException;

import java.util.regex.Pattern;

public class CustomerValidator {
    private static final String NAME_PATTERN = "^[a-zA-Z ]{3,50}$";

    public static void validate(Customer customer) throws CustomerValidationException {
        if (customer.getId() <= 0) {
            throw new CustomerValidationException("Customer ID must be greater than 0!");
        }
        if (!Pattern.matches(NAME_PATTERN, customer.getName())) {
            throw new CustomerValidationException("Customer name is invalid!");
        }
    }
}
