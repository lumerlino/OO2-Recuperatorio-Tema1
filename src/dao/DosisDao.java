package dao;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dosis;
import datos.Vacuna;

public class DosisDao {
	private static Session session;
	private Transaction tx;
	private static DosisDao instancia=null;
	
	protected DosisDao() {}
	
	public static DosisDao getInstance() {
		if(instancia==null) {
			instancia=new DosisDao();
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
	public List<Dosis> traerDosis (Vacuna vacuna) throws HibernateException{
		List<Dosis> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Dosis d inner join fetch d.persona p inner join fetch d.vacuna v where v.codigo=" + vacuna.getCodigo();
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta) throws HibernateException{
		List<Dosis> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Dosis d inner join fetch d.persona p inner join fetch d.vacuna v "
					+ "where d.hora >='"+ horaDesde + "' and d.hora <= '"+ horaHasta+"'";
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta, boolean tieneComorbilidades) throws HibernateException{
		List<Dosis> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Dosis d inner join fetch d.persona p inner join fetch d.vacuna v "
					+ "where d.hora >='"+ horaDesde + "' and d.hora <= '"+ horaHasta+"' and p.tieneComorbilidad="+tieneComorbilidades;
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}

}
