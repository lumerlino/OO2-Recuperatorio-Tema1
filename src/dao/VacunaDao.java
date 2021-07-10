package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Vacuna;

public class VacunaDao {
	private static Session session;
	private Transaction tx;
	private static VacunaDao instancia=null;
	
	protected VacunaDao() {}
	
	public static VacunaDao getInstance() {
		if(instancia==null) {
			instancia=new VacunaDao();
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
	
	public Vacuna traerVacuna (long codigo) throws HibernateException{
		Vacuna objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Vacuna v where v.codigo="+codigo;
			objeto = (Vacuna) session.createQuery(hql).uniqueResult();  
		}finally {
			session.close();
		}
		return objeto;

	}

}
