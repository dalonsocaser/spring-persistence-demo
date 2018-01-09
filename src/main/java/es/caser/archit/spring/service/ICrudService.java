package es.caser.archit.spring.service;

import java.util.List;

public interface ICrudService<K,T> {
	 List<T> getAll();
     T getById(K key);
     T add(T element);
     void update(T element);
     void delete(K key);
}
