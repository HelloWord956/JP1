package Entity;

import java.time.LocalDate;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;
    private LocalDate dateTime;

    public Invoice(){;}

    public Invoice(int id, Customer customer, double amount, LocalDate dateTime) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.dateTime = dateTime;

    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        return amount - (amount * customer.getDiscount() / 100);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer +
                "(" + customer.getDiscount() + "%" + ")" +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}' + "\n";
    }
}
