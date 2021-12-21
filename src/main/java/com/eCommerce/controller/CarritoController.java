package com.eCommerce.controller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import com.eCommerce.entity.Carrito;

public class CarritoController extends Connection {

	ProductoController productoController=new ProductoController();	
	
	
	@Override
	public List<?> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectRegister(String id) {
		
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
		if (o instanceof Carrito) {
			try {
				this.startEntityManagerFactory();
				this.getEm().getTransaction().begin();
				this.getEm().persist(o);
				this.getEm().getTransaction().commit();

			} catch (PersistenceException e) {
				if (e.getCause() instanceof ConstraintViolationException) {
					ConstraintViolationException exception = (ConstraintViolationException) e.getCause();
					if (exception.getSQLException().getMessage().contains(" for key 'email'")) {
						System.out.println("this email is already register in our system.");

					} else {
						exception.printStackTrace();
					}
				} else {
					e.printStackTrace();

				}
				this.getEm().getTransaction().rollback();

			}
		}

	}

}
