package uniandes.isis2304.epsandes.negocio;

public class Medico 
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long id;

	private String especialidad;
	
	private long nRegistroMedico;
	
	private long idEmpleado;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Medico() 
	{
		this.id = 0;
		this.especialidad = "";
		this.nRegistroMedico = 0;
		this.idEmpleado = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Medico(long id, String pEspecialidad, int pNRegistroMedico, long pIdEmpleado) 
	{
		this.id = id;
		this.especialidad = pEspecialidad;
		this.nRegistroMedico = pNRegistroMedico;
		this.idEmpleado = pIdEmpleado;
	}


	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getTipo() {
		return especialidad;
	}

	public void setTipo(String tipo) {
		this.especialidad = tipo;
	}
	

	
	public long getRegistroMedico() {
		return nRegistroMedico;
	}

	public void setRegistroMedico(long pRegistroMedico) {
		this.nRegistroMedico = pRegistroMedico;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long pidEmpleado) {
		this.idEmpleado = pidEmpleado;
	}

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [id=" + id + ", tipo=" + especialidad+ ", equipo=" + nRegistroMedico+ ", idServSalud=" + idEmpleado + "]";
	}

}
