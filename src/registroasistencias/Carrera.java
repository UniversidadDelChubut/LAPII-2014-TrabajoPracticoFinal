package registroasistencias;

import java.util.LinkedList;
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
	private List<Materia> materias;
	
	
	public static List <Carrera> getCarreras(){
		return DataProvider.getDataProvider().getCarreras();
	}
	
	public List<Materia> getMaterias() {
		if (this.materias != null) {
			return materias;
		}
		
		this.materias = new LinkedList<Materia>();
		DataProvider dp = DataProvider.getDataProvider();
		
		for (Materia materia: dp.getMaterias() ){
			if (materia.getCarrera().equals(this)){
				this.materias.add(materia);
			}
		}
		return materias;

	}

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
