package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Administrador extends Empleado implements VOAdministrador
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public String caracteristicas;
	
	public Long idAdmin;

	public Long idEmpleado;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	
	public Administrador(String caracteristicas, Long idEmpleado, Long idAdmin) {
		this.caracteristicas = caracteristicas;
		this.idAdmin = idAdmin;
		this.idEmpleado = idEmpleado;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	
	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Override
	public String toString() {
		return "Administrador [caracteristicas=" + caracteristicas + ", idAdmin=" + idAdmin + ", idEmpleado="
				+ idEmpleado + "]";
	}

	
	
}
