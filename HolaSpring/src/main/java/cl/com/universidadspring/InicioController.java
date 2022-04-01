package cl.com.universidadspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InicioController {
	
	@GetMapping("/")
	public String inicio() {
		log.info("ESCRIBO LOGGING");
		log.debug("Escribo debug");
		return "Hola Mundo con Spring";
	}

}
