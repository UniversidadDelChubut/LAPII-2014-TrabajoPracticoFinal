package registroasistencias;

import java.util.List;

public class Comision {

	private Cursada cursada;
	private int numero;
	private List <Alumno> alumnos= null;
	private List <Clase> clases=null;
	
	public Comision(Cursada cursada, int numero){
		this.cursada=cursada;
		this.numero=numero;
	}

	public Cursada getCursada() {
		return cursada;
	}

	public int getNumero() {
		return numero;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public List<Clase> getClases() {
		return clases;
	}
	
	
}
