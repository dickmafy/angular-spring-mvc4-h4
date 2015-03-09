package net.codejava.spring.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class AbstractHibernateDao<T extends Serializable> {

	protected Class<T>	clazz;

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public AbstractHibernateDao(Class<T> clazz){
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

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

}