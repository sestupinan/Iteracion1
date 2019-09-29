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

import java.util.List;

/**
 * Interfaz para los métodos get de BEBEDOR.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Germán Bravo
 */
public interface VOConsultaUrgencias 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la consulta medica
	 */
	public long getId();

	/**
	 * @return El nombre de la consulta medica
	 */
	public String getTriage();

	/**
	 * @return La ciudad de la consulta medica
	 */
	public long getIdMedico();

	/**
	 * @return El presupuesto de la consulta medica
	 */
	public long getIdExamenDiagnostico();
	
	public long getIdConsulta();
	
	public long getIdHospitalizacion();
	
	public boolean getDadoDeAlta();


	/**
	 * @return Una cadena de caracteres con la información básica de la consulta medica
	 */
	@Override
	public String toString();

	/**
	 * @return Una cadena de caracteres con la información COMPLEtA de la consulta medica.
	 * Además de la información básica, contiene las visitas realizadas (una por línea) y 
	 * las bebidas que le gustan al bebedor (una por línea)
	 */
	

}
