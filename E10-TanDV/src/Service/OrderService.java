package Service;

import Entity.Order;
import IGeneral.IGeneric;

import java.util.List;
import java.util.Optional;

public class OrderService implements IGeneric<Order> {
    private List<Order> orders;

    @Override
    public Order getById(int id) {
        Optional<Order> order = orders.stream().filter(o -> o.getId() == id).findFirst();
        return order.orElse(null);
    }

    @Override
    public List<Order> getByName(String name) {
        return List.of();
    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void delete(Order order) {
        orders.remove(order);
    }
}
