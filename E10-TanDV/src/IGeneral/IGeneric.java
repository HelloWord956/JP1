package IGeneral;

import java.util.List;

public interface IGeneric<T> {
    public T getById(int id);
    public List<T> getByName(String name);
    public List<T> getAll();
    public void add(T t);
    public T update(T t);
    public void delete(T t);
}
