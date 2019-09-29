package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.ServicioSalud;

public class SQLServicioDeSalud {
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
	public SQLServicioDeSalud (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	

	public long adicionarServicioSalud (PersistenceManager pm, long id, String tipo, int capacidad, long pServSalud) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicioSalud () + "(id, tipo, capacidad, servSalud) values (?, ?, ?, ?)");
		q.setParameters(id, tipo, capacidad, pServSalud);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioSalud (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioSalud ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idServicioSalud - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioSaludPorIdServicioSalud (PersistenceManager pm, long idServicioSalud) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioSalud () + " WHERE id = ?");
		q.setParameters(idServicioSalud);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ServicioSalud de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ServicioSalud
	 */
	public List<ServicioSalud> darServicioSalud (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioSalud ());
		q.setResultClass(ServicioSalud.class);
		return (List<ServicioSalud>) q.execute();
	}

	public ServicioSalud darServicioSaludPorId (PersistenceManager pm, long idServicioSalud) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioSalud () + " WHERE id = ?");
		q.setResultClass(ServicioSalud.class);
		q.setParameters(idServicioSalud);
		return (ServicioSalud) q.executeUnique();
	}
}
