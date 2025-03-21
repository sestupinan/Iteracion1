package uniandes.isis2304.epsandes.negocio;

public class Atienden implements VOAtienden{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public long idMedico;

	public long idUsuario;
	

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Atienden() 
	{
		this.idMedico = 0;
		this.idUsuario = 0;

	}

	/**
	 * Constructor con valores
	 */
	public Atienden(long pidMedico, long pIdUsuario) 
	{
		this.idMedico = pidMedico;
		this.idUsuario = pIdUsuario;

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
