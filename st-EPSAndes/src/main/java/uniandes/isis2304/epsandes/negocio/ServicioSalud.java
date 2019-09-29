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
	 * El identificador del tipo de bebida
	 */
	private long id;

	/**
	 * El nombre del tipo de bebida
	 */
	private String tipo;
	
	public int capacidad;
	
	public Date horario;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ServicioSalud() 
	{
		this.id = 0;
		this.tipo = "";
		this.capacidad = 0;
		this.horario = null;
	}

	/**
	 * Constructor con valores
	 * @param id - El identificador del tipo de bebida
	 * @param nombre - El nombre del tipo de bebida
	 */
	public ServicioSalud(long id, String tipo, int capacidad, Date horario) 
	{
		this.id = id;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.horario = horario;
	}

	/**
	 * @return El id del tipo de bebida
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @param id - El nuevo id del tipo de bebida
	 */
	public void setId(long id) 
	{
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}



	/**
	 * @return Una cadena de caracteres con la información del tipo de bebida
	 */
	@Override
	public String toString() 
	{
		return "TipoBebida [id=" + id + ", nombre=" + capacidad + "]";
	}

	

}
