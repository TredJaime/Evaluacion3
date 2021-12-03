package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.repositories.ProductoRepostiry;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepostiry productoRepository;
	
	
	public void insertarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
		
	}
	
public List<Producto> obtenerListaProducto() {
		
		return  (List<Producto>) productoRepository.findAll();
	}


public Producto BuscarProducto(Long id) {
	return productoRepository.findById(id).get();
}


public void eliminarProductoObjeto(Producto producto) {
	productoRepository.delete(producto);
	
}


public void updateProducto(@Valid Producto producto) {
	if(productoRepository.existsById(producto.getId())) {
		productoRepository.save(producto);
	}	
}

}
