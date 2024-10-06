package Service;

import Entity.Customer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> sortCustomerByName() {
        List<Customer> sortByName = customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
        return sortByName;
    }
}
