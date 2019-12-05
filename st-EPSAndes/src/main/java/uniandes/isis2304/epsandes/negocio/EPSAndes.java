/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 /**~~~~~~~~~~~~~~~~~~~~~~~
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
 * ~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.epsandes.negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;

import uniandes.isis2304.epsandes.interfazDemo.EPSAndesDemo;
import uniandes.isis2304.epsandes.persistencia.PersistenciaEPSAndes;
import view.EPSAndesview;



/**
 * Clase principal del negocio
 * Sarisface todos los requerimientos funcionales del negocio
 *
 * @author Germán Bravo
 */
public class EPSAndes 
{
	private EPSAndesview view;

	private EPSAndesDemo demo;
	/* **********************
	 * 			Constantes
	 ***********************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(EPSAndes.class.getName());

	/* **********************
	 * 			Atributos
	 ***********************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaEPSAndes pp;

	/* **********************
	 * 			Métodos
	 ***********************/
	/**
	 * El constructor por defecto
	 */
	public EPSAndes ()
	{
		pp = PersistenciaEPSAndes.getInstance ();
		view = new EPSAndesview();
		demo = new EPSAndesDemo();
	}

	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public EPSAndes (JsonObject tableConfig)
	{
		pp = PersistenciaEPSAndes.getInstance (tableConfig);
	}

	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}

	public void run() throws ParseException {
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		EPSAndes controller = new EPSAndes();

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 1:	

				view.printMenuAdministrador();
				int option1 = sc.nextInt();
				switch(option1)
				{
				case 1:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
					 
					Timestamp pFechaInicial = new Timestamp(sdf1.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
					
					Timestamp pFechaFinal = new Timestamp(sdf2.parse(sc.next()).getTime());
					controller.servPrestadosPorIPSEnFechas(pFechaInicial, pFechaFinal);

					break;

				case 2:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf11 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaInicial1 = new Timestamp(sdf11.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf21 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaFinal1 = new Timestamp(sdf21.parse(sc.next()).getTime());

					controller.mostrar20ServMasSolicitados(pFechaInicial1, pFechaFinal1);

					break;

				case 3:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf12 = new SimpleDateFormat("dd-MM-yyyy");
					
					Timestamp pFechaInicial2 = new Timestamp(sdf12.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf22 = new SimpleDateFormat("dd-MM-yyyy");
					
					Timestamp pFechaFinal2 = new Timestamp(sdf22.parse(sc.next()).getTime());

					controller.mostrarIndiceUso(pFechaInicial2, pFechaFinal2);

					break;

				case 4:

					System.out.println("Inserte el id del recepcionista");
					long idrep = sc.nextLong();
					System.out.println("Inserte el id del servicio de salud");
					long idserv = sc.nextLong();
					System.out.println("Inserte la fecha inicial");
					DateFormat sdf7 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaInicial3 = new Timestamp(sdf7.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf8 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaFinal3= new Timestamp(sdf8.parse(sc.next()).getTime());

					controller.mostrarServiciosConCaracteristica(idrep, idserv, pFechaInicial3, pFechaFinal3);

					break;

				case 5:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf14 = new SimpleDateFormat("dd-MM-yyyy");
					
					long pFechaInicial4 = sdf14.parse(sc.next()).getTime();
					System.out.println("Inserte la fecha final");
					DateFormat sdf24 = new SimpleDateFormat("dd-MM-yyyy");
					
					Timestamp pFechaFinal4 = new Timestamp(sdf24.parse(sc.next()).getTime());
					System.out.println("Inserte el id de usuario");
					long pUsuarioId = sc.nextLong();

					controller.mostrarUsoServiciosAfiliadoDado(pFechaInicial4, pFechaFinal4, pUsuarioId);

					break;

				case 6:

					view.printMenuRegistrarUsuario();
					int option2 = sc.nextInt();
					switch(option2)
					{
					case 1:

						System.out.println("Inserte el reporte");
						String pReporte = sc.next();
						System.out.println("Inserte el id del gerente");
						long idGerente = sc.nextLong();
						System.out.println("Inserte el tipo de gerente");
						String tipoGerente = sc.next();
						System.out.println("Inserte el nombre del gerente");
						String nombreGerente = sc.next();

						controller.registrarGerente(pReporte, idGerente, tipoGerente, nombreGerente);

						break;

					case 2:

						System.out.println("Inserte las caracteristicas del administrador");
						String pCaracteristicas = sc.next();
						System.out.println("Inserte el id del administrador");
						long idAdministrador = sc.nextLong();
						System.out.println("Inserte el id del empleado");
						long idEmp = sc.nextLong();
				
						controller.registrarAdmin(pCaracteristicas, idAdministrador, idEmp);
						break;

					case 3:

						System.out.println("Inserte las caracteristicas del recepcionista");
						String Caracteristicasrecepcionista = sc.next();
						System.out.println("Inserte el id del recepcionista");
						long idrecepcionista = sc.nextLong();
						System.out.println("Inserte el tipo de recepcionista");
						String tiporecepcionista = sc.next();
						System.out.println("Inserte el nombre del recepcionista");
						String nombrerecepcionista = sc.next();

						controller.registrarRecepcionista(Caracteristicasrecepcionista, idrecepcionista, tiporecepcionista, nombrerecepcionista);

						break;

					case 4:

						System.out.println("Inserte el id del medico");
						long idMedico = sc.nextLong();
						System.out.println("Inserte el tipo de medico");
						String tipoMedico = sc.next();
						System.out.println("Inserte el nombre del medico");
						String nombreMedico = sc.next();
						System.out.println("Inserte la especialidad del medico");
						String especialidadMedico = sc.next();
						System.out.println("Inserte el numero de registro del medico");
						int numeroRegistro = sc.nextInt();

						controller.registrarMedico(idMedico, tipoMedico, nombreMedico, especialidadMedico, numeroRegistro);
						break;

					case 5:

						System.out.println("Inserte el id");
						long idUsuario = sc.nextLong();
						System.out.println("Inserte el tipo");
						String tipoUsuario = sc.next();
						System.out.println("Inserte el nombre");
						String nombreUsuario = sc.next();
						System.out.println("Inserte la fecha de nacimiento");
						DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

						Timestamp fechaUsuario = new Timestamp(sdf.parse(sc.next()).getTime());

						controller.registrarUsuario(idUsuario, tipoUsuario, nombreUsuario, fechaUsuario);

						break;
					}
					break;




				case 7:

					System.out.println("Inserte las caracteristicas");
					String caracteristicasIPS = sc.next();
					System.out.println("Inserte el id de la IPS");
					long idIPS = sc.nextLong();
					System.out.println("Inserte el tipo de IPS");
					String tipoIPS = sc.next();
					System.out.println("Inserte la localización");
					String localizacionIPS = sc.next();

					controller.registrarIPS(caracteristicasIPS, idIPS, tipoIPS, localizacionIPS);
					break;


				case 8:

					System.out.println("Inserte el id del servicio de salud");
					long idServicio = sc.nextLong();
					System.out.println("Inserte el tipo de servicio de salud");
					String tipoServico = sc.next();
					System.out.println("Inserte la capacidad del servicio de salud");
					int capacidadServico = sc.nextInt();
					System.out.println("Inserte el pServSalud");
					long pServSalud = sc.nextLong();

					controller.adicionarServSalud(idServicio, tipoServico, capacidadServico, pServSalud);

					break;


				case 9:

					System.out.println("Inserte el id de la campaña");
					long pidCampania = sc.nextLong();
					System.out.println("Inserte la fecha de inicio");
					DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					
					Timestamp pfechainicio = new Timestamp(sdf.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha de fin");
					DateFormat sdfa = new SimpleDateFormat("dd-MM-yyyy");
					
					Timestamp pfechafin = new Timestamp(sdfa.parse(sc.next()).getTime());
					System.out.println("Inserte el nombre de la campaña");
					String pnombrecampania = sc.next();

					System.out.println("Inserte la cantidad de servicios");
					int cantServ = sc.nextInt();
					int i = 0;
					int[] idsSe = new int[cantServ];
					int[] cantRes = new int[cantServ];

					while(i<cantServ)
					{
						System.out.println("Inserte el id " + (i+1) + " de la campaña");
						idsSe[i] = sc.nextInt();
						System.out.println("Inserte la cantReservar " + (i+1) + " de la campaña");
						cantRes[i] = sc.nextInt();
						i++;
					}


					controller.registrarCampania(pidCampania, pfechainicio, pfechafin, pnombrecampania, idsSe, cantRes);

					break;


				case 10:

					System.out.println("Elija lo opción 1 o 2");
					System.out.println("1. Cancelar servicios especificos de la campaña");
					System.out.println("2. Cancelar toda la campaña");

					int opcion = sc.nextInt();

					System.out.println("Inserte el id de la campaña");
					long pidCampania2 = sc.nextLong();

					if(opcion == 1)
					{
						System.out.println("Inserte la cantidad de servicios a cancelar");
						int cantServCance = sc.nextInt();
						int j = 0;
						Long[] idsServCance = new Long[cantServCance];

						while(j<cantServCance)
						{
							System.out.println("Inserte el id a cancelar numero " + (j+1) + " de la campaña");
							idsServCance[j] = sc.nextLong();
							j++;
						}

						controller.cancelarServCampaniaEspec(idsServCance, pidCampania2);
					}
					if(opcion == 2)
					{
						controller.cancelarServCampania(pidCampania2);
					}

					break;

				case 11:

					System.out.println("Inserte la cantidad de servicios a inhabilitar");
					int cantServCance = sc.nextInt();
					int j = 0;
					Long[] idsServCance = new Long[cantServCance];
					Timestamp[] fechasInicio = new Timestamp[cantServCance];
					Timestamp[] fechasFin = new Timestamp[cantServCance];
					Long[] idsIPS = new Long[cantServCance];
					String[] causas = new String[cantServCance];

					while(j<cantServCance)
					{
						System.out.println("Inserte el id de servico a cancelar numero " + (j+1) );
						idsServCance[j] = sc.nextLong();
						System.out.println("Inserte la fecha de inicio numero " + (j+1) );
						DateFormat sdfb = new SimpleDateFormat("dd-MM-yyyy");
						fechasInicio[j] =  new Timestamp(sdfb.parse(sc.next()).getTime());
						System.out.println("Inserte la fecha de fin numero " + (j+1));
						DateFormat sdfb1 = new SimpleDateFormat("dd-MM-yyyy");
						fechasFin[j] =  new Timestamp(sdfb1.parse(sc.next()).getTime());
						System.out.println("Inserte el id de IPS numero " + (j+1) );
						idsIPS[j] = sc.nextLong();
						System.out.println("Inserte la causa numero " + (j+1));
						causas[j] = sc.next();
						j++;
					}


					controller.inhabilitarServ(idsServCance, fechasInicio, fechasFin, idsIPS, causas);
					break;

				case 12:

					System.out.println("Inserte la cantidad de servicios a habilitar");
					int cantServHabi = sc.nextInt();
					int k = 0;
					Long[] idsServHabi = new Long[cantServHabi];

					while(k<cantServHabi)
					{
						System.out.println("Inserte el id a habilitar numero " + (k+1));
						idsServHabi[k] = sc.nextLong();
						k++;
					}

					controller.habilitarServ(idsServHabi);
					break;



				}


				break;

			case 2:	

				view.printMenuMedico();
				int option2 = sc.nextInt();
				switch(option2)
				{
				case 1:

					System.out.println("Inserte las medicinas");
					String med = sc.next();
					System.out.println("Ingrese el id del usuario");
					long idus = sc.nextLong();
					System.out.println("Ingrese el id del medico");
					long idme = sc.nextLong();
					System.out.println("Ingrese la cantidad de ordenes");
					int orde = sc.nextInt();
					Long[] ordenes = new Long[orde];
					Long[] servicios = new Long[orde];
					int i = 0;
					while(i<orde)
					{
						System.out.println("Ingrese el id de la orden numero: " + (i+1) );
						long idord = sc.nextLong();
						ordenes[i] = idord;
						System.out.println("Ingrese el id del servicio numero: " + (i+1) );
						long idser = sc.nextLong();
						servicios[i] = idser;

						i++;
					}

					controller.registrarOrden(med, idus, idme, orde, ordenes, servicios);
					break;
				}
				break;

			case 3:	

				view.printMenuAfiliado();
				int option3 = sc.nextInt();
				switch(option3)
				{
				case 1:

					System.out.println("Inserte la fecha");
					DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp fechaReserva = new Timestamp(sdf.parse(sc.next()).getTime());
					System.out.println("Ingrese el id del servicio de salud");
					long pIdServSalud = sc.nextLong();
					System.out.println("Ingrese el id de la IPS");
					long pIps = sc.nextLong();
					System.out.println("Ingrese el id del usuario");
					long pIdUsuario = sc.nextLong();
					System.out.println("Ingrese el id de la orden");
					long pIdOrden = sc.nextLong();

					controller.reservaServMed(fechaReserva, pIdServSalud, pIps, pIdUsuario, pIdOrden);


					break;
				}

				break;

			case 4:	

				view.printMenuRecepcionista();
				int option4 = sc.nextInt();
				switch(option4)
				{
				case 1:


					System.out.println("Inserte la fecha");
					DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp fechaReserva = new Timestamp(sdf.parse(sc.next()).getTime());
					System.out.println("Ingrese el id del servicio de salud");
					long pIdServSalud = sc.nextLong();
					System.out.println("Ingrese el id de la IPS");
					long pIps = sc.nextLong();
					System.out.println("Ingrese el id del usuario");
					long pIdUsuario = sc.nextLong();
					System.out.println("Ingrese el id del recepcionista");
					long pIdRecepcionista = sc.nextLong();

					controller.registrarPrestServ(fechaReserva, pIdServSalud, pIps, pIdUsuario, pIdRecepcionista);


					break;
				}

				break;

			case 5:

				view.printMenuGerente();
				int option5 = sc.nextInt();
				switch(option5)
				{
				case 1:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaInicial = new Timestamp(sdf.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaFinal= new Timestamp(sdf2.parse(sc.next()).getTime());

					controller.servPrestadosPorIPSEnFechas(pFechaInicial, pFechaFinal);

					break;

				case 2:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaInicial1 = new Timestamp(sdf3.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf4 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaFinal1= new Timestamp(sdf4.parse(sc.next()).getTime());

					controller.mostrar20ServMasSolicitados(pFechaInicial1, pFechaFinal1);

					break;

				case 3:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf5 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaInicial2 = new Timestamp(sdf5.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf6 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaFinal2= new Timestamp(sdf6.parse(sc.next()).getTime());

					controller.mostrarIndiceUso(pFechaInicial2, pFechaFinal2);

					break;

				case 4:

					System.out.println("Inserte el id del recepcionista");
					long idrep = sc.nextLong();
					System.out.println("Inserte el id del servicio de salud");
					long idserv = sc.nextLong();
					System.out.println("Inserte la fecha inicial");
					DateFormat sdf7 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaInicial3 = new Timestamp(sdf7.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha final");
					DateFormat sdf8 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaFinal3= new Timestamp(sdf8.parse(sc.next()).getTime());

					controller.mostrarServiciosConCaracteristica(idrep, idserv, pFechaInicial3, pFechaFinal3);

					break;

				case 5:

					System.out.println("Inserte la fecha inicial");
					DateFormat sdf9 = new SimpleDateFormat("dd-MM-yyyy");
					long pFechaInicial4 = sdf9.parse(sc.next()).getTime();
					System.out.println("Inserte la fecha final");
					DateFormat sdf10 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pFechaFinal4= new Timestamp(sdf10.parse(sc.next()).getTime());
					System.out.println("Inserte el id de usuario");
					long pUsuarioId = sc.nextLong();

					controller.mostrarUsoServiciosAfiliadoDado(pFechaInicial4, pFechaFinal4, pUsuarioId);

					break;


				case 6:
					System.out.println("Inserte las medicinas");
					String med = sc.next();
					System.out.println("Ingrese el id del usuario");
					long idus = sc.nextLong();
					System.out.println("Ingrese el id del medico");
					long idme = sc.nextLong();
					System.out.println("Ingrese la cantidad de ordenes");
					int orde = sc.nextInt();
					Long[] ordenes = new Long[orde];
					Long[] servicios = new Long[orde];
					int i = 0;
					while(i<orde)
					{
						System.out.println("Ingrese el id de la orden numero: " + (i+1) );
						long idord = sc.nextLong();
						ordenes[i] = idord;
						System.out.println("Ingrese el id del servicio numero: " + (i+1) );
						long idser = sc.nextLong();
						servicios[i] = idser;

						i++;
					}

					controller.registrarOrden(med, idus, idme, orde, ordenes, servicios);
					break;

				case 7:

					System.out.println("Inserte la fecha");
					DateFormat sdf11 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp fechaReserva = new Timestamp(sdf11.parse(sc.next()).getTime());
					System.out.println("Ingrese el id del servicio de salud");
					long pIdServSalud = sc.nextLong();
					System.out.println("Ingrese el id de la IPS");
					long pIps = sc.nextLong();
					System.out.println("Ingrese el id del usuario");
					long pIdUsuario = sc.nextLong();
					System.out.println("Ingrese el id de la orden");
					long pIdOrden = sc.nextLong();

					controller.reservaServMed(fechaReserva, pIdServSalud, pIps, pIdUsuario, pIdOrden);

					break;

				case 8:

					System.out.println("Inserte la fecha");
					DateFormat sdf12 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp fechaReserva7 = new Timestamp(sdf12.parse(sc.next()).getTime());
					System.out.println("Ingrese el id del servicio de salud");
					long pIdServSalud7 = sc.nextLong();
					System.out.println("Ingrese el id de la IPS");
					long pIps7 = sc.nextLong();
					System.out.println("Ingrese el id del usuario");
					long pIdUsuario7 = sc.nextLong();
					System.out.println("Ingrese el id del recepcionista");
					long pIdRecepcionista = sc.nextLong();

					controller.registrarPrestServ(fechaReserva7, pIdServSalud7, pIps7, pIdUsuario7, pIdRecepcionista);

					break;


				case 9:

					System.out.println("Inserte el id de la campaña");
					long pidCampania = sc.nextLong();
					System.out.println("Inserte la fecha de inicio");
					DateFormat sdf13 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pfechainicio = new Timestamp(sdf13.parse(sc.next()).getTime());
					System.out.println("Inserte la fecha de fin");
					DateFormat sdf14 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp pfechafin = new Timestamp(sdf14.parse(sc.next()).getTime());
					System.out.println("Inserte el nombre de la campaña");
					String pnombrecampania = sc.next();

					System.out.println("Inserte la cantidad de servicios");
					int cantServ = sc.nextInt();
					int i1 = 0;
					int[] idsSe = new int[cantServ];
					int[] cantRes = new int[cantServ];

					while(i1<cantServ)
					{
						System.out.println("Inserte el id " + (i1+1) + " de la campaña");
						idsSe[i1] = sc.nextInt();
						System.out.println("Inserte la cantReservar " + (i1+1) + " de la campaña");
						cantRes[i1] = sc.nextInt();
						i1++;
					}


					controller.registrarCampania(pidCampania, pfechainicio, pfechafin, pnombrecampania, idsSe, cantRes);

					break;


				case 10:

					System.out.println("Elija lo opción 1 o 2");
					System.out.println("1. Cancelar servicios especificos de la campaña");
					System.out.println("2. Cancelar toda la campaña");

					int opcion = sc.nextInt();

					System.out.println("Inserte el id de la campaña");
					long pidCampania2 = sc.nextLong();

					if(opcion == 1)
					{
						System.out.println("Inserte la cantidad de servicios a cancelar");
						int cantServCance = sc.nextInt();
						int j = 0;
						Long[] idsServCance = new Long[cantServCance];

						while(j<cantServCance)
						{
							System.out.println("Inserte el id a cancelar numero " + (j+1) + " de la campaña");
							idsServCance[j] = sc.nextLong();
							j++;
						}

						controller.cancelarServCampaniaEspec(idsServCance, pidCampania2);
					}
					if(opcion == 2)
					{
						controller.cancelarServCampania(pidCampania2);
					}

					break;

				case 11:

					System.out.println("Inserte la cantidad de servicios a inhabilitar");
					int cantServCance = sc.nextInt();
					int j = 0;
					Long[] idsServCance = new Long[cantServCance];
					Timestamp[] fechasInicio = new Timestamp[cantServCance];
					Timestamp[] fechasFin = new Timestamp[cantServCance];
					Long[] idsIPS = new Long[cantServCance];
					String[] causas = new String[cantServCance];

					while(j<cantServCance)
					{
						System.out.println("Inserte el id de servico a cancelar numero " + (j+1) );
						idsServCance[j] = sc.nextLong();
						System.out.println("Inserte la fecha de inicio numero " + (j+1) );
						DateFormat sdf15 = new SimpleDateFormat("dd-MM-yyyy");	
						fechasInicio[j] = new Timestamp(sdf15.parse(sc.next()).getTime());
						System.out.println("Inserte la fecha de fin numero " + (j+1));
						DateFormat sdf16 = new SimpleDateFormat("dd-MM-yyyy");	
						fechasFin[j] =  new Timestamp(sdf16.parse(sc.next()).getTime());
						System.out.println("Inserte el id de IPS numero " + (j+1) );
						idsIPS[j] = sc.nextLong();
						System.out.println("Inserte la causa numero " + (j+1));
						causas[j] = sc.next();
						j++;
					}


					controller.inhabilitarServ(idsServCance, fechasInicio, fechasFin, idsIPS, causas);
					break;

				case 12:

					System.out.println("Inserte la cantidad de servicios a habilitar");
					int cantServHabi = sc.nextInt();
					int k = 0;
					Long[] idsServHabi = new Long[cantServHabi];

					while(k<cantServHabi)
					{
						System.out.println("Inserte el id a habilitar numero " + (k+1));
						idsServHabi[k] = sc.nextLong();
						k++;
					}

					controller.habilitarServ(idsServHabi);
					break;

				case 13:

					System.out.println("Elija lo opción 1, 2 o 3");
					System.out.println("1. Con mayor demanda");
					System.out.println("2. Con mayor actividad");
					System.out.println("3. Con menor demanda");

					int opcion1 = sc.nextInt();

					System.out.println("Ingrese la unidad de tiempo");
					String unidadTiempo = sc.next();
					System.out.println("Ingrese el id del servicio de salud");
					Long idServSalud = sc.nextLong();
					if(opcion1 == 1)
					{
						controller.analizarOperacionMayorDemanda(unidadTiempo, idServSalud);
					}
					if(opcion1 == 2)
					{
						controller.analizarOperacionMayorActividad(unidadTiempo, idServSalud);
					}
					if(opcion1 == 3)
					{
						controller.analizarOperacionMenorDemanda(unidadTiempo, idServSalud);
					}


					break;

				case 14:

					controller.encontrarAfiliadosExigentes();

					break;

				case 15:

					controller.encontrarServiciosPocaDemanda();

					break;

				case 16:

					view.printMenuRegistrarUsuario();
					int opcion2 = sc.nextInt();
					switch(opcion2)
					{
					case 1:

						System.out.println("Inserte el reporte");
						String pReporte = sc.next();
						System.out.println("Inserte el id del gerente");
						long idGerente = sc.nextLong();
						System.out.println("Inserte el tipo de gerente");
						String tipoGerente = sc.next();
						System.out.println("Inserte el nombre del gerente");
						String nombreGerente = sc.next();

						controller.registrarGerente(pReporte, idGerente, tipoGerente, nombreGerente);

						break;

					case 2:

						System.out.println("Inserte las caracteristicas del administrador");
						String pCaracteristicas = sc.next();
						System.out.println("Inserte el id del administrador");
						long idAdministrador = sc.nextLong();
						System.out.println("Inserte el id del empleado");
						long idEmp = sc.nextLong();
				
						controller.registrarAdmin(pCaracteristicas, idAdministrador, idEmp);

						break;

					case 3:

						System.out.println("Inserte las caracteristicas del recepcionista");
						String Caracteristicasrecepcionista = sc.next();
						System.out.println("Inserte el id del recepcionista");
						long idrecepcionista = sc.nextLong();
						System.out.println("Inserte el tipo de recepcionista");
						String tiporecepcionista = sc.next();
						System.out.println("Inserte el nombre del recepcionista");
						String nombrerecepcionista = sc.next();

						controller.registrarRecepcionista(Caracteristicasrecepcionista, idrecepcionista, tiporecepcionista, nombrerecepcionista);

						break;

					case 4:

						System.out.println("Inserte el id del medico");
						long idMedico = sc.nextLong();
						System.out.println("Inserte el tipo de medico");
						String tipoMedico = sc.next();
						System.out.println("Inserte el nombre del medico");
						String nombreMedico = sc.next();
						System.out.println("Inserte la especialidad del medico");
						String especialidadMedico = sc.next();
						System.out.println("Inserte el numero de registro del medico");
						int numeroRegistro = sc.nextInt();

						controller.registrarMedico(idMedico, tipoMedico, nombreMedico, especialidadMedico, numeroRegistro);
						break;

					case 5:

						System.out.println("Inserte el id");
						long idUsuario = sc.nextLong();
						System.out.println("Inserte el tipo");
						String tipoUsuario = sc.next();
						System.out.println("Inserte el nombre");
						String nombreUsuario = sc.next();
						System.out.println("Inserte la fecha de nacimiento");
						DateFormat sdf15 = new SimpleDateFormat("dd-MM-yyyy");
						Timestamp fechaUsuario = new Timestamp(sdf15.parse(sc.next()).getTime());
						
						controller.registrarUsuario(idUsuario, tipoUsuario, nombreUsuario, fechaUsuario);

						break;
					}
					break;




				case 17:

					System.out.println("Inserte las caracteristicas");
					String caracteristicasIPS = sc.next();
					System.out.println("Inserte el id de la IPS");
					Long idIPS = sc.nextLong();
					System.out.println("Inserte el tipo de IPS");
					String tipoIPS = sc.next();
					System.out.println("Inserte la localización");
					String localizacionIPS = sc.next();

					controller.registrarIPS(caracteristicasIPS, idIPS, tipoIPS, localizacionIPS);
					break;


				case 18:

					System.out.println("Inserte el id del servicio de salud");
					long idServicio = sc.nextLong();
					System.out.println("Inserte el tipo de servicio de salud");
					String tipoServico = sc.next();
					System.out.println("Inserte la capacidad del servicio de salud");
					int capacidadServico = sc.nextInt();
					System.out.println("Inserte el pServSalud");
					long pServSalud = sc.nextLong();

					controller.adicionarServSalud(idServicio, tipoServico, capacidadServico, pServSalud);

					break;
					
				case 19:

					System.out.println("Inserte el id del servicio utilizado");
					long servUtili = sc.nextLong();
					//System.out.println("Inserte tipos de servicios");
					//String tipoServ = sc.next();
					System.out.println("Inserte fecha de inicio");
					DateFormat sdf15 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp fechaInicio = new Timestamp(sdf15.parse(sc.next()).getTime());
					System.out.println("Inserte fecha de fin");
					DateFormat sdf16 = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp fechaFin = new Timestamp(sdf16.parse(sc.next()).getTime());
					System.out.println("Inserte el id de la IPS");
					long ips = sc.nextLong();
					System.out.println("Agrupamiento y Ordenamiento");
					System.out.println("Agrupar y ordenar por: 1.fecha de nacimiento, 2.fecha y número de veces que se utilizó un\r\n" + 
							"servicio, 3.Tipo de servicio, 4.Id IPS");
					int agru = sc.nextInt();
					String agruOrd = "";
					if(agru == 1)
					{
						System.out.println("Inserte rango de fechas de nacimiento");
						System.out.println("Inserte fecha de inicio");
						DateFormat sdf17 = new SimpleDateFormat("dd-MM-yyyy");
						Timestamp fechaInicioNa = new Timestamp(sdf17.parse(sc.next()).getTime());
						System.out.println("Inserte fecha de fin");
						DateFormat sdf18 = new SimpleDateFormat("dd-MM-yyyy");
						Timestamp fechaFinNa = new Timestamp(sdf18.parse(sc.next()).getTime());
						
						agruOrd = "(usuario.fechanacimiento BETWEEN"  + fechaInicioNa + "AND" + fechaFinNa + ")";
					}
					if(agru == 2)
					{
						agruOrd = "usan.fechaatencion";
					}
					if(agru == 3)
					{
						agruOrd = "usan.idservsalud";
					}
					if(agru == 4)
					{
						agruOrd = "serviciosalud.ips";
					}
					
//					System.out.println("Inserte fecha del servicio");
//					DateFormat sdf19 = new SimpleDateFormat("dd-MM-yyyy");
//					Timestamp fechaServ = new Timestamp(sdf19.parse(sc.next()).getTime());
//					System.out.println("Numero de veces de uso del servicio");
//					int numVe = sc.nextInt();
//					System.out.println("Inserte tipos de servicios");
//					String tipoServOrd = sc.next();
//					System.out.println("Inserte las IPS");
//					String ipsOrd = sc.next();

					controller.consultarPresatacionServicios(servUtili, fechaInicio, fechaFin, ips, agruOrd);
					
					break;
					
				case 20:

					System.out.println("Seleccione: 1.Usuarios que no usan ningun servicio\r\n" + 
							"2.Servicios de salud que no son usados\r\n" + 
							"3.IPS que no son usadas en ningun servicio de salud");
					int op = sc.nextInt();
					if(op == 1)
					{
						controller.consultarPresatacionServiciosSinServicioPorUsuario();
					}
					if(op == 2)
					{
						controller.consultarPresatacionServiciosServSaludNoUsados();
					}
					if(op == 3)
					{
						controller.consultarPresatacionServiciosIPSNoUsadas();	
					}
					
					break;
					
				case 21:
					
					System.out.println("Seleccione: 1.El servicio mas usado por semana\r\n" + 
							"2.El servicio menos usado por semana\r\n" + 
							"3.El usuario que mas usa servicios por semana\r\n" +
						    "4. El usuario que menos usa servicios por semana\r\n" +
							"5. El ips menos usado por semana\r\n" +
						    "6. El ips mas usado por semana");
					int op1 = sc.nextInt();
					if(op1 == 1)
					{
						controller.consultarFuncionamientoServMasUsado();
					}
					if(op1 == 2)
					{
						controller.consultarFuncionamientoServMenosUsado();
					}
					if(op1 == 3)
					{
						controller.consultarFuncionamientoUsuarioMasServicioSemana();	
					}
					if(op1 == 4)
					{
						controller.consultarFuncionamientoUsuarioMenosServicioSemana();
					}
					if(op1 == 5)
					{
						controller.consultarFuncionamientoIpsMenosUsadoSemana();
					}
					if(op1 == 6)
					{
						controller.consultarFuncionamientoIpsMasUsadoSemana();	
					}

					break;
					
				case 22:

					System.out.println("Seleccione: 1.Verifica que haya usado 1 al menos 1 vez en el mes\r\n" + 
							"2.Verifica si siempre requieren un serv medico especializado \r\n" + 
							"3.IPS que no son usadas en ningun servicio de salud");
					int op2 = sc.nextInt();
					if(op2 == 1)
					{
						controller.consultarLosAfiliadosCostosos1almes();;
					}
					if(op2 == 2)
					{
						controller.consultarLosAfiliadosCostososServMedicoEspecializado();;
					}
					if(op2 == 3)
					{
						controller.consultarLosAfiliadosCostosos();	
					}

					break;

				}
				break;

			case 6:

				view.printMenuDemo();
				int opcion3 = sc.nextInt();
				switch(opcion3)
				{
				case 1:
					controller.demoAdministrador();

					break;
				case 2:
					demo.demoAfiliado();

					break;
				case 3:
					demo.demoCampania();

					break;
				case 4:
					demo.demoGerente();

					break;
				case 5:
					demo.demoIPS();

					break;
				case 6:
					demo.demoMedico();

					break;
				case 7:
					demo.demoOrden();

					break;
				case 8:
					demo.demoRecepcionista();

					break;
				case 9:
					demo.demoServicioSalud();

					break;
				}
				break;
			case 7:	
				fin=true;
				sc.close();
				break;
			}
		}

	}

	private String next() {
		// TODO Auto-generated method stub
		return null;
	}

	public Gerente registrarGerente(String pReporte, Long id, String tipo, String pNombre)
	{
		return pp.adicionarGerente(pReporte, id, tipo, pNombre);
	}

	public Administrador registrarAdmin(String pCaracteristicas, Long idAdm, Long idEmp)
	{
		return pp.adicionarAdminDatos(pCaracteristicas, idAdm, idEmp);
	}

	public Recepcionista registrarRecepcionista(String pCaracteristicas, Long id, String tipo, String pNombre)
	{
		return pp.adicionarRecepcionista(pCaracteristicas, id, tipo, pNombre);
	}


	public IPS registrarIPS(String pCaracteristicas, Long id, String tipo, String pLocalizacion)

	{
		return pp.adicionarIPS(pCaracteristicas, id, tipo, pLocalizacion);
	}


	public Medico registrarMedico(Long id, String tipo, String pNombre, String pEspecialidad, int pNRegistroMedico)
	{
		return pp.adicionarMedico(id, tipo, pNombre, pEspecialidad, pNRegistroMedico);
	}


	public Usuario registrarUsuario(Long id, String tipo, String pNombre, Timestamp pFechaNacimiento)

	{
		return pp.adicionarUsuario(id, tipo, pNombre, pFechaNacimiento);
	}

	public Orden registrarOrden(String medicinas, long pIdSusuario, long pIdMedico, int ordenesExtra, Long[] idOrdenesExtra, Long[] idServExtra)
	{
		return pp.registrarOrden(medicinas, pIdSusuario, pIdMedico, ordenesExtra, idOrdenesExtra, idServExtra);
	}

	public void reservaServMed(Timestamp fechaReserva, long pIdServSalud, long pIps, long pIdUsuario, long pIdOrden)
	{
		pp.reservaServMed(fechaReserva, pIdServSalud, pIps, pIdUsuario, pIdOrden);
	}

	public void registrarPrestServ(Timestamp fechaReserva, long pIdServSalud, long pIps, long pIdUsuario, long pIdRecepcionista)
	{
		pp.registrarPrestServ(fechaReserva, pIdServSalud, pIps, pIdUsuario, pIdRecepcionista);
	}

	public void servPrestadosPorIPSEnFechas(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		pp.servPrestadosPorIPSEnFechas(pFechaInicial, pFechaFinal);
	}

	public void mostrar20ServMasSolicitados(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		pp.mostrar20ServMasSolicitados(pFechaInicial, pFechaFinal);
	}

	public void mostrarIndiceUso(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		pp.mostrarIndiceUso(pFechaInicial, pFechaFinal);
	}

	public void mostrarServiciosConCaracteristica(long idre, long idser, Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		pp.mostrarServiciosConCaracteristica(idre, idser, pFechaInicial, pFechaFinal);
	}

	public void mostrarUsoServiciosAfiliadoDado(long pFechaInicial, Timestamp pFechaFinal, long pUsuarioId)
	{
		pp.mostrarUsoServiciosAfiliadoDado(pFechaInicial, pFechaFinal, pUsuarioId);
	}

	public List registrarCampania(Long pidCampania, Timestamp pfechainicio, Timestamp pfechafin, String pnombrecampania, int[] idsServ, int[] cantReservar) 
	{
		return pp.registrarCampania(pidCampania, pfechainicio, pfechafin, pnombrecampania, idsServ, cantReservar);
	}

	public void cancelarServCampaniaEspec(Long[] pIdServSalud, long pIdCampania)
	{
		pp.cancelarServCampaniaEspec(pIdServSalud, pIdCampania);
	}

	public void cancelarServCampania(long pIdCampania)
	{
		pp.cancelarServCampania(pIdCampania);
	}

	public void inhabilitarServ(Long[] pidservsalud, Timestamp[] pfechainicio, Timestamp[] pfechafin, Long[] pidips, String[] pcausa)
	{
		pp.inhabilitarServ(pidservsalud, pfechainicio, pfechafin, pidips, pcausa);
	}

	public void habilitarServ(Long[] pidservsalud)
	{
		pp.habilitarServ(pidservsalud);
	}

	public void analizarOperacionMayorDemanda(String unidadTiempo, Long pIdServSalud)
	{
		pp.analizarOperacionMayorDemanda(unidadTiempo, pIdServSalud);
	}

	public void analizarOperacionMayorActividad(String unidadTiempo, Long pIdServSalud)
	{
		pp.analizarOperacionMayorActividad(unidadTiempo, pIdServSalud);
	}

	public void analizarOperacionMenorDemanda(String unidadTiempo, Long pIdServSalud)
	{
		pp.analizarOperacionMenorDemanda(unidadTiempo, pIdServSalud);
	}

	public void encontrarAfiliadosExigentes()
	{
		pp.encontrarAfiliadosExigentes();
	}

	public void encontrarServiciosPocaDemanda()
	{
		pp.encontrarServiciosPocaDemanda();
	}

	public ServicioSalud adicionarServSalud(long id, String tipo, int capacidad, long pServSalud)
	{
		return pp.adicionarServSalud(id, tipo, capacidad, pServSalud);

	}
	
	public void consultarPresatacionServicios(long idServSalud, Timestamp finicio, Timestamp ffin, long idIPS, String agruOrd)
	{
		pp.consultarPresatacionServicios(idServSalud, finicio, ffin, idIPS, agruOrd);
	}
	
	public void consultarPresatacionServiciosSinServicioPorUsuario()
	{
		pp.consultarPresatacionServiciosSinServicioPorUsuario();
	}
	
	public void consultarPresatacionServiciosServSaludNoUsados()
	{
		pp.consultarPresatacionServiciosServSaludNoUsados();
	}
	
	public void consultarPresatacionServiciosIPSNoUsadas()
	{
		pp.consultarPresatacionServiciosIPSNoUsadas();
	}
	
	public void consultarFuncionamientoServMasUsado()
	{
		pp.consultarFuncionamientoServMasUsado();
	}
	
	public void consultarFuncionamientoServMenosUsado()
	{
		pp.consultarFuncionamientoServMenosUsado();
	}
	
	public void consultarFuncionamientoUsuarioMasServicioSemana()
	{
		pp.consultarFuncionamientoUsuarioMasServicioSemana();
	}
	
	public void consultarFuncionamientoUsuarioMenosServicioSemana()
	{
		pp.consultarFuncionamientoUsuarioMenosServicioSemana();
	}
	
	public void consultarFuncionamientoIpsMenosUsadoSemana()
	{
		pp.consultarFuncionamientoIpsMenosUsadoSemana();
	}
	
	public void consultarFuncionamientoIpsMasUsadoSemana()
	{
		pp.consultarFuncionamientoIpsMasUsadoSemana();
	}

	public void consultarLosAfiliadosCostosos1almes()
	{
		pp.consultarLosAfiliadosCostosos1almes();
	}
	
	public void consultarLosAfiliadosCostososServMedicoEspecializado()
	{
		pp.consultarLosAfiliadosCostososServMedicoEspecializado();
	}
	
	public void consultarLosAfiliadosCostosos()
	{
		pp.consultarLosAfiliadosCostosos();
	}
	
	public void demoAdministrador()
	{
		demo.demoAdministrador();
	}

}

