package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Producto;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String producto(@ModelAttribute("producto") Producto producto, 
			Model model) {
		
		model.addAttribute("listaCategoria", categoriaService.obtenerListaCategoria());
		model.addAttribute("listaProducto", productoService.obtenerListaProducto());
		
		return "tienda/tienda.jsp";
	}
	
	
	
	
}
