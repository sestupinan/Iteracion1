package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.ExamenSangre;

public class SQLExamenSangre {
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
	public SQLExamenSangre (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarExamenSangre (PersistenceManager pm, long id, String efectividad, String resultado, String tratamiento, long idHosp, long idServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaExamenSangre () + "(id, efectividad, resultado, tratamiento, idHosp, idServSalud) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, efectividad, resultado, tratamiento, idHosp, idServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarExamenSangre (PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaExamenSangre ());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idExamenSangre - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarExamenSangrePorIdExamenSangre (PersistenceManager pm, long idExamenSangre) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaExamenSangre () + " WHERE id = ?");
        q.setParameters(idExamenSangre);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ExamenSangre de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ExamenSangre
	 */
	public List<ExamenSangre> darExamenSangre (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaExamenSangre ());
		q.setResultClass(ExamenSangre.class);
		return (List<ExamenSangre>) q.execute();
	}
	
	public ExamenSangre darExamenSangrePorId (PersistenceManager pm, long idExamenSangre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaExamenSangre () + " WHERE id = ?");
		q.setResultClass(ExamenSangre.class);
		q.setParameters(idExamenSangre);
		return (ExamenSangre) q.executeUnique();
	}
}
