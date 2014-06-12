package registroasistencias;

public class Materia {
	
	public static final String PRIMER_CUARIMESTRE = "1C";
	public static final String SEGUNDO_CUARIMESTRE = "2C";
	public static final String ANUAL = "A";
	
	
	private int numero;
	private String cuatrimestre;
	private String nombre;
	private int anio;
	private Carrera carrera;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	

	public Materia(int numero, String cuatrimestre, String nombre, int anio, Carrera carrera){
		
		this.numero= 0;
		this.cuatrimestre=cuatrimestre;
		this.nombre= nombre;
		this.anio= anio;
		this.carrera= carrera;
	}
}
