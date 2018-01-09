package es.caser.archit.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericDAOImpl<K,T> implements IGenericDAO<K, T> {
	@PersistenceContext
	protected EntityManager entityManager;

	private final Class<T> type;
	public GenericDAOImpl (Class<T> type) {
		 super();
		 this.type = type;
	}
	@Override
	public List<T> getAll() {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(type);
		Root<T> root = cq.from(type);
		cq.select(root);
		return this.entityManager.createQuery(cq).getResultList();
	}	
	@Override
	public T getById(K id) {
		
		return entityManager.find(type, id);
	}
	@Override
	public void add(T element) {
		entityManager.persist(element);
		
	}
	@Override
	public void update(T element) {
		entityManager.merge(element);
	}
	@Override
	public void delete(K key) {
		entityManager.remove(getById(key));
		
	}

}
