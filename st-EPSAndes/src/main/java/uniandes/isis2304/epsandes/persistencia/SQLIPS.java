package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.IPS;

public class SQLIPS {
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
	public SQLIPS (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}

	public long adicionarIPS (PersistenceManager pm, long id, String tipo, String pLocalizacion) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIPS () + "(id, tipo, localizacion) values (?, ?, ?)");
		q.setParameters(id, tipo, pLocalizacion);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarIPS (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIPS ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idIPS - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarIPSPorIdIPS (PersistenceManager pm, long idIPS) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIPS () + " WHERE id = ?");
		q.setParameters(idIPS);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los IPS de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos IPS
	 */
	public List<IPS> darIPS (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS ());
		q.setResultClass(IPS.class);
		return (List<IPS>) q.execute();
	}

	public IPS darIPSPorId (PersistenceManager pm, long idIPS) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS () + " WHERE id = ?");
		q.setResultClass(IPS.class);
		q.setParameters(idIPS);
		return (IPS) q.executeUnique();
	}
}
