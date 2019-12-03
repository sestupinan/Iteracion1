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
	public long idHosp;
	
	/**
	 * El identificador de la bebida que es servida en el bar
	 */
	public long IPS;
	
	/**
	 * El horario en que sirve la bebida en el bar (BUENO, REGULAR, MALO, CRITICO)
	 */
	public String estadoSalud;
	
	public int visitas;
	
	public long idServSalud;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Hospitalizacion () 
	{
		this.idHosp = 0;
		this.IPS = 0;
		this.estadoSalud = "";
		this.visitas = 0;
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 * @param idBar - El identificador del bar. Debe exixtir un bar con dicho identificador
	 * @param idBebida - El identificador de la bebida. Debe existir una bebida con dicho identificador
	 * @param horario - El horario en el que el bar sirve la bebida (DIURNO, NOCTURNO, TODOS)
	 */
	public Hospitalizacion (long id, long IPS, String estadoSalud, int visitas, long idSer) 
	{
		this.idHosp = id;
		this.IPS = IPS;
		this.estadoSalud = estadoSalud;
		this.visitas = visitas;
		this.idServSalud = idSer;
	}

	
	public long getIdHosp() {
		return idHosp;
	}

	public void setIdHosp(long idHosp) {
		this.idHosp = idHosp;
	}

	public long getIPS() {
		return IPS;
	}

	public void setIPS(long iPS) {
		IPS = iPS;
	}

	public String getEstadoSalud() {
		return estadoSalud;
	}

	public void setEstadoSalud(String estadoSalud) {
		this.estadoSalud = estadoSalud;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	public long getIdServSalud() {
		return idServSalud;
	}

	public void setIdServSalud(long idServSalud) {
		this.idServSalud = idServSalud;
	}

	@Override
	public String toString() {
		return "Hospitalizacion [idHosp=" + idHosp + ", IPS=" + IPS + ", estadoSalud=" + estadoSalud + ", visitas="
				+ visitas + ", idServSalud=" + idServSalud + "]";
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	

}
