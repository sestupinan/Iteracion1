package uniandes.isis2304.epsandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Medico;

public class SQLMedico {
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
	public SQLMedico (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	

	public long adicionarMedico (PersistenceManager pm, Long id, String tipo, String pNombre, String pEspecialidad, int pNRegistroMedico) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMedico () + "(id, especialidad, registroMedico, idEmpleado) values (?, ?, ?, ?)");
		q.setParameters(id, pEspecialidad, pNRegistroMedico, tipo, pNombre);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarMedico (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedico ());
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idMedico - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarMedicoPorIdMedico (PersistenceManager pm, long idMedico) 
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedico () + " WHERE id = ?");
		q.setParameters(idMedico);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Medico de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Medico
	 */
	public List<Medico> darMedico (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico ());
		q.setResultClass(Medico.class);
		return (List<Medico>) q.execute();
	}

	public Medico darMedicoPorId (PersistenceManager pm, long idMedico) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico () + " WHERE id = ?");
		q.setResultClass(Medico.class);
		q.setParameters(idMedico);
		return (Medico) q.executeUnique();
	}
}
