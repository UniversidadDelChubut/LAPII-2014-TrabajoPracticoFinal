package registroasistencias;
class Asistencia{
	
	private int id;
    private Alumno alumno;
    private Clase clase;
    private boolean presente;
    private boolean justificado;
    
    Asistencia (int id, Clase clase, Alumno alumno, boolean presente, boolean justificado){
	 this.id = id;
	 this.clase = clase;	
	 this.presente = presente;
	 this.justificado = justificado;
	}
    
    public int getID(){ 
      return this.id;
    }
	
}
