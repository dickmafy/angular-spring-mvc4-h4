package net.codejava.spring.dao;

import net.codejava.spring.generic.AbstractHibernateDao;
import net.codejava.spring.model.SeguridadPerfil;
import net.codejava.spring.model.SeguridadUsuario;

import org.springframework.stereotype.Repository;


public class UserDAOImpl extends AbstractHibernateDao<SeguridadUsuario>  {

	public UserDAOImpl() {
		super(SeguridadUsuario.class);
	}
		
	
}
