package uniandes.isis2304.epsandes.interfazDemo;

import java.sql.Timestamp;
import java.util.List;

import uniandes.isis2304.epsandes.negocio.Administrador;
import uniandes.isis2304.epsandes.negocio.EPSAndes;
import uniandes.isis2304.epsandes.negocio.Gerente;
import uniandes.isis2304.epsandes.negocio.IPS;
import uniandes.isis2304.epsandes.negocio.Medico;
import uniandes.isis2304.epsandes.negocio.Orden;
import uniandes.isis2304.epsandes.negocio.Recepcionista;
import uniandes.isis2304.epsandes.negocio.ServicioSalud;
import uniandes.isis2304.epsandes.negocio.Usuario;



public class EPSAndesDemo {

	private EPSAndes epsAndes;
	
	
	public void demoIPS( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			String pCaracteristicas = "Buena calidad de ips";
			long idIps = 123456789;
			String tipoIps = "Privada";
			String localizacionIps = "Usaquen";
			boolean errorIPS= false;

			IPS IPS = epsAndes.registrarIPS(pCaracteristicas, idIps, tipoIps, localizacionIps);
			if (IPS == null)
			{
				errorIPS = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de IPS\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorIPS)
			{
				resultado += "*** Exception creando IPS !!\n";
				resultado += "*** Es probable que esa IPS ya existiera y hay restricción de UNICIDAD sobre el id de la IPS\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado la ips con el id: " + idIps + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void demoMedico( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long idMedico = (long) 123456789;
			String tipoMedico = "Familiar";
			String nombreMedico = "Mario";
			String pEspecialidad = "Cirujano";
			int pNRegistroMedico = 14;
			boolean errorMedico= false;

			Medico medico = epsAndes.registrarMedico(idMedico, tipoMedico, nombreMedico, pEspecialidad, pNRegistroMedico);
			if (medico == null)
			{
				errorMedico = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de medicos\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorMedico)
			{
				resultado += "*** Exception creando Medico !!\n";
				resultado += "*** Es probable que ese Medico ya existiera y hay restricción de UNICIDAD sobre el id de el Medico\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado el medico con el id: " + idMedico + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void demoAfiliado( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long idAfiliado = (long) 123456789;
			String tipoAfiliado = "Preferencial";
			String nombreAfiliado = "Camilo";
			Timestamp pFechaNacimiento = new Timestamp(987654321);
			boolean errorAfiliado= false;

			Usuario afiliado = epsAndes.registrarUsuario(idAfiliado, tipoAfiliado, nombreAfiliado, pFechaNacimiento);
			if (afiliado == null)
			{
				errorAfiliado = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de afiliados\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorAfiliado)
			{
				resultado += "*** Exception creando Afiliado !!\n";
				resultado += "*** Es probable que ese Afiliado ya existiera y hay restricción de UNICIDAD sobre el id de el Afiliado\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado el afiliado con el id: " + idAfiliado + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void demoServicioSalud( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long idServicioSalud = (long) 123456789;
			String tipoServicioSalud = "Cita medica";
			int capacidad = 12;
			long pServSalud = 918273654;
			boolean errorServicioSalud= false;

			ServicioSalud servicioSalud = epsAndes.adicionarServSalud(idServicioSalud, tipoServicioSalud, capacidad, pServSalud);
			if (servicioSalud == null)
			{
				errorServicioSalud = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de servicios de salud\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorServicioSalud)
			{
				resultado += "*** Exception creando ServicioSalud !!\n";
				resultado += "*** Es probable que ese ServicioSalud ya existiera y hay restricción de UNICIDAD sobre el id de el ServicioSalud\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado el servicio de salud con el id: " + idServicioSalud + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void demoGerente( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long idGerente = (long) 123456789;
			String tipoGerente = "Principal";
			String pReporte = "Todo el gerente";
			String nombre = "Andres";
			boolean errorGerente= false;

			Gerente gerente = epsAndes.registrarGerente(pReporte, idGerente, tipoGerente, nombre);
			if (gerente == null)
			{
				errorGerente = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Gerentes\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorGerente)
			{
				resultado += "*** Exception creando Gerente !!\n";
				resultado += "*** Es probable que ese Gerente ya existiera y hay restricción de UNICIDAD sobre el id de el Gerente\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado el gerente con el id: " + idGerente + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void demoAdministrador( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long idAdministrador = (long) 123456789;
			String caracteristicasAdmin = "Principal";
			String tipoAdministrador = "Todo el gerente";
			String nombreAdministrador = "Andres";
			boolean errorAdministrador= false;

			Administrador administrador = epsAndes.registrarAdmin(caracteristicasAdmin, idAdministrador, tipoAdministrador, nombreAdministrador);
			if (administrador == null)
			{
				errorAdministrador = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Admistradoes\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorAdministrador)
			{
				resultado += "*** Exception creando Administrador !!\n";
				resultado += "*** Es probable que ese Administrador ya existiera y hay restricción de UNICIDAD sobre el id de el Administrador\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado el administrador con el id: " + idAdministrador + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void demoCampania( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long pidCampania = (long) 123456789;
			Timestamp pfechainicio = new Timestamp(932749823);
			Timestamp pfechafin = new Timestamp(932749824);
			String pnombrecampania = "Todo el gerente";
			int[] idsServ = new int[2];
			int[] cantReservar = new int[2];
			boolean errorCampania= false;

			List Campania = epsAndes.registrarCampania(pidCampania, pfechainicio, pfechafin, pnombrecampania, idsServ, cantReservar);
			if (Campania == null)
			{
				errorCampania = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Campañas\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorCampania)
			{
				resultado += "*** Exception creando Campania !!\n";
				resultado += "*** Es probable que ese Campania ya existiera y hay restricción de UNICIDAD sobre el id de el Campania\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado la campaña con el id: " + pidCampania + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void demoOrden( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long pIdSusuario = (long) 123456789;
			String medicinas = "Dolex";
			Long pIdMedico = (long) 896768445;
			int ordenesExtra = 2;
			Long[] idOrdenesExtra = new Long[2];
			Long[] idServExtra = new Long[2];
			boolean errorOrden= false;

			Orden orden = epsAndes.registrarOrden(medicinas, pIdSusuario, pIdMedico, ordenesExtra, idOrdenesExtra, idServExtra);
			if (orden == null)
			{
				errorOrden = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Ordenes\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorOrden)
			{
				resultado += "*** Exception creando Orden !!\n";
				resultado += "*** Es probable que ese Orden ya existiera y hay restricción de UNICIDAD sobre el id de el Orden\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado la orden con los medicamentos: " + medicinas + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void demoRecepcionista( )
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código

			Long idRecepcionista = (long) 123456789;
			String pCaracteristicas = "Oficina piso 1";
			String tipoRecepcionista = "Principal";
			String nombreRecepcionista = "Gabriela";
			boolean errorRecepcionista= false;

			
			Recepcionista Recepcionista = epsAndes.registrarRecepcionista(pCaracteristicas, idRecepcionista, tipoRecepcionista, nombreRecepcionista);
			if (Recepcionista == null)
			{
				errorRecepcionista = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de IPS\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorRecepcionista)
			{
				resultado += "*** Exception creando Recepcionista !!\n";
				resultado += "*** Es probable que ese Recepcionista ya existiera y hay restricción de UNICIDAD sobre el id de el Recepcionista\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado el recepnionista con el id: " + idRecepcionista + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
