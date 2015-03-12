package net.codejava.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public ModelAndView index() {
		//List<Usuario> listUsers = userDao.list();
		//model.addObject("userList", listUsers);
		//return model;
		System.out.println("###############################ENTRANDO A HomeController");
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
}
