package cl.com.universidadspring.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.com.universidadspring.dao.IPersonaDao;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InicioController {
	
	@Autowired
	private IPersonaDao personaDao;
	
	@GetMapping("/")
	public String inicio(Model model) {
		
		var personas = personaDao.findAll();
		log.info("ejecutando el controlador Spring MVC");
		model.addAttribute("personas", personas);
		
		return "index";
	}

}
