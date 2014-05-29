package registroasistencias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DataProvider {
	
	private static DataProvider dataProvider;

	static {
		
		try {
			dataProvider = new DataProvider();
		} catch (RegistroAsistenciaException e) {
			e.printStackTrace();
		}
		
	}
	
	private List<Materia> materias = new LinkedList<Materia>();
	private List<Carrera> carreras = new LinkedList<Carrera>();
	private List<Cursada> cursadas = new LinkedList<Cursada>();
	
	public static DataProvider getDataProvider(){
		return DataProvider.dataProvider;
	}
	
	private DataProvider() throws RegistroAsistenciaException {
	
		Carrera sfw = new Carrera("SFW", "Software");
		carreras.add(sfw);
		
		Carrera enf = new Carrera("ENF", "Enfermeria");
		carreras.add(enf);
		
		Carrera red = new Carrera("RED", "Redes");
		carreras.add(red);
		
		Materia m;
		m = new Materia(10, Materia.PRIMER_CUARIMESTRE, "Bases de Datos I", 2, sfw);
		materias.add(m);
		
		m = new Materia(7, Materia.SEGUNDO_CUARIMESTRE, "Laboratorio de Programación", 1, sfw);
		materias.add(m);
		
		m = new Materia(11, Materia.PRIMER_CUARIMESTRE, "Laboratorio Avanzado de Programación", 2, sfw);
		materias.add(m);
		
		
		m = new Materia(10, Materia.PRIMER_CUARIMESTRE, "Sistemas Operativos I", 1, red);
		materias.add(m);
		
		m = new Materia(6, Materia.SEGUNDO_CUARIMESTRE, "Matematica I", 1, red);
		materias.add(m);
		
		m = new Materia(9, Materia.ANUAL, "Fisica", 1, red);
		materias.add(m);
		
		
		for (Materia materia: this.materias){
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			
			for (int anio = 2013; anio <= 2014; anio++ ) {
				Date fechaInicio = null;
				Date fechaFin    = null;
				
				try {
					
					if (
							materia.getCuatrimestre().equals(Materia.PRIMER_CUARIMESTRE) ||
							materia.getCuatrimestre().equals(Materia.ANUAL) 
						)
					{ 
						fechaInicio = sdf.parse("01/03/" +  anio);
					} else {
						fechaInicio = sdf.parse("01/07/" +  anio);
					}
					
					if (
							materia.getCuatrimestre().equals(Materia.PRIMER_CUARIMESTRE)  
						)
					{ 
						fechaFin = sdf.parse("30/06/" +  anio);
					} else {
						fechaFin = sdf.parse("30/11/" +  anio);
					}
									
					
					
				} catch (ParseException ex) {					
					throw new RegistroAsistenciaException("Error al crear el data provider", ex);
					
				}
				
				Cursada c = new Cursada(materia, anio, fechaInicio, fechaFin, m.getCuatrimestre(), 0.8);
				this.cursadas.add(c);
			}
		}
		
		
	}
	
	public List<Carrera> getCarreras() {
		return carreras;
	}
	
	public List<Materia> getMaterias() {
		return materias;
	}
	
	public List<Cursada> getCursadas() {
		return cursadas;
	}
	
}
