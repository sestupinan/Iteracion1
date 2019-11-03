package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.NoDisponibilidad;

public class SQLNoDisponibilidad {

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
	public SQLNoDisponibilidad (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarNoDisponibilidad (PersistenceManager pm, String pReporte, Long id, String tipo, String pNombre) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaNoDisponibilidad () + "(reporte) values (?)");
		q.setParameters(pReporte,  id,  tipo,  pNombre);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarNoDisponibilidad (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaNoDisponibilidad ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idNoDisponibilidad - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarNoDisponibilidadPorIdNoDisponibilidad (PersistenceManager pm, long idNoDisponibilidad) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaNoDisponibilidad () + " WHERE id = ?");
		q.setParameters(idNoDisponibilidad);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los NoDisponibilidad de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos NoDisponibilidad
	 */
	public List<NoDisponibilidad> darNoDisponibilidad (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaNoDisponibilidad ());
		q.setResultClass(NoDisponibilidad.class);
		return (List<NoDisponibilidad>) q.execute();
	}

	public NoDisponibilidad darNoDisponibilidadPorId (PersistenceManager pm, long idNoDisponibilidad) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaNoDisponibilidad () + " WHERE id = ?");
		q.setResultClass(NoDisponibilidad.class);
		q.setParameters(idNoDisponibilidad);
		return (NoDisponibilidad) q.executeUnique();
	}
}
