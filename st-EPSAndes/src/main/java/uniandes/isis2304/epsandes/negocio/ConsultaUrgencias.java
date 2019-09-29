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
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para modelar el concepto BEBEDOR del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class ConsultaUrgencias implements VOConsultaUrgencias
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la consulta de urgencias
	 */
	private long id;	
	
	/**
	 * El triage de la consulta de urgencias
	 */
	private String triage;
	
	/**
	 * El idMedico de la consulta de urgencias
	 */
	private long idMedico;
	
	/**
	 * El idExamenDiagnostico de la consulta de urgencias 
	 */
	private long idExamenDiagnostico;
	
	/**
	 * El idConsulta de la consulta de urgencias 
	 */
	private long idConsulta;
	
	/**
	 * El idHospitalizacion de la consulta de urgencias 
	 */
	private long idHospitalizacion;
	
	/**
	 * El estado de dada de alta de la consulta de urgencias 
	 */
	private boolean dadoDeAlta;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ConsultaUrgencias() 
	{
		this.id = 0;
		this.triage = "";
		this.idMedico = 0;
		this.idExamenDiagnostico = 0;
		this.idConsulta = 0;
		this.idHospitalizacion = 0;
		this.dadoDeAlta = false;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la consulta de urgencias
	 * @param triage - El triage de la consulta de urgencias
	 * @param idMedico - El idMedico de la consulta de urgencias
	 * @param idExamenDiagnostico - El idExamenDiagnostico de la consulta de urgencias 
	 */
	public ConsultaUrgencias(long id, String triage, long idMedico, long idExamenDiagnostico, long idConsulta, long idHospitalizacion, boolean dadoDeAlta) 
	{
		this.id = id;
		this.triage = triage;
		this.idMedico = idMedico;
		this.idExamenDiagnostico = idExamenDiagnostico;
		this.idConsulta = idConsulta;	
		this.idHospitalizacion = idHospitalizacion;
		this.dadoDeAlta = dadoDeAlta;
	}

	/**
	 * @return El id de la consulta de urgencias
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @param id - El nuevo id de la consulta de urgencias
	 */
	public void setId(long id) 
	{
		this.id = id;
	}

	/**
	 * @return El triage de la consulta de urgencias
	 */
	public String getTriage() 
	{
		return triage;
	}

	/**
	 * @param triage - El nuevo triage de la consulta de urgencias
	 */
	public void setTriage(String triage) 
	{
		this.triage = triage;
	}

	/**
	 * @return El idMedico de la consulta de urgencias
	 */
	public long getIdMedico() 
	{
		return idMedico;
	}

	/**
	 * @param idMedico - La nueva idMedico de la consulta de urgencias
	 */
	public void setIdMedico(long idMedico) 
	{
		this.idMedico = idMedico;
	}

	/**
	 * @return El idExamenDiagnostico de la consulta de urgencias
	 */
	public long getIdExamenDiagnostico() 
	{
		return idExamenDiagnostico;
	}

	/**
	 * @param idExamenDiagnostico - El nuevo idExamenDiagnostico de la consulta de urgencias
	 */
	public void setIdExamenDiagnostico(long idExamenDiagnostico) 
	{
		this.idExamenDiagnostico = idExamenDiagnostico;
	}
	
	/**
	 * @return El idExamenDiagnostico de la consulta de urgencias
	 */
	public long getIdConsulta() 
	{
		return idConsulta;
	}

	/**
	 * @param idConsulta - El nuevo idConsulta de la consulta de urgencias
	 */
	public void setIdConsulta(long idConsulta) 
	{
		this.idConsulta = idConsulta;
	}
	
	/**
	 * @return El idHospitalizacion de la consulta de urgencias
	 */
	public long getIdHospitalizacion() 
	{
		return idHospitalizacion;
	}

	/**
	 * @param idHospitalizacion - El nuevo idHospitalizacion de la consulta de urgencias
	 */
	public void setIdHospitalizacion(long idHospitalizacion) 
	{
		this.idHospitalizacion = idHospitalizacion;
	}
	
	/**
	 * @return El estado de dada de alta de la consulta de urgencias
	 */
	public boolean getDadoDeAlta() 
	{
		return dadoDeAlta;
	}

	/**
	 * @param dadoDeAlta - El nuevo estado de dada de alta de la consulta de urgencias
	 */
	public void setDadoDeAlta(boolean dadoDeAlta) 
	{
		this.dadoDeAlta = dadoDeAlta;
	}


	/**
	 * @return Una cadena de caracteres con la información básica de la consulta de urgencias
	 */
	@Override
	public String toString() 
	{
		return "Bebedor [id=" + id + ", triage=" + triage + ", idMedico=" + idMedico + ", dadoDeAlta=" + dadoDeAlta + "]";
	}


}
