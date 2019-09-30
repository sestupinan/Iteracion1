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

package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;


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
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(EPSAndes.class.getName());

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaEPSAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public EPSAndes ()
	{
		pp = PersistenciaEPSAndes.getInstance ();
		view = new EPSAndesview();
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

	public void run() {
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
					Timestamp pFechaInicial = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal = new Timestamp(sc.nextLong());

					controller.servPrestadosPorIPSEnFechas(pFechaInicial, pFechaFinal);

					break;

				case 2:

					System.out.println("Inserte la fecha inicial");
					Timestamp pFechaInicial1 = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal1 = new Timestamp(sc.nextLong());

					controller.mostrar20ServMasSolicitados(pFechaInicial1, pFechaFinal1);

					break;

				case 3:

					System.out.println("Inserte la fecha inicial");
					Timestamp pFechaInicial2 = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal2 = new Timestamp(sc.nextLong());

					controller.mostrarIndiceUso(pFechaInicial2, pFechaFinal2);

					break;

				case 4:

					System.out.println("Inserte la fecha inicial");
					Timestamp pFechaInicial3 = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal3 = new Timestamp(sc.nextLong());

					controller.mostrarServiciosConCaracteristica(pFechaInicial3, pFechaFinal3);

					break;

				case 5:

					System.out.println("Inserte la fecha inicial");
					long pFechaInicial4 = sc.nextLong();
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal4 = new Timestamp(sc.nextLong());
					System.out.println("Inserte el id de usuario");
					long pUsuarioId = sc.nextLong();

					controller.mostrarUsoServiciosAfiliadoDado(pFechaInicial4, pFechaFinal4, pUsuarioId);

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
					Timestamp fechaReserva = new Timestamp(sc.nextLong());
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
					Timestamp fechaReserva = new Timestamp(sc.nextLong());
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
					Timestamp pFechaInicial = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal = new Timestamp(sc.nextLong());

					controller.servPrestadosPorIPSEnFechas(pFechaInicial, pFechaFinal);

					break;

				case 2:

					System.out.println("Inserte la fecha inicial");
					Timestamp pFechaInicial1 = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal1 = new Timestamp(sc.nextLong());

					controller.mostrar20ServMasSolicitados(pFechaInicial1, pFechaFinal1);

					break;

				case 3:

					System.out.println("Inserte la fecha inicial");
					Timestamp pFechaInicial2 = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal2 = new Timestamp(sc.nextLong());

					controller.mostrarIndiceUso(pFechaInicial2, pFechaFinal2);

					break;

				case 4:

					System.out.println("Inserte la fecha inicial");
					Timestamp pFechaInicial3 = new Timestamp(sc.nextLong());
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal3 = new Timestamp(sc.nextLong());

					controller.mostrarServiciosConCaracteristica(pFechaInicial3, pFechaFinal3);

					break;

				case 5:

					System.out.println("Inserte la fecha inicial");
					long pFechaInicial4 = sc.nextLong();
					System.out.println("Inserte la fecha final");
					Timestamp pFechaFinal4 = new Timestamp(sc.nextLong());
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
					Timestamp fechaReserva = new Timestamp(sc.nextLong());
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
					Timestamp fechaReserva7 = new Timestamp(sc.nextLong());
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
				}
				break;

			case 6:	
				fin=true;
				sc.close();
				break;
			}
		}

	}

	public void registrarOrden(String medicinas, long pIdSusuario, long pIdMedico, int ordenesExtra, Long[] idOrdenesExtra, Long[] idServExtra)
	{
		pp.registrarOrden(medicinas, pIdSusuario, pIdMedico, ordenesExtra, idOrdenesExtra, idServExtra);
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
	public void mostrarServiciosConCaracteristica(Timestamp pFechaInicial, Timestamp pFechaFinal)
	{
		pp.mostrarServiciosConCaracteristica(pFechaInicial, pFechaFinal);
	}
	public void mostrarUsoServiciosAfiliadoDado(long pFechaInicial, Timestamp pFechaFinal, long pUsuarioId)
	{
		pp.mostrarUsoServiciosAfiliadoDado(pFechaInicial, pFechaFinal, pUsuarioId);
	}
}
