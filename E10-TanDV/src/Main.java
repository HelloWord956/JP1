import Entity.*;
import Validator.*;
import Exception.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("MS000001", "Coffee", 10));
        products.add(new Product("MS000002", "Tea", 5));

        try {
            Customer customer = new Customer(1, "John Doe");
            CustomerValidator.validate(customer);

            Order order = new Order("ORDPM00000001", customer.getId(), LocalDate.now());
            OrderValidator.validate(order);

            OrderDetail orderDetail = new OrderDetail(1, order.getId(), "MS000001", 5, OrderStatus.PENDING);
            Optional<Product> optionalProduct = products.stream()
                            .filter(p -> p.getId().equals(orderDetail.getProduct_id()))
                            .findFirst();
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                ProductValidator.validate(product);
                OrderDetailValidator.validate(orderDetail, product);

                product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
                System.out.println("Order placed successfully. Remaining quantity: " + product.getQuantity());

                orderDetail.setStatus(OrderStatus.PENDING);
                System.out.println("Order status updated to: " + orderDetail.getStatus().getDescription());
            }
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}