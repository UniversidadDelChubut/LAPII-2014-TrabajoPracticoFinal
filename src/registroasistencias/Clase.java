package registroasistencias;

import java.util.Date;
import java.util.List;



class Clase{
 
 private int id; 
 private boolean obligatoria;
 private Date fechaInicio;
 private Date fechaFin;
 private Date horaInicio;
 private Date horaFin;
 private String aula;
 private boolean dictada;
 private Clase claseQueRecuperar;
 private Comision comision;
 private Profesor profesor;
 private Date horaInicioProfesor;
 private Date horaSalidaProfesor;
 private List<String> temas;
 private List<Asistencia> asistencia;
 
    Clase(int id, Date fechaInicio, Date fechaFin, boolean dictada, Comision comision, Profesor profesor){
	   this.id = id;
	   this.fechaInicio = fechaInicio;
	   this.fechaFin = fechaFin;
	   this.dictada = dictada;
	   this.comision = comision;
	   this.profesor = profesor;
	}
	
	public void setHoraInicio(Date horaInicio){
	   this.horaInicio = horaInicio;
	}
	
	public void setHoraFin(Date horaFin){
	   this.horaFin = horaFin;
	}
     
    public void  setHoraInicioProfesor (Date horaInicioProfesor){
       this.horaInicioProfesor = horaInicioProfesor;
    }
    
    public void setHoraSalidaProfesor (Date horaSalidaProfesor){
       this.horaSalidaProfesor = horaSalidaProfesor;
    }	
    
    public void setClaseQueRecuperar (Clase claseQueRecuperar){
       this.claseQueRecuperar = claseQueRecuperar;
    }
    
    public Date getHoraInicio (){
	   return this.horaInicio;
	}
	
	public Date getHoraFin(){
	   return this.horaFin;
	}
     
    public Date getHoraInicioProfesor (){
       return this.horaInicioProfesor;
    }
    
    public Date getHoraSalidaProfesor (){
       return this.horaSalidaProfesor;
    }	
    
    public Profesor getProfesor(){
        return this.profesor;
    }
    
    public Comision getComision(){
        return this.comision;
    }
    
    	
}

