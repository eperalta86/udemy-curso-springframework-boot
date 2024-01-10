package cl.com.universidadspring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.com.universidadspring.dao.IUsuarioDao;
import cl.com.universidadspring.domain.Rol;
import cl.com.universidadspring.domain.Usuario;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		
		var roles = new ArrayList<GrantedAuthority>();
		
		for(Rol rol: usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), roles);
	}

}
