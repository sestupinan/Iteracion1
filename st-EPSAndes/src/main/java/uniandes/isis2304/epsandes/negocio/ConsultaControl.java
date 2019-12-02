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
 * Clase para modelar la relación GUSTAN del negocio de los Parranderos:
 * Cada objeto de esta clase representa el hecho que un bebedor gusta de una consulta de control y viceversa.
 * Se modela mediante los identificadores del bebedor y de la consulta de control respectivamente.
 * Debe existir un bebedor con el identificador dado
 * Debe existir una consulta de control con el identificador dado 
 * 
 * @author Germán Bravo
 */
public class ConsultaControl implements VOConsultaControl
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la consulta de control
	 */
	private long idConsCont;

	/**
	 * La efectividad de la consulta de control
	 */
	private String efectividad;
	
	private String resultado;
	
	private String tratamiento;
	
	private Long idHospitaliz;
	
	private Long idServSalud;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ConsultaControl() 
	{
		this.idConsCont = 0;
		this.efectividad = "";
		this.resultado = "";
		this.tratamiento = "";
		this.idHospitaliz = 0L;
		this.idServSalud = 0L;
	}

	/**
	 * Constructor con valores
	 * @param idBebedor - El identificador del bebedor. Debe exixtir un bebedor con dicho identificador
	 * @param idBebida - El identificador de la consulta de control. Debe existir una consulta de control con dicho identificador
	 */
	public ConsultaControl(long id, String efectividad, String resultado, String tratamiento, long idHosp, long idServSalud) 
	{
		this.idConsCont = id;
		this.efectividad = efectividad;
		this.resultado = "";
		this.tratamiento = "";
		this.idHospitaliz = idHosp;
		this.idServSalud = idServSalud;
	}
	
	
	public long getId() {
		// TODO Auto-generated method stub
		return idConsCont;
	}

	public void setId(long id) 
	{
		this.idConsCont = id;
	}

	public String getEfectividad() {
		// TODO Auto-generated method stub
		return efectividad;
	}

	
	public String getResultado() {
		// TODO Auto-generated method stub
		return resultado;
	}

	public String getTratamiento() {
		// TODO Auto-generated method stub
		return tratamiento;
	}


	
	public void setEfectividad(String efectividad) {
		this.efectividad = efectividad;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	
	public Long getIdHospitalizacion() {
		return idHospitaliz;
	}

	public void setIdHospitalizacion(Long idHospitalizacion) {
		this.idHospitaliz = idHospitalizacion;
	}

	public Long getIdServSalud() {
		return idServSalud;
	}

	public void setIdServSalud(Long idServSalud) {
		this.idServSalud = idServSalud;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Consulta de control [id=" + idConsCont + ", efectividad=" + efectividad + "]";
	}
}
