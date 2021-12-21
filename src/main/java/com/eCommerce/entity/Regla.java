package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reglas database table.
 * 
 */
@Entity
@Table(name="reglas")
@NamedQueries({ @NamedQuery(name = "Regla.findAll", query = "SELECT r FROM Regla r"),
@NamedQuery(name = "Regla.findAllToDay", query = "SELECT r FROM Regla r WHERE r.fechaFin>=:fechaActual")
})
public class Regla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idReglas;

	private boolean estado;

	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	private Date fechaIni;

	private String nombre;

	private double tax_Precio;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="FK_Categoria2")
	private Categoria categoria;

	//bi-directional many-to-one association to Descuento
	@ManyToOne
	@JoinColumn(name="FK_Descuento")
	private Descuento descuento;

	public Regla() {
	}

	public int getIdReglas() {
		return this.idReglas;
	}

	public void setIdReglas(int idReglas) {
		this.idReglas = idReglas;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIni() {
		return this.fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTax_Precio() {
		return this.tax_Precio;
	}

	public void setTax_Precio(double tax_Precio) {
		this.tax_Precio = tax_Precio;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Descuento getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

}