package cl.com.universidadspring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.com.universidadspring.dominio.Persona;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InicioController {
	
	@Value("${index.saludo}")
	private String saludo;
	
	@GetMapping("/")
	public String inicio(Model model) {
		
		//Con spring se trabaja con un concepto llamado de inyeccion de dependencias
		//como la anotación @Controller está dentro de la fábrica de Spring
		//dentro de los controles del tipo Mapping podemos recibir diferentes parámetros asociadas a esa fabrica
		//como el objeto Model, de forma automatica. No es necesario instanciar estas clases ya que las instancia de forma automatica.
		
		var mensaje = "Hola Mundo con Thymeleaf";
		var persona = new Persona();
		
		persona.setNombre("Esteban");
		persona.setApellido("Peralta");
		persona.setEmail("correo@correo.cl");
		persona.setTelefono("55443322");
		
		var persona2 = new Persona();
		
		persona2.setNombre("Vicky");
		persona2.setApellido("Peralta");
		persona2.setEmail("correo@correo.com");
		persona2.setTelefono("1122334455");
		
		var personas = Arrays.asList(persona, persona2);
		//var personas = new ArrayList<Persona>();
		
		
		
		log.info("ejecutando el controlador Spring MVC");
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("saludo", saludo);
		model.addAttribute("persona", persona);
		model.addAttribute("personas", personas);
		
		return "index";
	}

}
