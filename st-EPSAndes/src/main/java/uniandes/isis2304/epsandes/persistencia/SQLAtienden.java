package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Atienden;

public class SQLAtienden 
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
	public SQLAtienden (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarAtienden (PersistenceManager pm, long pidMedico, long pIdUsuario) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAtienden () + "(idMedico, idUsuario) values (?, ?)");
		q.setParameters(pidMedico, pIdUsuario);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAtienden (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAtienden ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idAtienden - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAtiendenPorIdAtienden (PersistenceManager pm, long idAtienden, long idUsuario ) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAtienden () + " WHERE id = ? AND idUsuario = ?");
		q.setParameters(idAtienden, idUsuario);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Atienden de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Atienden
	 */
	public List<Atienden> darAtienden (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAtienden ());
		q.setResultClass(Atienden.class);
		return (List<Atienden>) q.execute();
	}

	public Atienden darAtiendenPorId (PersistenceManager pm, long idAtienden, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAtienden () + " WHERE id = ? AND idUsuario = ?");
		q.setResultClass(Atienden.class);
		q.setParameters(idAtienden, idUsuario);
		return (Atienden) q.executeUnique();
	}
}
