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
	private Long idConsUrgen;	
	
	/**
	 * El triage de la consulta de urgencias
	 */
	private String triage;
	
	/**
	 * El idMedico de la consulta de urgencias
	 */
	private Long idMedico;
	

	
	/**
	 * El idConsulta de la consulta de urgencias 
	 */
	private Long idServSalud;
	
	
	/**
	 * El estado de dada de alta de la consulta de urgencias 
	 */
	private Boolean dadaAlta;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ConsultaUrgencias() 
	{
		this.idConsUrgen = 0L;
		this.triage = "";
		this.idMedico = 0L;
		this.idServSalud = 0L;
		this.dadaAlta = false;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la consulta de urgencias
	 * @param triage - El triage de la consulta de urgencias
	 * @param idMedico - El idMedico de la consulta de urgencias
	 * @param idExamenDiagnostico - El idExamenDiagnostico de la consulta de urgencias 
	 */
	public ConsultaUrgencias(long id, String triage, long idMedico, long idServSalud, boolean dadaAlta) 
	{
		this.idConsUrgen = id;
		this.triage = triage;
		this.idMedico = idMedico;
		this.idServSalud = idServSalud;	
		this.dadaAlta = dadaAlta;
	}

	/**
	 * @return El id de la consulta de urgencias
	 */
	public Long getId() 
	{
		return idConsUrgen;
	}

	/**
	 * @param id - El nuevo id de la consulta de urgencias
	 */
	public void setId(Long id) 
	{
		this.idConsUrgen = id;
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
	public Long getIdMedico() 
	{
		return idMedico;
	}

	/**
	 * @param idMedico - La nueva idMedico de la consulta de urgencias
	 */
	public void setIdMedico(Long idMedico) 
	{
		this.idMedico = idMedico;
	}

	
	/**
	 * @return El idExamenDiagnostico de la consulta de urgencias
	 */
	public Long getServSalud() 
	{
		return idServSalud;
	}

	/**
	 * @param idConsulta - El nuevo idConsulta de la consulta de urgencias
	 */
	public void setIdServSalud(Long idConsulta) 
	{
		this.idServSalud = idConsulta;
	}
	
	/**
	 * @return El estado de dada de alta de la consulta de urgencias
	 */
	public Boolean getDadoDeAlta() 
	{
		return dadaAlta;
	}

	/**
	 * @param dadaAlta - El nuevo estado de dada de alta de la consulta de urgencias
	 */
	public void setDadoDeAlta(boolean dadaAlta) 
	{
		this.dadaAlta = dadaAlta;
	}


	/**
	 * @return Una cadena de caracteres con la información básica de la consulta de urgencias
	 */
	@Override
	public String toString() 
	{
		return "Bebedor [id=" + idConsUrgen + ", triage=" + triage + ", idMedico=" + idMedico + ", dadaAlta=" + dadaAlta + "]";
	}


}
