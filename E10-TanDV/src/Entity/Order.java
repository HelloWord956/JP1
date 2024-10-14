package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private int id;
    private String code;
    private Customer customer;
    private LocalDateTime orderDate;

    public Order(){;}

    public Order(int id, String code, Customer customer, LocalDateTime orderDate) {
        this.id = id;
        this.code = code;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                '}';
    }
}
