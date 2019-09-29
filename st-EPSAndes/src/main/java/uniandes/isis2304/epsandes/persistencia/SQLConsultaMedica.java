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
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.ConsultaMedica;
import uniandes.isis2304.epsandes.negocio.ConsultaUrgencias;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BEBEDOR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLConsultaMedica 
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
	public SQLConsultaMedica (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarConsultaMedica(PersistenceManager pm, long id, String tipo, String dolencia, long servSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsultaMedica() + "(id, tipo, dolencia, servSalud) values (?, ?, ?, ?)");
        q.setParameters(id, tipo, dolencia, servSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsultaMedica(PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsultaMedica());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idConsultaMedica- El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsultaMedicaPorIdConsultaMedica(PersistenceManager pm, long idConsultaMedica) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsultaMedica() + " WHERE id = ?");
        q.setParameters(idConsultaMedica);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ConsultaMedicade la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ConsultaMedica
	 */
	public List<ConsultaMedica> darConsultaMedica(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaMedica());
		q.setResultClass(ConsultaMedica.class);
		return (List<ConsultaMedica>) q.execute();
	}
	
	public ConsultaMedica darConsultaMedicaPorId (PersistenceManager pm, long idConsultaMedica) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaMedica () + " WHERE id = ?");
		q.setResultClass(ConsultaMedica.class);
		q.setParameters(idConsultaMedica);
		return (ConsultaMedica) q.executeUnique();
	}


}
