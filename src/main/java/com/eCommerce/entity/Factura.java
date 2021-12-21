package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFactura;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String FK_Factura;

	private double total;

	//bi-directional many-to-one association to Carrito
	@OneToMany(mappedBy="factura")
	private List<Carrito> carritos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="FK_Usuario")
	private Usuario usuario;

	public Factura() {
	}

	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFK_Factura() {
		return this.FK_Factura;
	}

	public void setFK_Factura(String FK_Factura) {
		this.FK_Factura = FK_Factura;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public Carrito addCarrito(Carrito carrito) {
		getCarritos().add(carrito);
		carrito.setFactura(this);

		return carrito;
	}

	public Carrito removeCarrito(Carrito carrito) {
		getCarritos().remove(carrito);
		carrito.setFactura(null);

		return carrito;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}