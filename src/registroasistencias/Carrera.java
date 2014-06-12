package registroasistencias;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 * Represnta una carrera de la Universidad
 * 
 * @author santiago
 *
 */
public class Carrera {

	private String codigo;
	private String nombre;
	private List<Materia> materias;
	
    public Carrera(String codigo, String nombre){
		
		this.codigo= codigo;
		this.nombre=nombre;
	}
	
	public Carrera(String codigo) throws ObjetoInexistenteException, ModelException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
				" SELECT codigo, nombre FROM carrera  WHERE codigo = ?");
			pstmt.setString(1, codigo);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				this.codigo = rs.getString("codigo");
				this.nombre = rs.getString("nombre");
			} else {
				throw new ObjetoInexistenteException("El codigo " + codigo + "no exite como carrera");
			}
		} catch (SQLException e) {
			throw new ModelException("Error de acceso a datos", e);
		} finally {
			DataSource.closeConnection(conn);
		}
	}
		
	
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

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/*************************** Acceso a la base de datos ********************************/

    public void update() throws ModelException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
              " UPDATE carrera nombre = ?  WHERE codigo = ?");
			pstmt.setString(2, this.nombre);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ModelException("Error de acceso a datos", e);
		} finally {
 			DataSource.closeConnection(conn);
		}
	}
    
   

	public void insert() throws ModelException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
			  " INSERT INTO vendedor (codigo, nombre) VALUES (?, ?)");
			pstmt.setString(1, this.codigo);
		    pstmt.setString(2, this.nombre);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ModelException("Error de acceso a datos", e);
		} finally {
 			DataSource.closeConnection(conn);
		}
	}

	 @Override
	 public int hashCode() {
	 	final int prime = 31;
	 	int result = 1;
	 	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	 	result = prime * result + ((materias == null) ? 0 : materias.hashCode());
	 	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	 	return result;
	 }

	 @Override
	 public boolean equals(Object obj) {
	 	if (this == obj)
	 		return true;
	 	if (obj == null)
	 		return false;
	 	if (getClass() != obj.getClass())
	 		return false;
	 	Carrera other = (Carrera) obj;
	 	if (codigo == null) {
	 		if (other.codigo != null)
	 			return false;
	 	} else if (!codigo.equals(other.codigo))
	 		return false;
	 	if (materias == null) {
	 		if (other.materias != null)
	 			return false;
	 	} else if (!materias.equals(other.materias))
	 		return false;
	 	if (nombre == null) {
	 		if (other.nombre != null)
	 			return false;
	 	} else if (!nombre.equals(other.nombre))
	 		return false;
	 	return true;
	 }
	
}
