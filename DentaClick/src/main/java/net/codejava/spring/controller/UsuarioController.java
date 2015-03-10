package net.codejava.spring.controller;

import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.generic.AbstractHibernateDao;
import net.codejava.spring.model.SeguridadUsuario;
import net.codejava.spring.util.equifax.ConstantesUtil;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends AbstractHibernateDao<SeguridadUsuario> {

	private static Logger	LOG	= Logger.getLogger(UsuarioController.class);

	
	@PostConstruct
	public void init() {
		LOG.info("UsuarioController - " + ConstantesUtil.POSTCONSTRUCT);
	}

	public UsuarioController() {
		super(SeguridadUsuario.class);
	}

	@RequestMapping(value = "/list.json", method = RequestMethod.GET)
	public @ResponseBody
	List<SeguridadUsuario> listUsuario() {
		return findAll();
	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return ConstantesUtil.LAYOUT_USUARIO + "/layout";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	void insertUsuario(@RequestBody SeguridadUsuario bean) {
		save(bean);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	void deleteUsuario(@RequestBody SeguridadUsuario bean) {
		delete(bean);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateUsuario(@RequestBody SeguridadUsuario bean) {
		update(bean);
	}

}
