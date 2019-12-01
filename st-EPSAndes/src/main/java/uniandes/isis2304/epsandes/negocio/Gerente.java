package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Gerente extends Empleado implements VOGerente{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public String reporte;

	

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Gerente() 
	{
		super();
		this.reporte = "";

	}

	/**
	 * Constructor con valores
	 */
	public Gerente(String pReporte, Long id, String tipo, String pNombre) 
	{
		super(id, tipo, pNombre);
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
