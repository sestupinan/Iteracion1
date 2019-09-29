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
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsandes.negocio.Hospitalizacion;
import uniandes.isis2304.epsandes.negocio.ConsultaControl;
import uniandes.isis2304.epsandes.negocio.ConsultaControl;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto SIRVEN de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLConsultaControl 
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
	public SQLConsultaControl (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarConsultaControl (PersistenceManager pm, long id, String efectividad, String resultado, String tratamiento, long idHosp, long idServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsultaControl () + "(id, efectividad, resultado, tratamiento, idHosp, idServSalud) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, efectividad, resultado, tratamiento, idHosp, idServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsultaControl (PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsultaControl ());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idConsultaControl - El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsultaControlPorIdConsultaControl (PersistenceManager pm, long idConsultaControl) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsultaControl () + " WHERE id = ?");
        q.setParameters(idConsultaControl);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ConsultaControl de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ConsultaControl
	 */
	public List<ConsultaControl> darConsultaControl (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaControl ());
		q.setResultClass(ConsultaControl.class);
		return (List<ConsultaControl>) q.execute();
	}
	
	public ConsultaControl darConsultaControlPorId (PersistenceManager pm, long idConsultaControl) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaControl () + " WHERE id = ?");
		q.setResultClass(ConsultaControl.class);
		q.setParameters(idConsultaControl);
		return (ConsultaControl) q.executeUnique();
	}

}
