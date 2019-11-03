package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.CampañaPrevencion;

public class SQLCampañaPrevencion {
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
	public SQLCampañaPrevencion (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarCampañaPrevencion (PersistenceManager pm, long id, String efectividad, String resultado, String tratamiento, long idHosp, long idServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampañaPrevencion () + "(id, efectividad, resultado, tratamiento, idHosp, idServSalud) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, efectividad, resultado, tratamiento, idHosp, idServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarCampañaPrevencion (PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampañaPrevencion ());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idCampañaPrevencion - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarCampañaPrevencionPorIdCampañaPrevencion (PersistenceManager pm, long idCampañaPrevencion) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampañaPrevencion () + " WHERE id = ?");
        q.setParameters(idCampañaPrevencion);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los CampañaPrevencion de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos CampañaPrevencion
	 */
	public List<CampañaPrevencion> darCampañaPrevencion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampañaPrevencion ());
		q.setResultClass(CampañaPrevencion.class);
		return (List<CampañaPrevencion>) q.execute();
	}
	
	public CampañaPrevencion darCampañaPrevencionPorId (PersistenceManager pm, long idCampañaPrevencion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampañaPrevencion () + " WHERE id = ?");
		q.setResultClass(CampañaPrevencion.class);
		q.setParameters(idCampañaPrevencion);
		return (CampañaPrevencion) q.executeUnique();
	}
}
