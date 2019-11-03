package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Reservan;

public class SQLReservan {

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
	public SQLReservan (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarReservan (PersistenceManager pm, long id, String efectividad, String resultado, String tratamiento, long idHosp, long idServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservan () + "(id, efectividad, resultado, tratamiento, idHosp, idServSalud) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, efectividad, resultado, tratamiento, idHosp, idServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarReservan (PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservan ());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idReservan - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarReservanPorIdReservan (PersistenceManager pm, long idReservan) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservan () + " WHERE id = ?");
        q.setParameters(idReservan);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Reservan de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Reservan
	 */
	public List<Reservan> darReservan (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservan ());
		q.setResultClass(Reservan.class);
		return (List<Reservan>) q.execute();
	}
	
	public Reservan darReservanPorId (PersistenceManager pm, long idReservan) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservan () + " WHERE id = ?");
		q.setResultClass(Reservan.class);
		q.setParameters(idReservan);
		return (Reservan) q.executeUnique();
	}
}
