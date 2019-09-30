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
			case 0:
				view.printMessage("Elija el semestre a cargar (1 ó 2)");
				int sem = Integer.parseInt(sc.next());
				view.printMessage("Se cargaran los datos");
				long startTimeA = System.currentTimeMillis();
				long endTimeA = System.currentTimeMillis();
				long durationA = endTimeA - startTimeA;
				System.out.println(durationA);
				break;

			case 1:	

				view.printMessage("Ingresar valor de N: ");
				int cant = Integer.parseInt(sc.next());
				break;

			case 2:	

				view.printMessage("Ingrese la coordenada en X de la localizacion geografica (Ej. 1234,56): ");
				double xcoord = sc.nextDouble();
				view.printMessage("Ingrese la coordenada en Y de la localizacion geografica (Ej. 5678,23): ");
				double ycoord = sc.nextDouble();
				break;

			case 3:	
				view.printMessage("Ingrese la fecha inicial del rango. Formato a�o-mes-dia (ej. 2008-06-21)");
				String fechaInicialStr = sc.next();

				view.printMessage("Ingrese la fecha final del rango. Formato a�o-mes-dia (ej. 2008-06-30)");
				String fechaFinalStr = sc.next();

				break;

			case 4:	

				view.printMessage("1A. Consultar los N tipos de infracción(ViolationCode) con mas infracciones que desea ver. Ingresar valor de N: ");
				int cantB = Integer.parseInt(sc.next());
				break;

			case 5:

				view.printMessage("Ingrese la coordenada en X de la localizacion geografica (Ej. 1234,56): ");
				double xcoord1 = sc.nextDouble();
				view.printMessage("Ingrese la coordenada en Y de la localizacion geografica (Ej. 5678,23): ");
				double ycoord1 = sc.nextDouble();
				break;
				
			case 6:
				
				view.printMessage("Ingrese el valor minimo: ");
				int minimo = sc.nextInt();
				view.printMessage("Ingrese el valor maximo: ");
				int maximo = sc.nextInt();
				
				break;
				

			case 7: 

				view.printMessage("Ingrese el AddressID: ");
				int addId = sc.nextInt();
				int startTimeB = (int) System.currentTimeMillis();
				int endTimeB = (int) System.currentTimeMillis();
				int durationB = endTimeB - startTimeB;
				System.out.println("Tiempo de ejecucion: " + durationB);

				break;

			case 8: 

				view.printMessage("Ingrese la hora inicial (Ej. 00:00:00)");
				String HoraInicial = sc.next();
				view.printMessage("Ingrese la hora final (Ej. 23:59:00)");
				String HoraFinal = sc.next();
				int startTimeC = (int) System.currentTimeMillis();
				int endTimeC = (int) System.currentTimeMillis();
				int durationC = endTimeC - startTimeC;
				System.out.println("Tiempo de ejecucion: " + durationC);
				break;

			case 9: 

				view.printMessage("Ingresar valor de N: (max 4967) ");
				int cant1 = Integer.parseInt(sc.next());
				int startTimeD = (int) System.currentTimeMillis();
				int endTimeD = (int) System.currentTimeMillis();
				int durationD = endTimeD - startTimeD;
				System.out.println("Tiempo de ejecucion: " + durationD);
				break;
				
			case 10:
				
				int startTimeE = (int) System.currentTimeMillis();
				int endTimeE = (int) System.currentTimeMillis();
				int durationE = endTimeE - startTimeE;
				System.out.println("Tiempo de ejecucion: " + durationE);
				break;

			case 11:	
				fin=true;
				sc.close();
				break;
			}
		}

	}

	}
