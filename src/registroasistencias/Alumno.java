package registroasistencias;
import java.util.Date;

import registroasistencias.Persona;

/**
 * La clase Alumno
 * @author lapii2014
 *
 */

public final class Alumno extends Persona {

	private long legajo;
	private float porcentajeAsistencia;
	
	public Alumno(long legajo, String apellido, String nombre, String calle,int alturaCalle, Date nacimiento, long dni){
		super(nombre, apellido, calle, alturaCalle, nacimiento, dni);
		this.legajo=legajo;
	}

	public long getLegajo(){		
		return this.legajo;
		
		
	}
	
	public void getPorcentajeAsistencia(Comision comision){
		this.porcentajeAsistencia= comision.getClases().
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (legajo ^ (legajo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		if (legajo != other.legajo)
			return false;
		return true;
	}
	
	
	
	
	
}
