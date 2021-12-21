package com.eCommerce.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;

import com.eCommerce.entity.Descuento;
import com.eCommerce.entity.Regla;
import com.eCommerce.entity.Usuario;


@SuppressWarnings("finally")
public class ReglasController extends Connection {
	private TypedQuery<Regla> query;
	private Regla regla;
	private Descuento descuento;

	@Override
	public List<Regla> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Regla.findAll", Regla.class);
			return query.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			this.stopEntityManagerFactory();

		}
		return null;
	}
	public List<Regla> getAllToDayActive() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Regla.findAllToDay", Regla.class);
			this.query.setParameter("fechaActual", new Date());
			return query.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			this.stopEntityManagerFactory();
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReglasController().getAllToDayActive().size());
	}

	
	@Override
	public Object selectRegister(String id) {
		try {
			this.startEntityManagerFactory();
			this.regla = this.getEm().createNamedQuery("Regla.findOne", Regla.class).setParameter("param", id)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.regla;
		}

	}
	
	
	

	@Override
	public void update(Object o) {
		if (o instanceof Regla) {
			try {
				this.startEntityManagerFactory();

				this.getEm().getTransaction().begin();
				this.getEm().merge(o);
				this.getEm().getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.stopEntityManagerFactory();
			}
		} else
			System.out.print("Trying to use an invalid object, error.");
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Object o) {
		if (o instanceof Regla) {
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
