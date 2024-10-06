package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    private static List<Customer> customers;
    private CustomerService cs;

    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    public List<Customer> sortCustomerByName() {
        List<Customer> customers1 = cs.sortCustomerByName();
        return customers1;
    }

}
