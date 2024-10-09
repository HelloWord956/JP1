package Validator;

import Entity.OrderDetail;
import Entity.Product;
import Exception.OrderDetailValidationException;

public class OrderDetailValidator {
    public static void validate(OrderDetail orderDetail, Product product) throws OrderDetailValidationException {
        if (orderDetail.getQuantity() < 0) {
            throw new OrderDetailValidationException("Quantity must be non-negative!");
        }
        if (orderDetail.getQuantity() > product.getQuantity()) {
            throw new OrderDetailValidationException("Insufficient inventory for product");
        }
    }
}
