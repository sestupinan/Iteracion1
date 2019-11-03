package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.JornadaVacunacion;

public class SQLJornadaVacunacion {

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
	public SQLJornadaVacunacion (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarJornadaVacunacion (PersistenceManager pm, long id, String efectividad, String resultado, String tratamiento, long idHosp, long idServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaJornadaVacunacion () + "(id, efectividad, resultado, tratamiento, idHosp, idServSalud) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, efectividad, resultado, tratamiento, idHosp, idServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarJornadaVacunacion (PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaJornadaVacunacion ());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idJornadaVacunacion - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarJornadaVacunacionPorIdJornadaVacunacion (PersistenceManager pm, long idJornadaVacunacion) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaJornadaVacunacion () + " WHERE id = ?");
        q.setParameters(idJornadaVacunacion);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los JornadaVacunacion de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos JornadaVacunacion
	 */
	public List<JornadaVacunacion> darJornadaVacunacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaJornadaVacunacion ());
		q.setResultClass(JornadaVacunacion.class);
		return (List<JornadaVacunacion>) q.execute();
	}
	
	public JornadaVacunacion darJornadaVacunacionPorId (PersistenceManager pm, long idJornadaVacunacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaJornadaVacunacion () + " WHERE id = ?");
		q.setResultClass(JornadaVacunacion.class);
		q.setParameters(idJornadaVacunacion);
		return (JornadaVacunacion) q.executeUnique();
	}
}
