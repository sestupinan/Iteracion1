package uniandes.isis2304.epsandes.interfazDemo;

import java.sql.Timestamp;
import java.util.List;

import uniandes.isis2304.epsandes.negocio.EPSAndes;
import uniandes.isis2304.epsandes.negocio.IPS;
import uniandes.isis2304.epsandes.negocio.Medico;
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
			String resultado = "Demo de creación y listado de IPS\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorMedico)
			{
				resultado += "*** Exception creando Medico !!\n";
				resultado += "*** Es probable que ese Medico ya existiera y hay restricción de UNICIDAD sobre el id de el Medico\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado la ips con el id: " + idMedico + "\n";
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
			String resultado = "Demo de creación y listado de IPS\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorAfiliado)
			{
				resultado += "*** Exception creando Afiliado !!\n";
				resultado += "*** Es probable que ese Afiliado ya existiera y hay restricción de UNICIDAD sobre el id de el Afiliado\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado la ips con el id: " + idAfiliado + "\n";
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
			String resultado = "Demo de creación y listado de IPS\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorServicioSalud)
			{
				resultado += "*** Exception creando ServicioSalud !!\n";
				resultado += "*** Es probable que ese ServicioSalud ya existiera y hay restricción de UNICIDAD sobre el id de el ServicioSalud\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado la ips con el id: " + idServicioSalud + "\n";
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
			String
			long pServSalud = 918273654;
			boolean errorServicioSalud= false;

			ServicioSalud servicioSalud = epsAndes.registrarGerente(pReporte, id, tipo, pNombre);
			if (servicioSalud == null)
			{
				errorServicioSalud = true;
			}

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de IPS\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorServicioSalud)
			{
				resultado += "*** Exception creando ServicioSalud !!\n";
				resultado += "*** Es probable que ese ServicioSalud ya existiera y hay restricción de UNICIDAD sobre el id de el ServicioSalud\n";
				resultado += "*** Revise el log de EPS Andes para más detalles\n";
			}
			resultado += "Adicionado la ips con el id: " + idServicioSalud + "\n";
			resultado += "\n Demo terminada";

			System.out.println(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}



}
