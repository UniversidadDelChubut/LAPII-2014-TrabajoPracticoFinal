package registroasistencias;

import java.util.Date;

import registroasistencias.Persona;

public final class Profesor extends Persona{

	public Profesor(String nombre, String apellido, String calle, int alturaCalle,Date nacimiento, long dni) {
		super(nombre, apellido, calle, alturaCalle, nacimiento, dni);
	}

}
