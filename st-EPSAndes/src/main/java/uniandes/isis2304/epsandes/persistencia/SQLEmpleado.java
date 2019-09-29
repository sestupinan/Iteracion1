package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Empleado;

public class SQLEmpleado {
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
	public SQLEmpleado (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarEmpleado(PersistenceManager pm, long id, String pTipoId, String pNOmbre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaEmpleado() + "(id, tipoId, nombre) values (?, ?, ?)");
        q.setParameters(id, pTipoId, pNOmbre);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarEmpleado(PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpleado());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idEmpleado- El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarEmpleadoPorIdEmpleado(PersistenceManager pm, long idEmpleado) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpleado() + " WHERE id = ?");
        q.setParameters(idEmpleado);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Empleadode la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Empleado
	 */
	public List<Empleado> darEmpleado(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpleado());
		q.setResultClass(Empleado.class);
		return (List<Empleado>) q.execute();
	}
	
	public Empleado darEmpleadoPorId (PersistenceManager pm, long idEmpleado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpleado () + " WHERE id = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(idEmpleado);
		return (Empleado) q.executeUnique();
	}

}
