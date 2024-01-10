package cl.com.universidadspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.com.universidadspring.dao.IPersonaDao;
import cl.com.universidadspring.domain.Persona;

//Las anotaciones como @Service sirven para que spring las reconosca dentro de su contenedor, haciendo valida la inyección de dependencias.

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDao personaDao;

	@Override
	@Transactional(readOnly = true) //readonly no participa de transacciones
	public List<Persona> listarPersonas() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional //transactional a secas si particia con transacciones a la BBDD (rollback y commit cuando es necesario)
	public void guardar(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(Persona persona) {
		personaDao.delete(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {
		return personaDao.findById(persona.getIdPersona()).orElse(null);
	}

}
