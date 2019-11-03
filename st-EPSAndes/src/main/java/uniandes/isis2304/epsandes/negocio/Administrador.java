package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Administrador extends Empleado
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private String caracteristicas;
	
	private String tipo;
	
	private String nombre;

	private String idEmpleado;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	
	public Administrador(String caracteristicas, String tipo, String nombre, String idEmpleado) {
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

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Administrador [caracteristicas=" + caracteristicas + ", tipo=" + tipo + ", nombre=" + nombre
				+ ", idEmpleado=" + idEmpleado + "]";
	}
	
	
}
