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
import java.sql.ResultSet;
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

import uniandes.isis2304.epsandes.negocio.Administrador;
import uniandes.isis2304.epsandes.negocio.Auxiliar;
import uniandes.isis2304.epsandes.negocio.ConsultaControl;
import uniandes.isis2304.epsandes.negocio.ConsultaMedica;
import uniandes.isis2304.epsandes.negocio.ConsultaUrgencias;
import uniandes.isis2304.epsandes.negocio.Gerente;
import uniandes.isis2304.epsandes.negocio.Hospitalizacion;
import uniandes.isis2304.epsandes.negocio.IPS;
import uniandes.isis2304.epsandes.negocio.Medico;
import uniandes.isis2304.epsandes.negocio.ServicioSalud;
import uniandes.isis2304.epsandes.negocio.Usuario;
import uniandes.isis2304.epsandes.negocio.Orden;
import uniandes.isis2304.epsandes.negocio.Recepcionista;

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

	private SQLGerente sqlGerente;

	private SQLRecepcionista sqlRecepcionista;

	private SQLAdministrador sqlAdministrador;

	private SQLIPS sqlIPS;

	private SQLMedico sqlMedico;

	private SQLServicioDeSalud sqlServSalud;
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
		tablas.add("ADMINISTRADOR");
		tablas.add("CAMPANIAPREVENCION");
		tablas.add("EXAMENSANGRE");
		tablas.add("JORNADAVACUNACION");
		tablas.add("RADIOGRAFIA");
		tablas.add("NODISPONIBILIDAD");
		tablas.add("REGISTRAN");
		tablas.add("RESERVAN");
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
		sqlGerente = new SQLGerente(this);
		sqlRecepcionista = new SQLRecepcionista(this);
		sqlAdministrador = new SQLAdministrador(this);
		sqlIPS = new SQLIPS(this);
		sqlMedico = new SQLMedico(this);
		sqlServSalud = new SQLServicioDeSalud(this);
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

	public String darTablaAdministrador ()
	{
		return tablas.get (20);
	}

	public String darTablaCampañaPrevencion ()
	{
		return tablas.get (21);
	}

	public String darTablaExamenSangre ()
	{
		return tablas.get (22);
	}

	public String darTablaJornadaVacunacion ()
	{
		return tablas.get (23);
	}

	public String darTablaRadiografia ()
	{
		return tablas.get (24);
	}

	public String darTablaNoDisponibilidad ()
	{
		return tablas.get (25);
	}

	public String darTablaRegistran ()
	{
		return tablas.get (26);
	}

	public String darTablaReservan ()
	{
		return tablas.get (27);
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
	 * 			Métodos para manejar los REQUERIMIENTOS FUNCIONALES 1-6
	 *****************************************************************/

	//RF1

	//RF2 Registrar usuario
	public Gerente adicionarGerente(String pReporte, Long id, String tipo, String pNombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlGerente.adicionarGerente(pm, pReporte, id, tipo, pNombre);
			tx.commit();

			log.trace ("Inserción de gerente: " + id + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Gerente (pReporte, id, tipo, pNombre);
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

	public Administrador adicionarAdminDatos(String pCaracteristicas, Long idEmpleado, Long idAdministrador)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlAdministrador.adicionarAdmin(pm, pCaracteristicas, idEmpleado, idAdministrador);
			tx.commit();

			log.trace ("Inserción del admin de datos: " + idAdministrador + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Administrador(pCaracteristicas, idEmpleado, idAdministrador);
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

	public Recepcionista adicionarRecepcionista(String pCaracteristicas, Long id, String tipo, String pNombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlRecepcionista.adicionarRecepcionista(pm, id, tipo, pNombre);
			tx.commit();

			log.trace ("Inserción de recepcionista: " + id + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Recepcionista(pNombre, tipo, id);
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

	//RF3 Registrar IPS
	public IPS adicionarIPS(String pCaracteristicas, Long id, String tipo, String pLocalizacion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlIPS.adicionarIPS(pm, id, tipo, pLocalizacion);          
			tx.commit();

			log.trace ("Inserción de IPS: " + id + ": " + tuplasInsertadas + " tuplas insertadas");

			return new IPS(id, tipo, pLocalizacion);
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

	//RF4 Registrar medico
	public Medico adicionarMedico(Long id, String tipo, String pNombre, String pEspecialidad, int pNRegistroMedico)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlMedico.adicionarMedico(pm, id, tipo, pNombre, pEspecialidad, pNRegistroMedico);          
			tx.commit();

			log.trace ("Inserción de medico: " + id + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Medico(pEspecialidad, pNRegistroMedico, id, tipo, pNombre);
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

	//RF4 Registrar usuario/afiliado
	public Usuario adicionarUsuario(Long id, String tipo, String pNombre, Timestamp pFechaNacimiento)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, id, tipo, pFechaNacimiento, pNombre);          
			tx.commit();

			log.trace ("Inserción de usuario: " + id + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Usuario(id, tipo, pFechaNacimiento, pNombre);
		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
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

	//RF6 Registrar servicio salud
	public ServicioSalud adicionarServSalud(long id, String tipo, int capacidad, long pServSalud)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlServSalud.adicionarServicioSalud(pm,  id,  tipo,  capacidad, pServSalud);          
			tx.commit();

			log.trace ("Inserción de IPS: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
			return null;
			//return new Medico(id, tipo, pNombre, pEspecialidad, pNRegistroMedico);
		}
		catch (Exception e)
		{
			//	        	e.printStackTrace();
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

	/* ****************************************************************
	 * 			Métodos para manejar los REQUERIMIENTOS FUNCIONALES 7-9
	 *****************************************************************/


	//RF7
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

			return new Orden(idOrden, medicinas, null, pIdMedico, idOrden);
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

	//RF8
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

			log.trace ("Reserva de un servicio de salud");

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

	//RF9
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
			//List<Object> h = q.executeList();
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
	public List<ServicioSalud> servPrestadosPorIPSEnFechas(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT COUNT(*)\r\n" + 
				"FROM usan\r\n" + 
				"WHERE (fechaatencion BETWEEN ? AND ?) AND estado = 1");
		q.setParameters(pFechaInicial, pFechaFinal);
		q.setResultClass(ServicioSalud.class);
		log.trace ("Servicios prestados por IPS en rango de fechas");
		System.out.println(q.executeList());
		return (List<ServicioSalud>) q.executeList();
	}

	//RFC2
	public List<String> mostrar20ServMasSolicitados(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM(\r\n" + 
				"SELECT idservsalud, COUNT(idServSalud) c\r\n" + 
				"FROM usan \r\n" + 
				"WHERE (fechaatencion BETWEEN ? AND ? ) AND estado = 1\r\n" + 
				"group by idservsalud\r\n" + 
				"ORDER BY c)\r\n" + 
				"WHERE ROWNUM <=20");
		q.setParameters(pFechaInicial, pFechaFinal);
		log.trace ("20 servicios mas solicitados");			
		q.setResultClass(ServicioSalud.class);
		List<String> rta;
		rta = (List<String>) q.executeList();
		System.out.println(q.executeList());
		return rta;
	}

	//RFC3
	public void mostrarIndiceUso(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT serviciosalud.idservsalud, COUNT(*)*100/serviciosalud.capacidad\r\n" + 
				"FROM usan JOIN serviciosalud ON usan.idservsalud = serviciosalud.idservsalud\r\n" + 
				"WHERE (fechaatencion BETWEEN ? AND ?) AND usan.estado = 1 \r\n" + 
				"group by serviciosalud.idservsalud");
		q.setParameters(pFechaInicial, pFechaFinal);
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");
	}

	//RFC4
	public void mostrarServiciosConCaracteristica(long idre, long idser, Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT usan.idservsalud, usan.idusuario, usan.fechaatencion, usan.fechareserva, usan.estado\r\n" + 
				"FROM usan, serviciosalud\r\n" + 
				"WHERE usan.idrecepcionista = ? AND serviciosalud.idservsalud = ? AND fechaatencion BETWEEN ? AND ? ");

		q.setParameters(idre, idser, pFechaInicial, pFechaFinal);
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");


	}


	//RFC5
	public void mostrarUsoServiciosAfiliadoDado(long pFechaInicial, Timestamp pFechaFinal, long pUsuarioId)
	{

		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT usuario.nombre\r\n" + 
				"FROM usuario, usan\r\n" + 
				"WHERE"+ pUsuarioId+" = usuario.nidentificacion AND usan.idusuario = "+pUsuarioId+" AND fechaatencion BETWEEN"+ pFechaInicial+" AND "+pFechaFinal+"");
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");

	}


	//***************ITERACION 2************************************************************

	//RF10
	/**
	 * 
	 * @param pidCampania 
	 * @param pfechainicio
	 * @param pfechafin
	 * @param pnombrecampania
	 * @param idsServ ids de servicios a reservar
	 * @param cantReservar cantidad a reservar de cada servicio
	 */
	public List<Object> registrarCampania( Long pidCampania, Timestamp pfechainicio, Timestamp pfechafin, String pnombrecampania, int[] idsServ, int[] cantReservar)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		List<Object> h = null;
		try
		{
			tx.begin();
			//Verifica disponibilidad
			Query q = pm.newQuery(SQL, "INSERT INTO campaniaprevencion (\r\n" + 
					"    id,\r\n" + 
					"    fechainicio,\r\n" + 
					"    fechafin,\r\n" + 
					"    nombrecampania\r\n" + 
					") VALUES (\r\n" + 
					pidCampania+",\r\n" + 
					pfechainicio+",\r\n" + 
					pfechafin+",\r\n" + 
					pnombrecampania+"\r\n" + 
					");");
			tx.commit();
			for (int i = 0; i < idsServ.length; i++) {
				Query p = pm.newQuery(SQL, "INSERT INTO reservan\r\n" + 
						"(SELECT serviciosalud.idservsalud,"+ pidCampania+","+ cantReservar[i]+"\r\n" + 
						"FROM serviciosalud\r\n" + 
						"WHERE idservsalud ="+ idsServ[i]+"AND capacidad>="+cantReservar[i]+"\r\n" + 
						";");
				tx.commit();
				Query r = pm.newQuery(SQL, "UPDATE serviciosalud\r\n" + 
						"SET capacidad=capacidad-"+cantReservar[i]+"\r\n" + 
						"WHERE idservsalud="+idsServ[i]+";");
				tx.commit();
			}

			Query s = pm.newQuery(SQL, "SELECT reservan.idcampaniaprev, reservan.idservsalud, serviciosalud.nombre, reservan.cantidadreservados, serviciosalud.horario\r\n" + 
					"FROM reservan JOIN serviciosalud on serviciosalud.idservsalud = reservan.idservsalud\r\n" + 
					"WHERE reservan.idcampaniaprev = "+pidCampania+";");
			h = s.executeList();
			System.out.println(s.executeList());
			log.trace ("Registro de la prestacion de un servicio de salud");
			return h;
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
		return h;
	}

	//RF11 Aca hay dos casos, uno en el que se quiere liberar unos servicios en especifico y otro en el que se borra toda la campania
	//Caso especifico
	public void cancelarServCampaniaEspec(Long[] pIdServSalud, long pIdCampania)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			for (int i = 0; i < pIdServSalud.length; i++) {
				Query q = pm.newQuery(SQL, "DELETE FROM reservan\r\n" + 
						"WHERE idcampaniaprev ="+ pIdCampania+" AND idservsalud="+pIdServSalud+";");
				tx.commit();
			}		
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

	//Caso general
	public void cancelarServCampania(long pIdCampania)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad

			Query q = pm.newQuery(SQL, "DELETE FROM reservan\r\n" + 
					"WHERE idcampaniaprev ="+ pIdCampania+";");
			tx.commit();
			Query p = pm.newQuery(SQL, "DELETE FROM campaniaprevencion\r\n" + 
					"WHERE id="+pIdCampania+";");
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


	//RF12
	public void inhabilitarServ(Long[] pidservsalud, Timestamp[] pfechainicio, Timestamp[] pfechafin, Long[] pidips, String[] pcausa)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			for (int i = 0; i < pidservsalud.length; i++) 
			{
				Query q = pm.newQuery(SQL, "INSERT INTO nodisponibilidad (\r\n" + 
						"    idservsalud,\r\n" + 
						"    fechainicio,\r\n" + 
						"    idips,\r\n" + 
						"    causa,\r\n" + 
						"    fechafin\r\n" + 
						") VALUES (\r\n" + 
						pidservsalud+",\r\n" + 
						pfechainicio+",\r\n" + 
						pidips+",\r\n" + 
						pcausa+",\r\n" + 
						pfechafin+"\r\n" + 
						");");
				tx.commit();
				Query p = pm.newQuery(SQL, "update serviciosalud\r\n" + 
						"set estado=0\r\n" + 
						"where idservsalud ="+ pidservsalud+";");
				tx.commit();
			}		

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


	//RF13
	public void habilitarServ(Long[] pidservsalud)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			//Verifica disponibilidad
			for (int i = 0; i < pidservsalud.length; i++) 
			{
				Query q = pm.newQuery(SQL, "update serviciosalud\r\n" + 
						"set estado=1\r\n" + 
						"where idservsalud ="+ pidservsalud[i]);
				tx.commit();
			}		

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


	//RFC6 Aqui hay tres opciones,  las fechas de mayor demanda(mayor cantidad de serviciossolicitados), 
	//		las de mayor actividad(mayor cantidad de servicios efectivamente prestados)
	//		y también las fechas de menor demanda
	/**
	 * 
	 * @param unidadTiempo Tiene que estar en formato YY, WW, o MM
	 * @param pIdServSalud El buscado
	 */
	public void analizarOperacionMayorDemanda(String unidadTiempo, Long pIdServSalud)
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT usan.idservsalud,  TO_CHAR(usan.fechareserva, '"+unidadTiempo+"') unidadtiempo, serviciosalud.nombre, COUNT(*)cuenta\r\n" + 
				"FROM usan JOIN serviciosalud on serviciosalud.idservsalud=usan.idservsalud\r\n" + 
				"WHERE usan.estado=0\r\n" + 
				"GROUP BY usan.idservsalud, TO_CHAR(usan.fechareserva, '"+unidadTiempo+"'), serviciosalud.nombre\r\n" + 
				"ORDER BY cuenta desc\r\n" );
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");

	}

	public void analizarOperacionMayorActividad(String unidadTiempo, Long pIdServSalud)
	{

		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT usan.idservsalud,  TO_CHAR(usan.fechaatencion, '"+unidadTiempo+"') unidadtiempo, serviciosalud.nombre, COUNT(*)cuenta\r\n" + 
				"FROM usan JOIN serviciosalud on serviciosalud.idservsalud=usan.idservsalud\r\n" + 
				"WHERE usan.estado=1\r\n" + 
				"GROUP BY usan.idservsalud, TO_CHAR(usan.fechaatencion, '"+unidadTiempo+"'), serviciosalud.nombre\r\n" + 
				"ORDER BY cuenta desc\r\n" );
		System.out.println(q.executeList());

		log.trace ("Indice de uso de cada servicio");

	}

	public void analizarOperacionMenorDemanda(String unidadTiempo, Long pIdServSalud)
	{

		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT usan.idservsalud,  TO_CHAR(usan.fechareserva, '"+unidadTiempo+"') unidadtiempo, serviciosalud.nombre, COUNT(*)cuenta\r\n" + 
				"FROM usan JOIN serviciosalud on serviciosalud.idservsalud=usan.idservsalud\r\n" + 
				"WHERE usan.estado=0\r\n" + 
				"GROUP BY usan.idservsalud, TO_CHAR(usan.fechareserva, '"+unidadTiempo+"'), serviciosalud.nombre\r\n" + 
				"ORDER BY cuenta asc\r\n"  
				);
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");

	}


	//RFC7
	public void encontrarAfiliadosExigentes()
	{

		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM usuario, \r\n" + 
				"    (\r\n" + 
				"    SELECT COUNT(*) c,  usuario.nidentificacion n\r\n" + 
				"    FROM usan, usuario,\r\n" + 
				"        (\r\n" + 
				"        SELECT COUNT(DISTINCT(usan.idservsalud)) co, usan.idusuario \r\n" + 
				"        FROM usan group by usan.idusuario\r\n" + 
				"        ) aux2\r\n" + 
				"    WHERE usan.idusuario = usuario.nidentificacion AND usan.estado=1  AND aux2.co >3\r\n" + 
				"    GROUP BY usuario.nidentificacion\r\n" + 
				"    ) aux\r\n" + 
				"WHERE aux.c > 11 and usuario.nidentificacion=aux.n\r\n" 
				);
		System.out.println(q.executeList());

		//		q.setResultClass(Auxiliar.class);
		//		List<Auxiliar> l = q.executeList();
		//		System.out.println(l);
		//		for (Auxiliar auxiliar : l) {
		//			System.out.println(auxiliar.toString());
		//
		//		}
		log.trace ("Indice de uso de cada servicio");

	}

	//RFC8 BONO
	public void encontrarServiciosPocaDemanda()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT serviciosalud.idservsalud, serviciosalud.nombre, COUNT(*), TO_CHAR(usan.fechareserva, 'WW')\r\n" + 
				"FROM usan, serviciosalud\r\n" + 
				"WHERE  usan.idservsalud = serviciosalud.idservsalud AND EXTRACT (YEAR FROM usan.fechareserva) = EXTRACT (YEAR FROM SYSDATE) -1\r\n" + 
				"group by serviciosalud.idservsalud, serviciosalud.nombre, TO_CHAR(usan.fechareserva, 'WW') \r\n" + 
				"HAVING COUNT(*)<3\r\n" 
				);
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");

	}

	//******************ITERACION 3*********************************************************

	//RFC9 
	public void consultarPresatacionServicios(long idServSalud, Timestamp finicio, Timestamp ffin, long idIPS, String agruOrd)
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM usuario JOIN usan ON usan.idusuario = usuario.nidentificacion, serviciosalud\r\n" + 
				"WHERE usan.idservsalud = ? AND usan.fechaatencion> ? AND usan.fechaatencion< ? \r\n" + 
				"AND serviciosalud.idservsalud=usan.idservsalud AND serviciosalud.idips = ? \r\n" +  
				"ORDER BY ? \r\n" + 
				"" 
				);
		q.setParameters(idServSalud, finicio, ffin, idIPS, agruOrd, agruOrd);
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");

	}

	//RFC10a
	public void consultarPresatacionServiciosSinServicioPorUsuario()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT USUARIO.NOMBRE, usuario.FECHANACIMIENTO, usuario.NIDENTIFICACION, usuario.TIPOID\r\n" + 
				"FROM usuario LEFT JOIN usan ON usuario.nidentificacion = usan.idusuario \r\n" + 
				"WHERE usan.idusuario is NULL"
				);
		System.out.println(q.executeList());
		log.trace ("Indice de uso de cada servicio");

	}

	//RFC10b
	public void consultarPresatacionServiciosServSaludNoUsados()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT count(*)\r\n" + 
				"FROM serviciosalud LEFT JOIN usan ON serviciosalud.idservsalud = usan.idservsalud \r\n" + 
				"WHERE usan.idservsalud is NULL\r\n" + 
				""
				);
		System.out.println("Id servicio salud (Si es 0 no existe ninguno): " + q.executeList());
		log.trace ("Indice de uso de cada servicio");

	}

	//RFC10c
	public void consultarPresatacionServiciosIPSNoUsadas()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT ips.idips\r\n" + 
				"FROM ips LEFT JOIN (serviciosalud JOIN usan ON usan.idservsalud = serviciosalud.idservsalud) ON ips.idips =serviciosalud.idips \r\n" + 
				"WHERE serviciosalud.idips IS NULL" 
				);
		System.out.println("Id IPS: " + q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC11a
	public void consultarFuncionamientoServMasUsado()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM(\r\n" + 
				"SELECT semana, aux.idservsalud, MIN(cuenta) over (partition by semana ORDER BY cuenta desc )as maximo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM\r\n" + 
				"FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idservsalud) cuenta, usan.idservsalud\r\n" + 
				"    FROM usan\r\n" + 
				"    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idservsalud\r\n" + 
				"    ORDER BY semana, cuenta DESC) aux\r\n" + 
				"ORDER BY semana)\r\n" + 
				"WHERE ROW_NUM=1\r\n" + 
				"" 
				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC11b
	public void consultarFuncionamientoServMenosUsado()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM (\r\n" + 
				"SELECT semana, aux.idservsalud, MAX(cuenta) over (partition by semana ORDER BY cuenta  )as minimo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM\r\n" + 
				"FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idservsalud) cuenta, usan.idservsalud\r\n" + 
				"    FROM usan\r\n" + 
				"    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idservsalud\r\n" + 
				"    ORDER BY semana, cuenta DESC) aux\r\n" + 
				"ORDER BY semana)\r\n" + 
				"WHERE ROW_NUM = 1\r\n" + 
				"" 
				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC11	c
	public void consultarFuncionamientoUsuarioMasServicioSemana()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM (\r\n" + 
				"SELECT semana, aux.idusuario, MIN(cuenta) over (partition by semana ORDER BY cuenta  desc)as maximo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM\r\n" + 
				"FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idusuario) cuenta, usan.idusuario\r\n" + 
				"    FROM usan\r\n" + 
				"    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idusuario\r\n" + 
				"    ORDER BY semana, cuenta DESC) aux\r\n" + 
				"ORDER BY semana)\r\n" + 
				"WHERE ROW_NUM = 1" 
				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC11d
	public void consultarFuncionamientoUsuarioMenosServicioSemana()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM (\r\n" + 
				"SELECT semana, aux.idusuario, MAX(cuenta) over (partition by semana ORDER BY cuenta  )as minimo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM\r\n" + 
				"FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(usan.idusuario) cuenta, usan.idusuario\r\n" + 
				"    FROM usan\r\n" + 
				"    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), usan.idusuario\r\n" + 
				"    ORDER BY semana, cuenta DESC) aux\r\n" + 
				"ORDER BY semana)\r\n" + 
				"WHERE ROW_NUM = 1\r\n" + 
				"" 
				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC11e
	public void consultarFuncionamientoIpsMenosUsadoSemana()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM (\r\n" + 
				"SELECT semana, aux.idips, MAX(cuenta) over (partition by semana ORDER BY cuenta  )as minimo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM\r\n" + 
				"FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(ips.idips) cuenta, ips.idips\r\n" + 
				"    FROM usan join serviciosalud on usan.idservsalud = serviciosalud.idservsalud join ips on serviciosalud.idips = ips.idips\r\n" + 
				"    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), ips.idips\r\n" + 
				"    ORDER BY semana, cuenta DESC) aux\r\n" + 
				"ORDER BY semana)\r\n" + 
				"WHERE ROW_NUM = 1\r\n" + 
				"" + 
				"" 
				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC11f
	public void consultarFuncionamientoIpsMasUsadoSemana()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT *\r\n" + 
				"FROM (\r\n" + 
				"SELECT semana, aux.idips, MIN(cuenta) over (partition by semana ORDER BY cuenta desc )as maximo, ROW_NUMBER() OVER (PARTITION BY semana ORDER BY semana) AS ROW_NUM\r\n" + 
				"FROM (SELECT TO_CHAR(usan.fechareserva, 'WW') semana, COUNT(ips.idips) cuenta, ips.idips\r\n" + 
				"    FROM usan join serviciosalud on usan.idservsalud = serviciosalud.idservsalud join ips on serviciosalud.idips = ips.idips\r\n" + 
				"    GROUP BY TO_CHAR(usan.fechareserva, 'WW'), ips.idips\r\n" + 
				"    ORDER BY semana, cuenta DESC) aux\r\n" + 
				"ORDER BY semana)\r\n" + 
				"WHERE ROW_NUM = 1\r\n" + 
				"" 
				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC12a
	public void consultarLosAfiliadosCostosos1almes()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT idusuario\r\n" + 
				"FROM (\r\n" + 
				"SELECT TO_CHAR(usan.fechareserva, 'YYYY'), COUNT(usan.idservsalud) cuenta, idusuario\r\n" + 
				"FROM usan\r\n" + 
				"group by TO_CHAR(usan.fechareserva, 'YYYY'), idusuario\r\n" + 
				"order by cuenta desc) aux\r\n" + 
				"WHERE aux.cuenta >=12\r\n" 

				);
		System.out.println("Id de los usuarios: " + q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC12b
	public void consultarLosAfiliadosCostososServMedicoEspecializado()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT usan.idusuario FROM (\r\n" + 
				"SELECT DISTINCT usan.idusuario, idservsalud\r\n" + 
				"FROM usan\r\n" + 
				"WHERE idservsalud != 7 AND idservsalud!=2 order by idusuario \r\n" + 
				")aux , usan--join usuario on aux.idusuario = usuario.nidentificacion\r\n" + 
				"WHERE usan.idusuario != aux.idusuario\r\n"

				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}

	//RFC12c
	public void consultarLosAfiliadosCostosos()
	{

		//Verifica disponibilidad
		Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT count(idservsalud)\r\n" + 
				"FROM usan\r\n" + 
				"WHERE idservsalud = 7\r\n" + 
				"group by usan.idusuario \r\n"
				);
		System.out.println(q.execute());

		log.trace ("Indice de uso de cada servicio");

	}





	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarEPSAndes ()
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
