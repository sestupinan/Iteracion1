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

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.ConsultaUrgencias;
import uniandes.isis2304.epsandes.negocio.ServicioSalud;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BEBIDA de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLConsultaUrgencias 
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
	public SQLConsultaUrgencias (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una BEBIDA a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idConsultaUrgencias - El identificador de la bebida
	 * @param nombre - El nombre de la bebida
	 * @param idTipoConsultaUrgencias - El identificador del tipo de bebida de la bebida
	 * @param gradoAlcohol - El grado de alcohol de la bebida (Mayor que 0)
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarConsultaUrgencias (PersistenceManager pm, long id, String triage, long idMedico, long idServSalud, boolean dadoDeAlta) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsultaUrgencias () + "(id, triage, idmedico, idservsalud, dadodealta) values (?, ?, ?, ?, ?)");
        q.setParameters(id, triage, idMedico, idServSalud, dadoDeAlta);
        return (long) q.executeUnique();            
	}

	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BEBIDAS de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idConsultaUrgencias - El identificador de la bebida
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsultaUrgenciasPorId (PersistenceManager pm, long idConsultaUrgencias)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsultaUrgencias () + " WHERE id = ?");
        q.setParameters(idConsultaUrgencias);
        return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA BEBIDA de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idConsultaUrgencias - El identificador de la bebida
	 * @return El objeto BEBIDA que tiene el identificador dado
	 */
	public ConsultaUrgencias darConsultaUrgenciasPorId (PersistenceManager pm, long idConsultaUrgencias) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaUrgencias () + " WHERE id = ?");
		q.setResultClass(ConsultaUrgencias.class);
		q.setParameters(idConsultaUrgencias);
		return (ConsultaUrgencias) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de BEBIDAS de la 
	 * base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombreConsultaUrgencias - El nombre de la bebida
	 * @return Una lista de objetos BEBIDA que tienen el nombre dado
	 */
	public List<ConsultaUrgencias> darConsultaUrgenciasPorServSalud (PersistenceManager pm, long idServSalud) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaUrgencias () + " WHERE servsalud = ?");
		q.setResultClass(ConsultaUrgencias.class);
		q.setParameters(idServSalud);
		return (List<ConsultaUrgencias>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS BEBIDAS de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BEBIDA
	 */
	public List<ConsultaUrgencias> darConsultaUrgencias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaUrgencias ());
		q.setResultClass(ConsultaUrgencias.class);
		return (List<ConsultaUrgencias>) q.executeList();
	}


}
