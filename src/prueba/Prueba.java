package prueba;

import registroasistencias.Carrera;
import registroasistencias.Materia;

public class Prueba {

	
	public static void main(String[] args) {
		
		for (Carrera carrera: Carrera.getCarreras()){
			System.out.println(carrera.getNombre());
			for(Materia materia: carrera.getMaterias() ){
				System.out.println("    " + materia.getNombre());
			}
		}
	}
}
