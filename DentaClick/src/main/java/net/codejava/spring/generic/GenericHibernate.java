package net.codejava.spring.generic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GenericHibernate {

	@Autowired
	private SessionFactory	sessionFactory;

	private Session getSession() {
		//si usas open , es posible que no se raye y no ejecute nada.spring configuro el Sessionfactory
		return sessionFactory.getCurrentSession();
	}

	public <T> T save(final T o) {
		return (T) getSession().save(o);
	}

	public void delete(final Object object) {
		getSession().delete(object);
	}

	/***/
	public <T> T get(final Class<T> type, final Long id) {
		return (T) getSession().get(type, id);
	}

	/***/
	public <T> T merge(final T o) {
		return (T) getSession().merge(o);
	}

	/***/
	public <T> void saveOrUpdate(final T o) {
		getSession().saveOrUpdate(o);
	}

	public <T> List<T> findAll(final Class<T> type) {
		final Session session = getSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}
	// and so on, you shoudl get the idea
}