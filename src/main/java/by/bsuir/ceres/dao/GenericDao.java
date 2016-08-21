package by.bsuir.ceres.dao;

public interface GenericDao<K, T> {
    void create(T object);
    T read(K key);
    void update(T object);
    void delete(K key);
}
