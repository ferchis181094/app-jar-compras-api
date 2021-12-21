package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the descuento database table.
 * 
 */
@Entity
@NamedQuery(name="Descuento.findAll", query="SELECT d FROM Descuento d")
public class Descuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDescuento;

	private byte estado;

	private String nombre;

	private double precio;

	//bi-directional many-to-one association to Regla
	@OneToMany(mappedBy="descuento")
	private List<Regla> reglas;

	public Descuento() {
	}

	public int getIdDescuento() {
		return this.idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Regla> getReglas() {
		return this.reglas;
	}

	public void setReglas(List<Regla> reglas) {
		this.reglas = reglas;
	}

	public Regla addRegla(Regla regla) {
		getReglas().add(regla);
		regla.setDescuento(this);

		return regla;
	}

	public Regla removeRegla(Regla regla) {
		getReglas().remove(regla);
		regla.setDescuento(null);

		return regla;
	}

}