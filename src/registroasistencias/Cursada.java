package registroasistencias;
import java.util.Date;

public class Cursada {
	
	private Materia materia;
	private int anio;
	private Date fechaInicio;
	private Date fech_final;
	private String cuatrimestre;
	private double porc_asistencia;
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Date getFech_inicio() {
		return fechaInicio;
	}
	public void setFech_inicio(Date fech_inicio) {
		this.fechaInicio = fech_inicio;
	}
	public Date getFech_final() {
		return fech_final;
	}
	public void setFech_final(Date fech_final) {
		this.fech_final = fech_final;
	}
	public String getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	public double getPorc_asistencia() {
		return porc_asistencia;
	}
	public void setPorc_asistencia(double porc_asistencia) {
		this.porc_asistencia = porc_asistencia;
	}
	

	public Cursada(Materia materia, int anio, Date fech_inicio, Date fech_final, 
					String cuatrimestre, double porc_asistencia){
		
		this.materia=materia;
		this.anio=anio;
		this.fechaInicio= fech_inicio;
		this.fech_final=fech_final; 
		this.cuatrimestre=cuatrimestre;
		this.porc_asistencia=porc_asistencia;
		
	}
}
