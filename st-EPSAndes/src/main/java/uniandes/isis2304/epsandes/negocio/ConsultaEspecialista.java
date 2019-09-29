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

/**
 * Clase para modelar el concepto BEBIDA del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class ConsultaEspecialista implements VOConsultaEspecialista
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la Remision al especialista
	 */
	private long id;
	
	/**
	 * El nombre de la Remision al especialista
	 */
	private long idMedico;
	
	private long idServSalud;
	
	private String dolencia;
	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ConsultaEspecialista() 
	{
		this.id = 0;
		this.idMedico = 0;
		this.dolencia = "";
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la Remision al especialista
	 * @param nombre - El idMedico de la Remision al especialista
	 */
	public ConsultaEspecialista(long id, long idMedico, String dolencia, long servSalud) 
	{
		this.id = id;
		this.idMedico = idMedico;
		this.dolencia = dolencia;
		this.idServSalud = servSalud;
	}

	/**
	 * @return El id de la Remision al especialista
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @param id - El nuevo id de la Remision al especialista 
	 */
	public void setId(long id) 
	{
		this.id = id;
	}

	/**
	 * @return El nombre de la Remision al especialista
	 */
	public long getIdMedico() 
	{
		return idMedico;
	}

	/**
	 * @param nombre - El nuevo nombre de la Remision al especialista
	 */
	public void setIdMedico(long nombre) 
	{
		this.idMedico = idMedico;
	}

	/**


	/**
	 * @return Una cadena con la información básica de la bebida
	 */
	@Override
	public String toString() 
	{
		return "Bebida [id=" + id + ", nombre=" + idMedico + "]";
	}

	public Long getIdServSalud() {
		return idServSalud;
	}

	public void setIdServSalud(Long idServSalud) {
		this.idServSalud = idServSalud;
	}

	public String getDolencia() {
		return dolencia;
	}

	public void setDolencia(String dolencia) {
		this.dolencia = dolencia;
	}

	
	
}
