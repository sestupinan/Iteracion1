package uniandes.isis2304.epsandes.negocio;

public class Medico extends Empleado
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private String especialidad;
	
	private long nRegistroMedico;
		
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Medico() 
	{
		super();
		this.especialidad = "";
		this.nRegistroMedico = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Medico(long id, String pTipoId, String pNombre, String pEspecialidad, int pNRegistroMedico) 
	{
		super(id, pTipoId, pNombre);
		this.especialidad = pEspecialidad;
		this.nRegistroMedico = pNRegistroMedico;
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


	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "Medico [id=" + super.getId() + ", tipo=" + especialidad+ ", equipo=" + nRegistroMedico+ "]";
	}

}
