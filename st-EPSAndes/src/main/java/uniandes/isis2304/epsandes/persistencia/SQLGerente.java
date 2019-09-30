package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Gerente;

public class SQLGerente {
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
	public SQLGerente (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarGerente (PersistenceManager pm, String pReporte) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaGerente () + "(reporte) values (?)");
		q.setParameters(pReporte);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarGerente (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaGerente ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idGerente - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarGerentePorIdGerente (PersistenceManager pm, long idGerente) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaGerente () + " WHERE id = ?");
		q.setParameters(idGerente, idUsuario);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Gerente de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Gerente
	 */
	public List<Gerente> darGerente (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaGerente ());
		q.setResultClass(Gerente.class);
		return (List<Gerente>) q.execute();
	}

	public Gerente darGerentePorId (PersistenceManager pm, long idGerente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaGerente () + " WHERE id = ?");
		q.setResultClass(Gerente.class);
		q.setParameters(idGerente);
		return (Gerente) q.executeUnique();
	}
}
