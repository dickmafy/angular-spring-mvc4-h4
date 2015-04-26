package net.codejava.spring.controller;

//import net.codejava.spring.dao.PerfilDao;
import net.codejava.spring.generic.GenericHibernate;
import net.codejava.spring.model.SeguridadPerfil;
import net.codejava.spring.model.SeguridadUsuario;
import net.codejava.spring.util.equifax.ConstantesUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private static Logger		LOG	= Logger.getLogger(UsuarioController.class);

	//@Autowired
	//private PerfilDao			perfilDao;

	@Autowired
	private GenericHibernate	dao;

	@PostConstruct
	public void init() {
		LOG.info("UsuarioController - " + ConstantesUtil.POSTCONSTRUCT);
	}

	@RequestMapping(value = "/list.json")
	public @ResponseBody
	List<SeguridadUsuario> listUsuario() {
		return dao.findAll(SeguridadUsuario.class);
	}
 
	@RequestMapping(value = "/listPerfil.json")
	public @ResponseBody
	List<SeguridadPerfil> listPerfil() { 
		List<SeguridadPerfil> list = new ArrayList<SeguridadPerfil>();
		list = dao.findAll(SeguridadPerfil.class);
		
		
		
		return list;
	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return ConstantesUtil.LAYOUT_USUARIO + "/layout";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	void insertUsuario(@RequestBody SeguridadUsuario bean) {
		dao.save(bean);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	void deleteUsuario(@RequestBody SeguridadUsuario bean) {
		dao.delete(bean);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateUsuario(@RequestBody SeguridadUsuario bean) {
		dao.saveOrUpdate(bean);
	}

	/*
	public PerfilDao getPerfilDao() {
		return perfilDao;
	}

	public void setPerfilDao(PerfilDao perfilDao) {
		this.perfilDao = perfilDao;
	}*/

}
