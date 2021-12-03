package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity//representacion de la entidad modelo
@Table(name="usuarios")//nombre de la tabla en la bbdd
public class Usuario {
	
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	
	@NotNull(message = "Campo nombre no puedo estar vacio")
    @Size(min = 1, max = 10, message = "Debe tener entre 1 y 10 caracteres")
	private String nombre;
	
	@NotNull(message = "Campo nombre no puedo estar vacio")
    @Size(min = 1, max = 10, message = "Debe tener entre 1 y 10 caracteres")
	private String apellido;
	
	@NotNull(message = "La edad no puede estar vacía")
	private Integer edad;
	private String rut;
	private String email;
	private String password;
	@Transient
	private String passwordConfirmation;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="roles_usuarios",//tabla intermedia
		joinColumns = @JoinColumn(name="usuario_id"),
		inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Role> roles;

	public Usuario() {
		super();
	}

	public Usuario(
			@NotNull(message = "Campo nombre no puedo estar vacio") @Size(min = 1, max = 10, message = "Debe tener entre 1 y 10 caracteres") String nombre,
			@NotNull(message = "Campo nombre no puedo estar vacio") @Size(min = 1, max = 10, message = "Debe tener entre 1 y 10 caracteres") String apellido,
			Integer edad, String rut, String email, String password, String passwordConfirmation, List<Role> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.rut = rut;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.roles = roles;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	
	
	

}
