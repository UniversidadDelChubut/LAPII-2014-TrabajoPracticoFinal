package registroasistencias;

import java.util.Date;

public class ProfesorComision {

	private Profesor profesor;
	private Comision comision;
	private Date desde;
	private Date hasta;
	
	public ProfesorComision(Profesor profesor, Comision comision, Date desde, Date hasta){
		this.comision=comision;
		this.desde=desde;
		this.hasta=hasta;
		this.profesor=profesor;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public Comision getComision() {
		return comision;
	}

	public Date getDesde() {
		return desde;
	}

	public Date getHasta() {
		return hasta;
	}

}
