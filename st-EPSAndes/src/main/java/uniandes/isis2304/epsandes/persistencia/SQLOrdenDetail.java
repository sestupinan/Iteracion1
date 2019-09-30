package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.OrdenDetail;

public class SQLOrdenDetail {
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
	public SQLOrdenDetail (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}


	public long adicionarOrdenDetail (PersistenceManager pm, long idOrden, long pIdServSalud) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOrdenDetail () + "(id, idServSalud) values (?, ?)");
		q.setParameters(idOrden, pIdServSalud);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarOrdenDetail (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrdenDetail ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idOrdenDetail - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarOrdenDetailPorIdOrdenDetail (PersistenceManager pm, long idOrdenDetail) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrdenDetail () + " WHERE id = ?");
		q.setParameters(idOrdenDetail);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los OrdenDetail de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos OrdenDetail
	 */
	public List<OrdenDetail> darOrdenDetail (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrdenDetail ());
		q.setResultClass(OrdenDetail.class);
		return (List<OrdenDetail>) q.execute();
	}

	public OrdenDetail darOrdenDetailPorId (PersistenceManager pm, long idOrdenDetail) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrdenDetail () + " WHERE id = ?");
		q.setResultClass(OrdenDetail.class);
		q.setParameters(idOrdenDetail);
		return (OrdenDetail) q.executeUnique();
	}
}
