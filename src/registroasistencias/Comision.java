package registroasistencias;

import java.util.LinkedList;

public class Comision {

	private Cursada cursada;
	private int numero;
	private List <Alumno> alumnos = new LinkedList<Alumno>(); 
	private List <Clase> clases = new LinkedList<Clase>();

	
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
	

	public void agregarAlumno(Alumno alumno){ 
	   
	    if (alumnos.size() <= 30){
	    	alumnos.add(alumno);
	    }
	    
	    else{
		 System.out.print("Comision llena !!!");
	    }
		
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursada == null) ? 0 : cursada.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		if (cursada == null) {
			if (other.cursada != null)
				return false;
		} else if (!cursada.equals(other.cursada))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
}
