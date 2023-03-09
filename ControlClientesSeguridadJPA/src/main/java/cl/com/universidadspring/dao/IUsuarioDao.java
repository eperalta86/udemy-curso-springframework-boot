package cl.com.universidadspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.com.universidadspring.domain.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);
}
