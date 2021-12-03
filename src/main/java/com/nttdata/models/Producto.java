package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity//representacion de la entidad modelo
@Table(name="productos")//nombre de la tabla en la bbdd
public class Producto {
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	private String nombre;
	private Integer valor;
	private String descripcion;
	
	
	//relacion muchos a uno/ muchos productos pueden tener una categoria
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="categoria_id")
		private Categoria categoria;
	
	
	
	public Producto() {
		super();
	}


	public Producto(String nombre, Integer valor, String descripcion) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.descripcion = descripcion;
	}

	
	

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", valor=" + valor + ", descripcion=" + descripcion + "]";
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
}
