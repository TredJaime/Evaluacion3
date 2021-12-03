package com.nttdata.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	//desplegar inicialmente el jsp
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		
		
		
		return "usuario/usuario.jsp";
	}
		
		
		
		/*http://localhost:8080/usuario/registrarjsp */
		@RequestMapping("/registrarjsp")
		public String registrarjsp(@ModelAttribute("usuario") Usuario usuario) {

			return "usuario/registro.jsp";
		}
	
		@RequestMapping(value = "/registrar", method = RequestMethod.POST)
		public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult)
		{
			System.out.println("Before: bindingResult.hasErrors()");
			
			if (bindingResult.hasErrors()) {
	              System.out.println("After: bindingResult.hasErrors()");
	              
	              return "usuario/registro.jsp";
	               
			  }
		
			  usuarioService.persistirUsuarioRol(usuario);
			  return "redirect:/home";
		}
		
		/*
		http://localhost:8080/usuario/login
		*/
		//capturar la informacion del formulario
		@RequestMapping("/login")
		public String login(Principal principal, Model model,HttpSession session) {
			String nombre = principal.getName();
			
			Usuario usuario= usuarioService.findByNombre(nombre);
			model.addAttribute("nombre_usuario", usuario.getNombre());
			
			return "home.jsp";
		}
		
		
		
		@RequestMapping("/logout")
		public String myLogoff(HttpServletRequest request, HttpServletResponse response) {
		    CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
		    SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
		    cookieClearingLogoutHandler.logout(request, response, null);
		    securityContextLogoutHandler.logout(request, response, null);
		    
		    return "redirect:/login";
		   
		}
		
		
		
		@RequestMapping("/eliminar")
		public String eliminarUsuario(@RequestParam("id") Long id) {
			
			Usuario usuario = usuarioService.buscarUsuarioId(id);
			
			if(usuario !=null) {
				usuarioService.eliminarUsuarioObjeto(usuario);
			}
			
			return "redirect:/usuario";
		}
		

		@RequestMapping("/{id}/editar")
	    public String edit(@PathVariable("id") Long id, Model model) {
	    	System.out.println("editar");
	    	Usuario usuario = usuarioService.buscarUsuarioId(id);
	    	if(usuario !=null) {
	  
			    model.addAttribute("usuario", usuario);
			    return "/usuario/editar.jsp";
			}
			
			return "redirect:/usuario";
	    }
	    
	    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
	    	System.out.println("Update");
	    	usuarioService.updateUsuario(usuario);
            return "redirect:/usuario";
	    	
	    }
			
}
