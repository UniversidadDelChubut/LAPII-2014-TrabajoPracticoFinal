package registroasistencias;
import java.util.Date;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected String calle;
	protected int alturaCalle;
	protected Date fechaNacimiento;
	
	protected Persona (String nombre, String apellido, String calle, int alturaCalle,Date nacimiento, long dni){
		this.alturaCalle= alturaCalle;
		this.apellido= apellido;
		this.calle= calle;
		this.nombre= nombre;
		this.dni=dni;
		this.fechaNacimiento=nacimiento;
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getApellido() {
		return apellido;
	}

	protected long getDni() {
		return dni;
	}

	protected String getCalle() {
		return calle;
	}

	protected int getAlturaCalle() {
		return alturaCalle;
	}

	protected Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	
	
}
