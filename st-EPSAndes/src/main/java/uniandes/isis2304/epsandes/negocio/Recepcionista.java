package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Recepcionista extends Empleado implements VORecepcionista{
	
	public String tipo;
	
	public String nombre;
	
	public long idEmpleado;

	public Recepcionista(String tipo, String nombre, long idEmpleado) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.idEmpleado = idEmpleado;
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

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Recepcionista [tipo=" + tipo + ", nombre=" + nombre + ", idEmpleado=" + idEmpleado + "]";
	}
	
	
}
