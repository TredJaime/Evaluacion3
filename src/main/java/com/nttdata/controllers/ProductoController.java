package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Producto;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	
	@RequestMapping("")
	public String producto(@ModelAttribute("producto") Producto producto, 
			Model model) {
		
		model.addAttribute("listaCategoria", categoriaService.obtenerListaCategoria());
		model.addAttribute("listaProducto", productoService.obtenerListaProducto());
		
		return "producto/producto.jsp";
	}
	
	@RequestMapping("/loginP")
	public String loginP(@Valid @ModelAttribute("Producto") Producto producto) {
		System.out.println(producto.getNombre() + " " + producto.getValor() + " " + producto.getDescripcion());
		
		productoService.insertarProducto(producto);
		
		return "redirect:/producto";
	}
}
