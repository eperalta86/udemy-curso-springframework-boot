package cl.com.universidadspring.service;

import java.util.List;

import cl.com.universidadspring.dominio.Persona;

public interface IPersonaService {
	
	public List<Persona> listarPersonas();
	
	public void guardar(Persona persona);
	
	public void eliminar(Persona persona);
	
	public Persona encontrarPersona(Persona persona);

}
