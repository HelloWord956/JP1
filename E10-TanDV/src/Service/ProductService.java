package Service;

import Entity.Product;
import IGeneral.IGeneric;

import java.util.List;
import java.util.Optional;

public class ProductService implements IGeneric<Product> {
    private List<Product> products;

    @Override
    public Product getById(int id) {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        return product.orElse(null);
    }

    @Override
    public List<Product> getByName(String name) {
        List<Product> product1 = products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
        return product1;
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }
}
