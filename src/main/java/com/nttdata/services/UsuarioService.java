package com.nttdata.services;



import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
		
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bcpe;
	
	
	public Usuario persistirUsuarioRol(Usuario usuario) {
		
		usuario.setPassword(bcpe.encode(usuario.getPassword()));
		usuario.setRoles(roleService.findByNombre("ROLE_USER"));
		return usuarioRepository.save(usuario);
	}
	
	
	public Usuario registroUsuario(Usuario usuario) {

		//hashear el password
		String password_hashed= BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		//sobre escribir la password
		usuario.setPassword(password_hashed);
		
		return usuarioRepository.save(usuario);
	}
	
	
public boolean loginUsuario(String email, String password) {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario == null) {
			return false;
		} else {
			//if(password.equals(usuario.getPassword())) {
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			}else {
				return false;
			}
		}	
	}
	
	
	//buscar por email
		public Usuario findByEmail(String email) {
			return usuarioRepository.findByEmail(email);
		}
		
		public Usuario findByNombre(String nombre) {
			return usuarioRepository.findByNombre(nombre);
		}
		
}
