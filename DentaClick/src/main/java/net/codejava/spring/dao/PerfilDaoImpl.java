package net.codejava.spring.dao;

import net.codejava.spring.generic.AbstractHibernateDao;
import net.codejava.spring.model.SeguridadPerfil;
import net.codejava.spring.model.SeguridadUsuario;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PerfilDaoImpl extends AbstractHibernateDao<SeguridadPerfil>  {
	
	public PerfilDaoImpl() {
		super(SeguridadPerfil.class);
	}
	
}
