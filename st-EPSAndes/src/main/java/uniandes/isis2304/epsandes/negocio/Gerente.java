package uniandes.isis2304.epsandes.negocio;

public class Gerente {
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private String reporte;

	

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Gerente() 
	{
		this.reporte = "";

	}

	/**
	 * Constructor con valores
	 */
	public Gerente(String pReporte) 
	{
		this.reporte = pReporte;

	}



	public String getReporte() {
		return reporte;
	}

	public void setReporte(String preporte) {
		this.reporte = preporte;
	}





	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [idMedico=" + reporte +  "]";
	}
}
