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

/**
 * Clase para modelar la relación VISITAN del negocio de los Parranderos:
 * Cada objeto de esta clase representa el hecho que un bebedor visitó un bar y viceversa.
 * Se modela mediante los identificadores del bebedor y del bar respectivamente
 * Debe existir un bebedor con el identificador dado
 * Debe existir un bar con el identificador dado 
 * Adicionalmente contiene la fecha y el horario (DIURNO, NOCTURNO, TODOS) en el cual el bebedor visitó el bar
 * 
 * @author Germán Bravo
 */
public class Orden implements VOOrden
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del bebedor que realiza la visita
	 */
	private long idOrden;
	
	/**
	 * El horario en que se realizó la visita (DIURNO, NOCTURNO, TODOS)
	 */
	private String medicamentos;
	
	
	private long idServSalud;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Orden() 
	{
		this.idOrden = 0;
		this.medicamentos = "";
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 * @param idBebedor - El identificador del b ebedor. Debe existir un bebedor con dicho identificador
	 * @param idBar - El identificador del bar. Debe exixtir un bar con dicho identificador
	 * @param fechaVisita - La fecha en la cual se realiza la visita
	 * @param pMedicamentos - El horario en el que el bebedor vista el bar (DIURNO, NOCTURNO, TODOS)
	 */
	public Orden(long idOrden, String pMedicamentos, long pIdServSalud) 
	{
		this.idOrden = idOrden;
		this.medicamentos = pMedicamentos;
		this.idServSalud = pIdServSalud;
	}

	/**
	 * @return El idBebedor
	 */
	public long getIdOrden() 
	{
		return idOrden;
	}

	/**
	 * @param idBebedor - El nuevo idBebedor. Debe existir un bebedor con dicho identificador
	 */
	public void setIdOrden(long idBebedor) 
	{
		this.idOrden = idBebedor;
	}

	/**
	 * @return El horario
	 */
	public String getmedicamentos() 
	{
		return medicamentos;
	}

	/**
	 * @param pmedicamentos - El nuevo horario en que se realizó la visita (DIURNO, NOCTURNO, TODOS)
	 */
	public void setmedicamentos(String pmedicamentos) 
	{
		this.medicamentos = pmedicamentos;
	}
	
	/**
	 * @return El idBar
	 */
	public long getIdServSalud() 
	{
		return idServSalud;
	}

	/**
	 * @param idBar - El nuevo idBar. Debe exixtir un bar con dicho identificador
	 */
	public void setIdServSalud(long idBar) 
	{	
		this.idServSalud = idBar;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Visitan [idOrdenitalizacion=" + idOrden +  ", Medicamentos="
				+ medicamentos + ", idServSalud=" + idServSalud+ "]";
	}
}
