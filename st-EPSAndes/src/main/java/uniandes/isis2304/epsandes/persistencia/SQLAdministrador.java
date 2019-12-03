package uniandes.isis2304.epsandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Administrador;
import uniandes.isis2304.epsandes.negocio.Administrador;

public class SQLAdministrador 
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
	public SQLAdministrador (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarAdmin (PersistenceManager pm, String pReporte, Long idAdmin, Long idEmp) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAdministrador () + "(reporte) values (?)");
		q.setParameters(pReporte,  idAdmin,  idEmp);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAdministrador (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAdministrador ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idAdministrador - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAdministradorPorIdAdministrador (PersistenceManager pm, long idAdministrador) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAdministrador () + " WHERE id = ?");
		q.setParameters(idAdministrador);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Administrador de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Administrador
	 */
	public List<Administrador> darAdministrador (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAdministrador ());
		q.setResultClass(Administrador.class);
		return (List<Administrador>) q.execute();
	}

	public Administrador darAdministradorPorId (PersistenceManager pm, long idAdministrador) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAdministrador () + " WHERE id = ?");
		q.setResultClass(Administrador.class);
		q.setParameters(idAdministrador);
		return (Administrador) q.executeUnique();
	}
	
}
