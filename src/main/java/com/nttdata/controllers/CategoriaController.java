package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Categoria;
import com.nttdata.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String categoria(@ModelAttribute ("Categoria") Categoria categoria,
		Model model){
		
		model.addAttribute("listaCategoria", categoriaService.obtenerListaCategoria());
		
		return "producto/categoria.jsp";
	}
	
	@RequestMapping("/crearCa")
	public String loginP(@Valid @ModelAttribute("Categoria") Categoria categoria) {
		System.out.println(categoria.getNombre() + " " + categoria.getDescripcion());
		
		categoriaService.insertarCategoria(categoria);
		
		return "redirect:/categoria";
	}
}
