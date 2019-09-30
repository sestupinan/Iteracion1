package uniandes.isis2304.epsandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Usan;

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
	
	public long adicionarUsan (PersistenceManager pm, long id, long idServSalud, Timestamp pFechaReserva,Timestamp pFechaAtencion, long pNombre, int pEstado) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsan () + "(idUsuario, idServSalud, fechaReserva, fechaAtencion, nombre, estado) values (?, ?, ?, ?, ?, ?)");
		q.setParameters(id, idServSalud, pFechaReserva, pFechaAtencion, pNombre, pEstado);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarUsan (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsan ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idMedico - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarUsanPorIdUsan (PersistenceManager pm, long idUsuario ) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsan () + " WHERE idUsuario = ?");
		q.setParameters(idUsuario);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Usan de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Usan
	 */
	public List<Usan> darUsan (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsan ());
		q.setResultClass(Usan.class);
		return (List<Usan>) q.execute();
	}

	public Usan darUsanPorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsan () + " WHERE idUsuario = ?");
		q.setResultClass(Usan.class);
		q.setParameters(idUsuario);
		return (Usan) q.executeUnique();
	}
}
