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
	public long idOrden;
	
	public String rMedica;
	
	public Date fecha;
	
	public long idMedico;
	
	public long idUsuario;

	public Orden(long idOrden, String rMedica, Date fecha, long idMedico, long idUsuario) {
		
		this.idOrden = idOrden;
		this.rMedica = rMedica;
		this.fecha = fecha;
		this.idMedico = idMedico;
		this.idUsuario = idUsuario;
	}

	public long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}

	public String getRecetaMedica() {
		return rMedica;
	}

	public void setRecetaMedica(String rMedica) {
		this.rMedica = rMedica;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", rMedica=" + rMedica + ", fecha=" + fecha + ", idMedico="
				+ idMedico + ", idUsuario=" + idUsuario + "]";
	}
	
	
}
