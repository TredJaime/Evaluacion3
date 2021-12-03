package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Categoria;
import com.nttdata.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	public void insertarCategoria(@Valid Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}

	public List<Categoria> obtenerListaCategoria() {
		return (List<Categoria>) categoriaRepository.findAll();
	}
}
