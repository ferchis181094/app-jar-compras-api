package com.eCommerce.tester;

import com.eCommerce.controller.ProductoController;
import com.eCommerce.entity.Producto;

public class TesterAndrew {

	public static void main(String[] args) {
		Producto producto = new Producto();
		ProductoController pc = new ProductoController();

		producto.setIdProductos(1);
		producto.setNombre("Vestido Rojo");
		producto.setDetalle("Novedoso plan de vestidos");
		producto.setPrecio(65.05);
		producto.setCantidad(120);
		try {
			pc.insert(producto);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
