package cl.com.universidadspring.dao;

import org.springframework.data.repository.CrudRepository;

import cl.com.universidadspring.domain.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
