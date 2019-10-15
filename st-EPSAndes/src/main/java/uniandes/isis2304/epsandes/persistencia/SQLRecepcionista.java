package uniandes.isis2304.epsandes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLRecepcionista {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaEPSAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaEPSAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLRecepcionista (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarRecepcionista (PersistenceManager pm, Long id, String tipo, String pNombre) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaGerente () + "(reporte) values (?)");
		q.setParameters( id,  tipo,  pNombre);
		return (long) q.executeUnique();
	}

}
