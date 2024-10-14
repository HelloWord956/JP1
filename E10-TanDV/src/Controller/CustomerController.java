package Controller;

import Entity.Customer;
import ExceptionValidation.InvalidCustomerNameException;
import Service.CustomerService;
import Validattion.Validation;

public class CustomerController {
    private CustomerService customerService;
    public CustomerController() {;}
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void add(Customer customer) {
        if(Validation.isCustomerName(customer.getName())) {
            customerService.add(customer);
        } else {
            throw new InvalidCustomerNameException("Customer name is invalid!");
        }
    }
}
