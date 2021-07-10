package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {
	private static PersonaABM instancia = null;
	
	protected PersonaABM () {}
	
	public static PersonaABM getInstance() {
		if(instancia==null) {
			instancia=new PersonaABM();
		}
		return instancia;
	}
	
	public List<Persona> traerPersona(){
		return PersonaDao.getInstance().traerPersona();
	}
	
	public List<Persona> traerPersona(int edadDesde, int edadHasta){
		List<Persona> personas = traerPersona();
		List<Persona> lista = new ArrayList<Persona>();
		for (Persona p : personas) {
			if (p.calcularEdad(LocalDate.now()) >= edadDesde && p.calcularEdad(LocalDate.now()) <= edadHasta) {
				lista.add(p);				
			}
		}
		return lista;		
	}

}
