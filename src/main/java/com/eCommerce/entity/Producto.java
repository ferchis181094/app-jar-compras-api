package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQueries({ @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
@NamedQuery(name = "Producto.findOne", query = "SELECT p FROM Producto p WHERE p.idProductos = :idProductos")

})
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProductos;

	private int cantidad;

	private String detalle;

	private String nombre;

	private double precio;

	//bi-directional many-to-one association to Carrito
	@OneToMany(mappedBy="producto")
	private List<Carrito> carritos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="FK_Categoria")
	private Categoria categoria;

	public Producto() {
	}

	public int getIdProductos() {
		return this.idProductos;
	}

	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	public List<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public Carrito addCarrito(Carrito carrito) {
		getCarritos().add(carrito);
		carrito.setProducto(this);

		return carrito;
	}

	public Carrito removeCarrito(Carrito carrito) {
		getCarritos().remove(carrito);
		carrito.setProducto(null);

		return carrito;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}