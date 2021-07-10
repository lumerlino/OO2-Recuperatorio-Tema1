package test;

import java.time.LocalTime;

import negocio.DosisABM;
import negocio.PersonaABM;
import negocio.VacunaABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1)");
		long codigo = 800009;
		System.out.println(VacunaABM.getInstance().traerVacuna(codigo));
		
		System.out.println("2)");
		System.out.println(PersonaABM.getInstance().traerPersona(25, 35));
		
		System.out.println("3)");
		System.out.println(DosisABM.getInstance().traerDosis(VacunaABM.getInstance().traerVacuna(codigo)));
		
		System.out.println("4)");
		System.out.println(DosisABM.getInstance().traerDosis(LocalTime.of(10, 0), LocalTime.of(11, 30)));
		
		System.out.println("5)");
		System.out.println(DosisABM.getInstance().traerDosis(LocalTime.of(10, 0), LocalTime.of(11, 30), true));

	}

}
