package Controller;

import Entity.Customer;
import Service.CustomerService;
import java.util.List;

import java.security.Provider;

public class CustomerController {
    private List<Customer> customers;
    private CustomerService cs;

    public CustomerController(CustomerService cs){
        this.cs = cs;
    }
    public Customer getById(int id){
        Customer customer  = cs.getById(id);
        if(customer != null){
            return customer;
        }
        return null;
    }
}
