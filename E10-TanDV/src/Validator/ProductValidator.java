package Validator;

import Entity.Product;
import Exception.ProductValidationException;

import java.util.regex.Pattern;

public class ProductValidator {
    private static final String ID_PATTERN = "^(MS|NE|SE)[0-9]{6}$";
    private static final String NAME_PATTERN = "^[a-zA-Z ]+$";

    public static void validate(Product product) throws ProductValidationException {
        if (!Pattern.matches(ID_PATTERN, product.getId())) {
            throw new ProductValidationException("Product ID is not valid!");
        }
        if (!Pattern.matches(NAME_PATTERN, product.getName())) {
            throw new ProductValidationException("Product name is not valid!");
        }
        if (product.getQuantity() < 0) {
            throw new ProductValidationException("Quantity must be non-negative!");
        }
    }
}
