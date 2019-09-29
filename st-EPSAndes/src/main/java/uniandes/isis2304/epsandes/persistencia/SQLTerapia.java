package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Terapia;

public class SQLTerapia {
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
	public SQLTerapia (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	

	public long adicionarTerapia (PersistenceManager pm, long id, String tipo, int pNSesiones, long pServSalud) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTerapia () + "(id, tipo, sesiones, servSalud) values (?, ?, ?, ?)");
		q.setParameters(id, tipo, pNSesiones, pServSalud);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarTerapia (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTerapia ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idTerapia - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarTerapiaPorIdTerapia (PersistenceManager pm, long idTerapia) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTerapia () + " WHERE id = ?");
		q.setParameters(idTerapia);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Terapia de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Terapia
	 */
	public List<Terapia> darTerapia (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTerapia ());
		q.setResultClass(Terapia.class);
		return (List<Terapia>) q.execute();
	}

	public Terapia darTerapiaPorId (PersistenceManager pm, long idTerapia) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTerapia () + " WHERE id = ?");
		q.setResultClass(Terapia.class);
		q.setParameters(idTerapia);
		return (Terapia) q.executeUnique();
	}
}
