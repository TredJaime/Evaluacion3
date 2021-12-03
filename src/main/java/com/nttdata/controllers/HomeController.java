package com.nttdata.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;



@Controller
public class HomeController {
	
	@Autowired
	UsuarioService usuarioService;

	
	@RequestMapping("")
	//http://localhost:8080/
	// metodo inicial
	public String index() {

		return "index.jsp";
	}

	//http://localhost:8080/login
	@RequestMapping("/login")
	public String login() {

		return "usuario/login.jsp";
	}
	
	
	//http://localhost:8080/registro
		@RequestMapping("/registro")
		public String registro(@ModelAttribute("usuario") Usuario usuario) {

			return "usuario/registro.jsp";
		}

	
		@RequestMapping("/home")
		public String home(HttpSession session, Model model, Usuario usario) {
			//obteniendo las variabes de session
			String nombre = (String) session.getAttribute("nombre");
			Long id= (Long) session.getAttribute("id");
			
			model.addAttribute("nombre", nombre);
			model.addAttribute("id", id);
			return "home.jsp";
		}
	
}
