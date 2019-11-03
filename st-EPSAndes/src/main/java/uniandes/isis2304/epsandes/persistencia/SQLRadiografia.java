package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Radiografia;

public class SQLRadiografia {

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
	public SQLRadiografia (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarRadiografia (PersistenceManager pm, long id, String efectividad, String resultado, String tratamiento, long idHosp, long idServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRadiografia () + "(id, efectividad, resultado, tratamiento, idHosp, idServSalud) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, efectividad, resultado, tratamiento, idHosp, idServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarRadiografia (PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRadiografia ());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idRadiografia - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarRadiografiaPorIdRadiografia (PersistenceManager pm, long idRadiografia) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRadiografia () + " WHERE id = ?");
        q.setParameters(idRadiografia);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Radiografia de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Radiografia
	 */
	public List<Radiografia> darRadiografia (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRadiografia ());
		q.setResultClass(Radiografia.class);
		return (List<Radiografia>) q.execute();
	}
	
	public Radiografia darRadiografiaPorId (PersistenceManager pm, long idRadiografia) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRadiografia () + " WHERE id = ?");
		q.setResultClass(Radiografia.class);
		q.setParameters(idRadiografia);
		return (Radiografia) q.executeUnique();
	}
}
