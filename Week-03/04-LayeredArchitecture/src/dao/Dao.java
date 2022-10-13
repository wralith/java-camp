package dao;

public interface Dao<T> {
    T get(int id);

    void add(T t);

    void update(T t);

    void delete(T t);
}
