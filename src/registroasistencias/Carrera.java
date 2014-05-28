package registroasistencias;

import java.util.List;


/**
 * Represnta una carrera de la Universidad
 * 
 * @author santiago
 *
 */
public class Carrera {

	private String id;
	private String nombre;
	private List<Materia> materia;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carrera(String id, String nombre){
		
		this.id=id;
		this.nombre=nombre;
		
	}
}
