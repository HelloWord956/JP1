package IGeneral;

import java.util.List;

public interface IGeneral<T> {
    public T getById(int id);
    public List<T> getByName(String name);
    public List<T> sortCustomer();
}
