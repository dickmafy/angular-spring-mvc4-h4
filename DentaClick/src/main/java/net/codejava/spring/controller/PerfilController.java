package net.codejava.spring.controller;

import net.codejava.spring.dao.PerfilDAO;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.generic.AbstractHibernateDao;
import net.codejava.spring.model.Perfil;
import net.codejava.spring.util.equifax.ConstantesUtil;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/bean")
public class PerfilController extends AbstractHibernateDao<Perfil> {

	private static Logger	LOG	= Logger.getLogger(PerfilController.class);

	@Autowired
	private PerfilDAO		dao;

	private Perfil			bean;
	private List<Perfil>	beanList;

	@PostConstruct
	public void init() {
		LOG.info("PerfilController- " + ConstantesUtil.POSTCONSTRUCT);
	}

	public PerfilController() {
		super(Perfil.class);
	}

	@RequestMapping(value = "/list.json", method = RequestMethod.GET)
	public @ResponseBody
	List<Perfil> list() {
		try {
			beanList = findAll();
		} catch (Exception e) {
			beanList = new ArrayList<Perfil>();
		}
		return beanList;

	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return ConstantesUtil.LAYOUT_PERFIL + "/layout";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	void insert(@RequestBody Perfil bean) {
		save(bean);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	void delete(@RequestBody Perfil bean) {
		delete(bean);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	void update(@RequestBody Perfil bean) {
		update(bean);
	}

	private Perfil getBean() {
		return bean;
	}

	private void setBean(Perfil bean) {
		this.bean = bean;
	}

}
