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

import uniandes.isis2304.epsandes.negocio.Hospitalizacion;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto TIPO DE BEBIDA de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLHospitalizacion 
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
	public SQLHospitalizacion (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarHospitalizacion(PersistenceManager pm, long id, long idIPS, String estadoSalud, long idServSalud) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHospitalizacion() + "(id, idIPS, estadoSalud, idServSalud) values (?, ?, ?, ?)");
        q.setParameters(id, idIPS, estadoSalud, idServSalud);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TODAS LAS VISITAS de la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarHospitalizacion(PersistenceManager pm) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHospitalizacion());
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para ELIMINAR TODAS LAS VISITAS DE UN BEBEDOR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idHospitalizacion- El identificador del orden
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarHospitalizacionPorIdHospitalizacion(PersistenceManager pm, long idHospitalizacion) 
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHospitalizacion() + " WHERE id = ?");
        q.setParameters(idHospitalizacion);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Hospitalizacionde la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Hospitalizacion
	 */
	public List<Hospitalizacion> darHospitalizacion(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospitalizacion());
		q.setResultClass(Hospitalizacion.class);
		return (List<Hospitalizacion>) q.execute();
	}
	
	public Hospitalizacion darHospitalizacionPorId (PersistenceManager pm, long idHospitalizacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospitalizacion () + " WHERE id = ?");
		q.setResultClass(Hospitalizacion.class);
		q.setParameters(idHospitalizacion);
		return (Hospitalizacion) q.executeUnique();
	}

}
