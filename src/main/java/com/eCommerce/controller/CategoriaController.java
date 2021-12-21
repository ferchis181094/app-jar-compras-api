package com.eCommerce.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import com.eCommerce.entity.Categoria;
import com.eCommerce.entity.Regla;
import com.eCommerce.entity.Usuario;

public class CategoriaController extends Connection {
	private TypedQuery<Categoria> query;
	private Categoria Categoria;

	@Override
	public List<Categoria> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Categoria.findAll", Categoria.class);
			return query.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			this.stopEntityManagerFactory();

		}
		return null;
	}

	@Override
	public Object selectRegister(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub

	}

}
