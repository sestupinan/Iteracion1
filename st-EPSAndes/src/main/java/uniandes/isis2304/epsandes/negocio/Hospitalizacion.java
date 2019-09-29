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
 * Clase para modelar la relación SIRVEN del negocio de los Parranderos:
 * Cada objeto de esta clase representa el hecho que un bar sirve una bebida y viceversa.
 * Se modela mediante los identificadores del bar y de la bebida respectivamente
 * Debe existir un bar con el identificador dado
 * Debe existir una bebida con el identificador dado 
 * Adicionalmente contiene el horario (DIURNO, NOCTURNO, TODOS) en el cual el bar sirve la bebida
 * 
 * @author Germán Bravo
 */
public class Hospitalizacion implements VOHospitalizacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la hospitalizacion
	 */
	private long id;
	
	/**
	 * El identificador de la bebida que es servida en el bar
	 */
	private long idIPS;
	
	/**
	 * El horario en que sirve la bebida en el bar (BUENO, REGULAR, MALO, CRITICO)
	 */
	private String estadoSalud;
	
	private long idConsultaControl;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Hospitalizacion () 
	{
		this.id = 0;
		this.idIPS = 0;
		this.estadoSalud = "";
		this.idConsultaControl = 0;
	}

	/**
	 * Constructor con valores
	 * @param idBar - El identificador del bar. Debe exixtir un bar con dicho identificador
	 * @param idBebida - El identificador de la bebida. Debe existir una bebida con dicho identificador
	 * @param horario - El horario en el que el bar sirve la bebida (DIURNO, NOCTURNO, TODOS)
	 */
	public Hospitalizacion (long id, long idIPS, String estadoSalud, long idConsultaContral) 
	{
		this.id = id;
		this.idIPS = idIPS;
		this.estadoSalud = estadoSalud;
		this.idConsultaControl = idConsultaControl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdIPS() {
		return idIPS;
	}

	public void setIdIPS(long idIPS) {
		this.idIPS = idIPS;
	}

	public String getEstadoSalud() {
		return estadoSalud;
	}

	public void setEstadoSalud(String estadoSalud) {
		this.estadoSalud = estadoSalud;
	}

	public long getIdConsultaControl() {
		return idConsultaControl;
	}

	public void setIdConsultaControl(long idConsultaControl) {
		this.idConsultaControl = idConsultaControl;
	}
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Sirven [idBar=" + id + ", idBebida=" + idIPS + ", horario=" + estadoSalud + "]";
	}

}
