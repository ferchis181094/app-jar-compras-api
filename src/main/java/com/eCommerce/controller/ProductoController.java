package com.eCommerce.controller;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.sql.Select;

import com.eCommerce.entity.Producto;
import com.eCommerce.entity.Usuario;

@SuppressWarnings("finally")
public class ProductoController extends Connection {

	private TypedQuery<Producto> query;
	private Producto producto;

	@Override
	public List<Producto> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Producto.findAll", Producto.class);
			return query.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			this.stopEntityManagerFactory();

		}
		return null;
	}

//	public static void main(String[] args) {
//		try {
//			Producto p=(Producto)new ProductoController().selectRegister("2");
//			System.out.println(p.getNombre());
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	@Override
	public Object selectRegister(String id) {
		try {
			this.startEntityManagerFactory();
			this.producto = this.getEm().createNamedQuery("Producto.findOne", Producto.class)
					.setParameter("idProductos", Integer.valueOf(id)).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.producto;
		}

	}


	@Override
	public void update(Object o) {
		if (o instanceof Producto) {
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
		if (o instanceof Producto) {
			try {
				this.startEntityManagerFactory();

				this.getEm().getTransaction().begin();
				this.getEm().remove(this.getEm().contains(o) ? o : this.getEm().merge(o));
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
	public void insert(Object o) {
		if (o instanceof Producto) {
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
