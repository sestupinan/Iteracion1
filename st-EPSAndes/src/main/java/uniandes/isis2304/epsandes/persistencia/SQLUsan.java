package uniandes.isis2304.epsandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Trabajan;

public class SQLUsan 
{
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
	public SQLUsan (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarTrabajan (PersistenceManager pm, long id, long idServSalud, Timestamp pFechaReserva,Timestamp pFechaAtencion, long pNombre, int pEstado) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTrabajan () + "(idUsuario, idServSalud, fechaReserva, fechaAtencion, nombre, estado) values (?, ?, ?, ?, ?, ?)");
		q.setParameters(id, idServSalud, pFechaReserva, pFechaAtencion, pNombre, pEstado);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarTrabajan (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTrabajan ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idMedico - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarTrabajanPorIdTrabajan (PersistenceManager pm, long idUsuario ) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTrabajan () + " WHERE idUsuario = ?");
		q.setParameters(idUsuario);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Trabajan de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Trabajan
	 */
	public List<Trabajan> darTrabajan (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTrabajan ());
		q.setResultClass(Trabajan.class);
		return (List<Trabajan>) q.execute();
	}

	public Trabajan darTrabajanPorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTrabajan () + " WHERE idUsuario = ?");
		q.setResultClass(Trabajan.class);
		q.setParameters(idUsuario);
		return (Trabajan) q.executeUnique();
	}
}
