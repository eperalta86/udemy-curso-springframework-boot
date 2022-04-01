package cl.com.universidadspring.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InicioController {
	
	@GetMapping("/")
	public String inicio(Model model) {

		log.info("ejecutando el controlador Spring MVC");
		//model.addAttribute("personas", personas);
		
		return "index";
	}

}
