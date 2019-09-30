/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.epsandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.ConsultaUrgencias;
import uniandes.isis2304.epsandes.negocio.Orden;
import uniandes.isis2304.epsandes.negocio.ServicioSalud;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Orden de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLOrden 
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
	public SQLOrden (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Orden a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idOrden - El identificador del orden
	 * @param idMedicamentos - El identificador del medicamentos
	 * @param fecha - La fecha en que se realizó la visita
	 * @param horario - EL horario en que se realizó la visita (DIURNO, NOCTURNO, TODOS)
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarOrden (PersistenceManager pm, long idOrden, String pMedicamentos, long pIdServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOrden () + "(idorden, medicamentos, idservsalud) values (?, ?, ?)");
        q.setParameters(idOrden, pMedicamentos, pIdServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarOrden (PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrden ());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN Orden de la base de datos de Parranderos, por sus identificadores
	 * @param pm - El manejador de persistencia
	 * @param idOrden - El identificador del orden
	 * @param idMedicamentos - El identificador del medicamentos
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarOrden (PersistenceManager pm, long idOrden, String Medicamentos) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrden () + " WHERE idorden = ? AND medicamentos = ?");
        q.setParameters(idOrden, Medicamentos);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idOrden - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarOrdenPorIdOrden (PersistenceManager pm, long idOrden) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrden () + " WHERE idorden = ?");
        q.setParameters(idOrden);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS HECHAS A UN BAR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idMedicamentos - El identificador del medicamentos
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarOrdenPorMedicamentos (PersistenceManager pm, String Medicamentos) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrden () + " WHERE medicamentos = ?");
        q.setParameters(Medicamentos);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Orden de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Orden
	 */
	public List<Orden> darOrden (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrden ());
		q.setResultClass(Orden.class);
		return (List<Orden>) q.execute();
	}
	
	public Orden darOrdenPorId (PersistenceManager pm, long idOrden) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrden () + " WHERE idorden = ?");
		q.setResultClass(Orden.class);
		q.setParameters(idOrden);
		return (Orden) q.executeUnique();
	}

	/* ****************************************************************
	 * 			Versión larga, a lo JDBC
	 *****************************************************************/
  	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Orden de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Orden
	 */
	private List<Orden> darOrden_V2 (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT idorden, medicamentos, idservsalud FROM " + pp.darTablaOrden ());
		List<Orden> resp = new LinkedList<>();
		List results = q.executeList();
		for (Object obj : results)
		{
			Object [] datos = (Object []) obj;
			long idOrden =  ((BigDecimal) datos [0]).longValue ();
			long idServSalud = ((BigDecimal) datos [1]).longValue();
			String medicamentos = (String) datos [3];
			resp.add (new Orden (idOrden, medicamentos, idServSalud));
		}
		return resp;		
	}
		 	
}
