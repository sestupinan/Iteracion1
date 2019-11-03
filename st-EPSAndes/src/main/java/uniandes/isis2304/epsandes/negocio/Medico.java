package uniandes.isis2304.epsandes.negocio;

public class Medico extends Empleado
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private String especialidad;
	
	private long nRegistroMedico;
	
	private long idEmpleado;
	
	private String tipoid;
	
	private String nombre;

	public Medico(String especialidad, long nRegistroMedico, long idEmpleado, String tipoid, String nombre) {
		super();
		this.especialidad = especialidad;
		this.nRegistroMedico = nRegistroMedico;
		this.idEmpleado = idEmpleado;
		this.tipoid = tipoid;
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public long getnRegistroMedico() {
		return nRegistroMedico;
	}

	public void setnRegistroMedico(long nRegistroMedico) {
		this.nRegistroMedico = nRegistroMedico;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getTipoid() {
		return tipoid;
	}

	public void setTipoid(String tipoid) {
		this.tipoid = tipoid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Medico [especialidad=" + especialidad + ", nRegistroMedico=" + nRegistroMedico + ", idEmpleado="
				+ idEmpleado + ", tipoid=" + tipoid + ", nombre=" + nombre + "]";
	}
		
	

	

	

}
