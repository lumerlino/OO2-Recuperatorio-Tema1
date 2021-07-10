package negocio;

import java.time.LocalTime;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Vacuna;

public class DosisABM {
	private static DosisABM instancia = null;
	
	protected DosisABM () {}
	
	public static DosisABM getInstance() {
		if(instancia==null) {
			instancia=new DosisABM();
		}
		return instancia;
	}
	
	public List<Dosis> traerDosis(Vacuna vacuna){
		return DosisDao.getInstance().traerDosis(vacuna);
	}
	
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta){
		return DosisDao.getInstance().traerDosis(horaDesde, horaHasta);
	}
	
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta, boolean tieneComorbilidades){
		return DosisDao.getInstance().traerDosis(horaDesde, horaHasta, tieneComorbilidades);
	}

}
