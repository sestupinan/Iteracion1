package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Administrador extends Empleado implements VOAdministrador
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private String caracteristicas;
	
	private String tipo;
	
	private String nombre;

	private Long idEmpleado;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	
	public Administrador(String caracteristicas, String tipo, String nombre, Long idEmpleado) {
		this.caracteristicas = caracteristicas;
		this.tipo = tipo;
		this.nombre = nombre;
		this.idEmpleado = idEmpleado;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Administrador [caracteristicas=" + caracteristicas + ", tipo=" + tipo + ", nombre=" + nombre
				+ ", idEmpleado=" + idEmpleado + "]";
	}
	
	
}
