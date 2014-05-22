package registroasistencias;
import java.util.Date;
import registroasistencias.Persona;

public final class Alumno extends Persona {

	private long legajo;
	
	public Alumno(long legajo, String apellido, String nombre, String calle,int alturaCalle, Date nacimiento, long dni){
		super(nombre, apellido, calle, alturaCalle, nacimiento, dni);
		this.legajo=legajo;
	}

	public long getLegajo(){		
		return this.legajo;
		
		
	}
	
	
	
	
	
}
