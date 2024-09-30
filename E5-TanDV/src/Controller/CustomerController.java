package Controller;

import Entity.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    private static List<Customer> customers;
    public CustomerController(List<Customer> customers) {
        CustomerController.customers = customers;
    }

    public List<Customer> sortCustomerByName() {
        List<Customer> sortByName = customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
        return sortByName;
    }

}
