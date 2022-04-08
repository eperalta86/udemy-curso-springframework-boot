package cl.com.universidadspring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.com.universidadspring.service.IPersonaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InicioController {
	
	@Autowired
	private IPersonaService personaService; //al implementar un service, desacoplamos las capas y no llamamos a todo el objeto que implementa el CRUD en la capa DAO, ademas nuestra implementacion es acotada a lo que nuestro negocio necesite
	
	@GetMapping("/")
	public String inicio(Model model) {
		
		var personas = personaService.listarPersonas();
		log.info("ejecutando el controlador Spring MVC");
		model.addAttribute("personas", personas);
		
		return "index";
	}

}
