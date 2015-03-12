package net.codejava.spring.controller;

import net.codejava.spring.generic.GenericDao;
import net.codejava.spring.model.SeguridadPerfil;
import net.codejava.spring.util.equifax.ConstantesUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/bean")
public class PerfilController extends GenericDao<SeguridadPerfil> {

	private static Logger			LOG	= Logger.getLogger(PerfilController.class);

	private SeguridadPerfil			bean;
	private List<SeguridadPerfil>	beanList;

	@PostConstruct
	public void init() {
		LOG.info("PerfilController- " + ConstantesUtil.POSTCONSTRUCT);
	}

	public PerfilController() {
		super(SeguridadPerfil.class);
	}

	@RequestMapping(value = "/list.json", method = RequestMethod.GET)
	public @ResponseBody
	List<SeguridadPerfil> list() {
		try {
			beanList = findAll();
		} catch (Exception e) {
			beanList = new ArrayList<SeguridadPerfil>();
		}
		return beanList;

	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return ConstantesUtil.LAYOUT_PERFIL + "/layout";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	void insert(@RequestBody SeguridadPerfil bean) {
		save(bean);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	void delete(@RequestBody SeguridadPerfil bean) {
		delete(bean);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	void update(@RequestBody SeguridadPerfil bean) {
		update(bean);
	}

	private SeguridadPerfil getBean() {
		return bean;
	}

	private void setBean(SeguridadPerfil bean) {
		this.bean = bean;
	}

}
