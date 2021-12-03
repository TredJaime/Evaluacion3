package com.nttdata.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;



@Controller
public class HomeController {
	

	
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
		public String home(HttpSession session, Model model) {
			
			return "home.jsp";
		}

}
