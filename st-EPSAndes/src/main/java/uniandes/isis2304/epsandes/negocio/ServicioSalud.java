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

import java.sql.Date;

/**
 * Clase para modelar el concepto BAR del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class ServicioSalud implements VOServicioSalud
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del horario de bebida
	 */
	public long idServSalud;

	/**
	 * El nombre del horario de bebida
	 */
	public Date horario;
	
	public int capacidad;
	
	public long idIPS;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	

	/**
	 * Constructor con valores
	 * @param id - El identificador del horario de bebida
	 * @param nombre - El nombre del horario de bebida
	 */
	public ServicioSalud(long id, Date horario, int capacidad, long pServSalud) 
	{
		this.idServSalud = id;
		this.horario = horario;
		this.capacidad = capacidad;
		this.idIPS = pServSalud;
	}

	/**
	 * @return El id del horario de bebida
	 */
	public long getId() 
	{
		return idServSalud;
	}

	/**
	 * @param id - El nuevo id del horario de bebida
	 */
	public void setId(long id) 
	{
		this.idServSalud = id;
	}

	public Date gethorario() {
		return horario;
	}

	public void sethorario(Date horario) {
		this.horario = horario;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
	public long getIdIPS() {
		return idIPS;
	}

	public void setIdIPS(long pidIPS) {
		this.idIPS = pidIPS;
	}

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ServicioSalud [id=" + idServSalud + ", horario=" + horario+ ", capacidad=" + capacidad+ ", idIPS=" + idIPS + "]";
	}

	

	

}
