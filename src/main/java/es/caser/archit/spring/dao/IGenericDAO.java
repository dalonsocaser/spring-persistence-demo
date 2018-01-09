package es.caser.archit.spring.dao;

import java.util.List;

public interface IGenericDAO<K,T> {
	List<T> getAll();
    T getById(K id);
    void add(T element);
    void update(T element);
    void delete(K key);   
}
