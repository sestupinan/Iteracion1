package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.ProcedimientoEspecializado;

public class SQLProcedimientoEspecializado {

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
	public SQLProcedimientoEspecializado (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	

	public long adicionarProcedimientoEspecializado (PersistenceManager pm, long id, String tipo, String pEquipo, long pServSalud) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProcedimientoEspecializado () + "(id, tipo, equipo, servSalud) values (?, ?, ?, ?)");
		q.setParameters(id, tipo, pEquipo, pServSalud);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarProcedimientoEspecializado (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProcedimientoEspecializado ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idProcedimientoEspecializado - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarProcedimientoEspecializadoPorIdProcedimientoEspecializado (PersistenceManager pm, long idProcedimientoEspecializado) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProcedimientoEspecializado () + " WHERE id = ?");
		q.setParameters(idProcedimientoEspecializado);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ProcedimientoEspecializado de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ProcedimientoEspecializado
	 */
	public List<ProcedimientoEspecializado> darProcedimientoEspecializado (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProcedimientoEspecializado ());
		q.setResultClass(ProcedimientoEspecializado.class);
		return (List<ProcedimientoEspecializado>) q.execute();
	}

	public ProcedimientoEspecializado darProcedimientoEspecializadoPorId (PersistenceManager pm, long idProcedimientoEspecializado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProcedimientoEspecializado () + " WHERE id = ?");
		q.setResultClass(ProcedimientoEspecializado.class);
		q.setParameters(idProcedimientoEspecializado);
		return (ProcedimientoEspecializado) q.executeUnique();
	}
}
