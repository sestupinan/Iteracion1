package uniandes.isis2304.epsandes.negocio;

public class Medico extends Empleado
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public String especialidad;
	
	public long nRegMedico;
	
	public long idEmpleado;
	
	public String tipoid;
	
	public String nombre;

	public Medico(String especialidad, long nRegMedico, long idEmpleado, String tipoid, String nombre) {
		super();
		this.especialidad = especialidad;
		this.nRegMedico = nRegMedico;
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

	public long getnRegMedico() {
		return nRegMedico;
	}

	public void setnRegMedico(long nRegMedico) {
		this.nRegMedico = nRegMedico;
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
		return "Medico [especialidad=" + especialidad + ", nRegMedico=" + nRegMedico + ", idEmpleado="
				+ idEmpleado + ", tipoid=" + tipoid + ", nombre=" + nombre + "]";
	}
		
	

	

	

}
