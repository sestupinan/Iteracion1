package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.ExamenDiagnostico;

public class SQLExamenDiagnostico {
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
	public SQLExamenDiagnostico (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarExamenDiagnostico(PersistenceManager pm, long id, String pResultado, String pDiagnostico, long pServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaExamenDiagnostico() + "(id, resultado, diagnostico, servSalud) values (?, ?, ?, ?)");
        q.setParameters(id, pResultado, pDiagnostico, pServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarExamenDiagnostico(PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaExamenDiagnostico());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idExamenDiagnostico- El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarExamenDiagnosticoPorIdExamenDiagnostico(PersistenceManager pm, long idExamenDiagnostico) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaExamenDiagnostico() + " WHERE id = ?");
        q.setParameters(idExamenDiagnostico);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ExamenDiagnosticode la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ExamenDiagnostico
	 */
	public List<ExamenDiagnostico> darExamenDiagnostico(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaExamenDiagnostico());
		q.setResultClass(ExamenDiagnostico.class);
		return (List<ExamenDiagnostico>) q.execute();
	}
	
	public ExamenDiagnostico darExamenDiagnosticoPorId (PersistenceManager pm, long idExamenDiagnostico) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaExamenDiagnostico () + " WHERE id = ?");
		q.setResultClass(ExamenDiagnostico.class);
		q.setParameters(idExamenDiagnostico);
		return (ExamenDiagnostico) q.executeUnique();
	}
}
