package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia=null;
	
	protected PersonaDao() {}
	
	public static PersonaDao getInstance() {
		if(instancia==null) {
			instancia=new PersonaDao();
		}
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException { 
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	protected void manejaExcepcion(HibernateException he) throws HibernateException { 
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> traerPersona() throws HibernateException{
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Persona p ").list(); 
		} finally {
			session.close();
		}
		return lista;

	}
	

}
