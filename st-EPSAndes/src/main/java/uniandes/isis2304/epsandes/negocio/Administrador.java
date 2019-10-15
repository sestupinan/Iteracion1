package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Administrador extends Empleado
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private String caracteristicas;

	

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Administrador() 
	{
		super();
		this.caracteristicas = "";
	}

	/**
	 * Constructor con valores
	 */
	public Administrador(String pCaracteristicas, Long id, String tipo, String pNombre) 
	{
		super(id, tipo, pNombre);
		this.caracteristicas = pCaracteristicas;
	}


	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [idMedico=" + caracteristicas + ", idUsuario=" + "]";
	}
}
