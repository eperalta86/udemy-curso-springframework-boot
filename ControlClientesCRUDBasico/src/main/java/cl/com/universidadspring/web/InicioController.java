package cl.com.universidadspring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cl.com.universidadspring.dominio.Persona;
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
	
	//Podriamos agregar una persona dentro del metodo, pero le diremos a Spring que nos inyecte un objeto del tipo persona
	//Buscara un objeto del tipo Persona en la fabrica de spring, sino lo encuentra creara un nuevo objeto y lo inyectara de manera automatica
	//Asi nos evitamos usar el operador new, tambien queda habilitado en el alcance de request, por lo que no hay que crear HttpRequest
	@GetMapping("/agregar")
	public String agregar(Persona persona) { 
		return "modificar"; //agregara el metodo agregar y modificar, 2 en uno.
	}
	
	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		personaService.guardar(persona);
		return "redirect:/"; //REDIRECCIONA A LA PAGINA DE INICIO
	}
	
	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) { //Spring va a recibir el objeto persona, si ya existe lo va a inyectar, sino lo va a crear, y el valor de idPersona lo inyectara de forma automatica..
		persona = personaService.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "modificar";
	}
	
//	@GetMapping("/eliminar/{idPersona}")
//	public String eliminar(Persona persona) {
//		personaService.eliminar(persona);
//		return "redirect:/";
//	}
	
	//EJEMPLO 2 CON QUERY PARAMETER
	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";
	}

}
