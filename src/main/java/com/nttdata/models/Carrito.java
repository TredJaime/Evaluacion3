package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity//representacion de la entidad modelo
@Table(name="carritos")//nombre de la tabla en la bbdd
public class Carrito {
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	
	private Integer cantidad;
	
	@OneToMany(mappedBy ="carrito",fetch = FetchType.LAZY)
	private List<Producto> productos;

	public Carrito() {
		super();
	}

	public Carrito(Integer cantidad, List<Producto> productos) {
		super();
		this.cantidad = cantidad;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
