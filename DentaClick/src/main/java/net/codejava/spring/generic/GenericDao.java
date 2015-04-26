package net.codejava.spring.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/*
@Repository
@Transactional
public abstract class GenericDao<T extends Serializable>  {

	protected Class<T>	clazz;

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public GenericDao(Class<T> clazz){
        this.clazz = clazz;
    }
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// realiza el flush terminando la peticion
	public void save(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	public T findOne(long id) {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getSession().createQuery("from " + clazz.getName())
				.list();
	}

	public void update(T entity) {
		getSession().merge(entity);
	}

	public void deleteById(Long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAllSort(String clazz) {
		List<T> list  = (List<T>) getSession().createQuery("from "+ clazz).list();
		return list;
		/*List<T> list;

		CriteriaBuilder criteriaBuilder;
		CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);

		Root<T> from = query.from(clazz);
		query.orderBy(criteriaBuilder.asc(from.get(propiedad1)));

		query.select(from);

		list = em.createQuery(query).setMaxResults(maxRowReturn).getResultList();*
		return list;*/

/*
	}
	

}
*/