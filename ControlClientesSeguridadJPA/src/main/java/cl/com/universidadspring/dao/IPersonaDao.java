package cl.com.universidadspring.dao;

import org.springframework.data.repository.CrudRepository;

import cl.com.universidadspring.domain.Persona;

//Ya no se utiliza @Repository, se implementa interfaz CrudRepository pasandole la clase y la llave primaria
//Tampoco es necesario crear una implementación para esta clase ya que Spring Boot crea una implementación por defecto
public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
