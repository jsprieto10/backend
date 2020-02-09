package com.valid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1000)
public class Usuario {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int id;
	
	@Column(length = 30)
	private String nombre;
	
	@Column(length = 30)
	private String apellido;
	
	@Column
	private boolean procesado;
	
	public Usuario() 
	{
		
	}
	
	public Usuario(String pNombre, String pApellido)
	{
		nombre=pNombre;
		apellido = pApellido;
		procesado = false;
	}
	

	public int getId(){
		return id;
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

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}
	
	
}
