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
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="carrito_id")
		private Carrito carrito;

		public Producto() {
			super();
		}

		public Producto(Long id, String nombre, Integer valor, String descripcion, Categoria categoria,
				Carrito carrito) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.valor = valor;
			this.descripcion = descripcion;
			this.categoria = categoria;
			this.carrito = carrito;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public Carrito getCarrito() {
			return carrito;
		}

		public void setCarrito(Carrito carrito) {
			this.carrito = carrito;
		}
	
	
	
	
	
}
