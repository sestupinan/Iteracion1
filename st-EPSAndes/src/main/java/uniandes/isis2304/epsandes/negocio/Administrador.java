package uniandes.isis2304.epsandes.negocio;

public class Administrador 
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long idMedico;

	private long idUsuario;
	

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Administrador() 
	{
		this.idMedico = 0;
		this.idUsuario = 0;

	}

	/**
	 * Constructor con valores
	 */
	public Administrador(long pidMedico, long pIdIPS) 
	{
		this.idMedico = pidMedico;
		this.idUsuario = pIdIPS;

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

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [idMedico=" + idMedico + ", idUsuario=" + idUsuario+ "]";
	}
}
