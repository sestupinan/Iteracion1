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

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.epsandes.negocio.ConsultaControl;
import uniandes.isis2304.epsandes.negocio.ConsultaMedica;
import uniandes.isis2304.epsandes.negocio.ConsultaUrgencias;
import uniandes.isis2304.epsandes.negocio.Hospitalizacion;
import uniandes.isis2304.epsandes.negocio.ServicioSalud;
import uniandes.isis2304.epsandes.negocio.Orden;

/**
 * Clase para el manejador de persistencia del proyecto Parranderos
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQLBar, SQLBebedor, SQLBebida, SQLGustan, SQLSirven, SQLTipoBebida y SQLVisitan, que son 
 * las que realizan el acceso a la base de datos
 * 
 * @author Germán Bravo
 */
public class PersistenciaEPSAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaEPSAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaEPSAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a la tabla hospitalizacion de la base de datos
	 */
	private SQLHospitalizacion sqlHospitalizacion;
	
	/**
	 * Atributo para el acceso a la tabla consultaurgencias de la base de datos
	 */
	private SQLConsultaUrgencias sqlConsultaUrgencias;
	
	/**
	 * Atributo para el acceso a la tabla usuario de la base de datos
	 */
	private SQLUsuario sqlUsuario;
	
	/**
	 * Atributo para el acceso a la tabla consultamedica de la base de datos
	 */
	private SQLConsultaMedica sqlConsultaMedica;
	
	/**
	 * Atributo para el acceso a la tabla consultaespecialista de la base de datos
	 */
	private SQLConsultaEspecialista sqlConsultaEspecialista;
	
	/**
	 * Atributo para el acceso a la tabla consultacontrol de la base de datos
	 */
	private SQLConsultaControl sqlConsultaControl;
	
	/**
	 * Atributo para el acceso a la tabla orden de la base de datos
	 */
	private SQLOrden sqlOrden;
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaEPSAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("EPSAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("SEQ_ORDEN");
		tablas.add ("ATIENDEN");
		tablas.add ("CONSULTACONTROL");
		tablas.add ("CONSULTAESPECIALISTA");
		tablas.add ("CONSULTAMEDICA");
		tablas.add ("CONSULTAURGENCIAS");
		tablas.add ("EMPLEADO");
		tablas.add ("EXAMENDIAGNOSTICO");
		tablas.add ("GERENTE");
		tablas.add ("HOSPITALIZACION");
		tablas.add ("IPS");
		tablas.add ("MEDICO");
		tablas.add ("ORDEN");
		tablas.add ("ORDENDETAIL");
		tablas.add ("PROCEDIMIENTOESPECIALIZADO");
		tablas.add ("SERVICIOSALUD");
		tablas.add ("TERAPIA");
		tablas.add ("TRABAJAN");
		tablas.add ("USAN");
		tablas.add ("USUARIO");
}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaEPSAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaEPSAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaEPSAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlHospitalizacion = new SQLHospitalizacion(this);
		sqlConsultaUrgencias = new SQLConsultaUrgencias(this);
		sqlUsuario = new SQLUsuario(this);
		sqlConsultaMedica = new SQLConsultaMedica(this);
		sqlConsultaEspecialista = new SQLConsultaEspecialista(this);
		sqlConsultaControl = new SQLConsultaControl (this);
		sqlOrden = new SQLOrden(this);		
		sqlUtil = new SQLUtil(this);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de epsandes
	 */
	public String darSeqOrden ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaAtienden ()
	{
		return tablas.get (1);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaConsultaControl ()
	{
		return tablas.get (2);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaConsultaEspecialista ()
	{
		return tablas.get (3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de parranderos
	 */
	public String darTablaConsultaMedica ()
	{
		return tablas.get (4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaConsultaUrgencias ()
	{
		return tablas.get (5);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de parranderos
	 */
	public String darTablaEmpleado ()
	{
		return tablas.get (6);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaExamenDiagnostico ()
	{
		return tablas.get (7);
	}
	
	public String darTablaGerente ()
	{
		return tablas.get (8);
	}
	
	public String darTablaHospitalizacion ()
	{
		return tablas.get (9);
	}
	
	public String darTablaIPS ()
	{
		return tablas.get (10);
	}
	
	public String darTablaMedico ()
	{
		return tablas.get (11);
	}
	
	public String darTablaOrden ()
	{
		return tablas.get (12);
	}
	
	public String darTablaOrdenDetail ()
	{
		return tablas.get (13);
	}
	
	public String darTablaProcedimientoEspecializado ()
	{
		return tablas.get (14);
	}
	
	public String darTablaServicioSalud ()
	{
		return tablas.get (15);
	}
	
	public String darTablaTerapia ()
	{
		return tablas.get (16);
	}
	
	public String darTablaTrabajan ()
	{
		return tablas.get (17);
	}
	
	public String darTablaUsan ()
	{
		return tablas.get (18);
	}
	
	public String darTablaUsuario ()
	{
		return tablas.get (19);
	}
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los REQUERIMIENTOS FUNCIONALES 7-9
	 *****************************************************************/

	
	//RFC7
	public Orden registrarOrden(String medicinas, long pIdSusuario, long pIdMedico, int ordenesExtra, Long[] idOrdenesExtra, Long[] idServExtra)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idOrden = nextval ();
            Query q = pm.newQuery(SQL, "INSERT INTO " + tablas.get(12) + "(idorden,rmedica,fecha,idmedico, idusuario) VALUES (SEQ_ORDEN.nextval,? ,sysdate,?,?)");
            q.setParameters(medicinas, pIdMedico, pIdSusuario);
            while(ordenesExtra>0)
            {
            	Query k = pm.newQuery(SQL, "INSERT INTO " + tablas.get(13) + "(ordenid,servicioid) VALUES (?,?)");
                k.setParameters(idOrdenesExtra[ordenesExtra-1], idServExtra[ordenesExtra]);
            	ordenesExtra--;
            }
            
            tx.commit();
            
            log.trace ("Inserción de orden medica");
            
            return new Orden(idOrden, medicinas, pIdMedico);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	//RFC8
	public void reservaServMed(Timestamp fechaReserva, long pIdServSalud, long pIps, long pIdUsuario, long pIdOrden)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "SELECT COUNT(*)\r\n" + 
					"FROM usan INNER JOIN serviciosalud ON usan.idservsalud = serviciosalud.idservsalud\r\n" + 
					"WHERE fecha ="+ fechaReserva+" AND usan.idservsalud = "+pIdServSalud +"AND serviciosalud.idips ="+ pIps);
			int rta = 0;
			if(rta==0)
			{
				if(pIdServSalud!= 0 && pIdServSalud!= 1) {
					//Verifica, si es necesario, que tenga la orden requerida para agendar el servicio
					Query k = pm.newQuery(SQL, "SELECT idorden \r\n" + 
							"FROM orden JOIN ordendetail ON orden.idorden = ordendetail.ordenid\r\n" + 
							"WHERE orden.idusuario = "+pIdUsuario+" AND ordendetail.servicioid ="+ pIdServSalud);
				}
	            Query r = pm.newQuery(SQL, "INSERT INTO usan (idusuario,idservsalud,estado,fechareserva,fechaatencion,idrecepcionista, idorden) \r\n" + 
	            		"VALUES ("+pIdUsuario+","+pIdServSalud+","+0+","+ fechaReserva+",null,null,"+ pIdOrden+")");
				

			}

			
			tx.commit();

			log.trace ("Reservacion de un servicio de salud");

		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	//RFC9
	public void registrarPrestServ(Timestamp fechaReserva, long pIdServSalud, long pIps, long pIdUsuario, long pIdRecepcionista)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "UPDATE usan\r\n" + 
					"SET\r\n" + 
					"    estado = 1, fechaatencion= sysdate, idrecepcionista ="+ pIdRecepcionista+"\r\n" + 
					"WHERE\r\n" + 
					"    idusuario = "+pIdUsuario+"\r\n" + 
					"    AND idservsalud = "+pIdServSalud+"\r\n" + 
					"    AND estado = 0\r\n" + 
					"    AND fechareserva = "+fechaReserva+"\r\n" + 
					"    ");

			tx.commit();

			log.trace ("Registro de la prestacion de un servicio de salud");

		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	
	
	//RFC1
	public void servPrestadosPorIPSEnFechas(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "SELECT COUNT(*)\r\n" + 
					"FROM usan\r\n" + 
					"WHERE (fechaatencion BETWEEN"+ pFechaInicial+" AND"+ pFechaFinal+") AND estado = 1");

			tx.commit();

			log.trace ("Servicios prestados por IPS en rango de fechas");

		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//RFC2
	public void mostrar20ServMasSolicitados(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "SELECT *\r\n" + 
					"FROM(\r\n" + 
					"SELECT idservsalud, COUNT(idServSalud) c\r\n" + 
					"FROM usan \r\n" + 
					"WHERE (fechaatencion BETWEEN"+ pFechaInicial+" AND"+ pFechaFinal+") AND estado = 1\r\n" + 
					"group by idservsalud\r\n" + 
					"ORDER BY c)\r\n" + 
					"WHERE ROWNUM <=20");

			tx.commit();

			log.trace ("20 servicios mas solicitados");

		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//RFC3
	public void mostrarIndiceUso(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "SELECT serviciosalud.idservsalud, COUNT(*)*100/serviciosalud.capacidad\r\n" + 
					"FROM usan JOIN serviciosalud ON usan.idservsalud = serviciosalud.idservsalud\r\n" + 
					"WHERE (fechaatencion BETWEEN"+ pFechaInicial+" AND"+ pFechaFinal+") AND estado = 1 \r\n" + 
					"group by serviciosalud.idservsalud;");

			tx.commit();

			log.trace ("Indice de uso de cada servicio");

		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//RFC4
	public void mostrarServiciosConCaracteristica(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "SELECT serviciosalud.idservsalud, COUNT(*)*100/serviciosalud.capacidad\r\n" + 
					"FROM usan JOIN serviciosalud ON usan.idservsalud = serviciosalud.idservsalud\r\n" + 
					"WHERE (fechaatencion BETWEEN pFechaInicial AND pFechaFinal) AND estado = 1 \r\n" + 
					"group by serviciosalud.idservsalud;");

			tx.commit();

			log.trace ("Indice de uso de cada servicio");

		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	
	//RFC5
	public void mostrarUsoServiciosAfiliadoDado(long pFechaInicial, Timestamp pFechaFinal, long pUsuarioId)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "SELECT usuario.nombre\r\n" + 
					"FROM usuario, usan\r\n" + 
					"WHERE"+ pUsuarioId+" = usuario.nidentificacion AND usan.idusuario = "+pUsuarioId+" AND fechaatencion BETWEEN"+ pFechaInicial+" AND "+pFechaFinal+"");

			tx.commit();

			log.trace ("Indice de uso de cada servicio");

		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	


	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarParranderos ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarParranderos (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	

 }
