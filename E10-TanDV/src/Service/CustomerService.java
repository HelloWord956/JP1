package Service;

import Entity.Customer;
import IGeneral.IGeneric;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService implements IGeneric<Customer> {
    private static List<Customer> customers;
    @Override
    public Customer getById(int id) {
        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        return customer.orElse(null);
    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> customer1 = customers.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
        return customer1;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }
}
