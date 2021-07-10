package negocio;

import dao.VacunaDao;
import datos.Vacuna;

public class VacunaABM {
	private static VacunaABM instancia = null;
	
	protected VacunaABM () {}
	
	public static VacunaABM getInstance() {
		if(instancia==null) {
			instancia=new VacunaABM();
		}
		return instancia;
	}
	
	public Vacuna traerVacuna(long codigo) {
		return VacunaDao.getInstance().traerVacuna(codigo);
	}

}
