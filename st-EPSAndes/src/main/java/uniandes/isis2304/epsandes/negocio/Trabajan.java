package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Trabajan {
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long idMedico;

	private long idIPS;
	

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Trabajan() 
	{
		this.idMedico = 0;
		this.idIPS = 0;

	}

	/**
	 * Constructor con valores
	 */
	public Trabajan(long pidMedico, long pIdIPS) 
	{
		this.idMedico = pidMedico;
		this.idIPS = pIdIPS;

	}



	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getIdIPS() {
		return idIPS;
	}

	public void setIdIPS(long idIPS) {
		this.idIPS = idIPS;
	}

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [idMedico=" + idMedico + ", idIPS=" + idIPS+ "]";
	}

}
