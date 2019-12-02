package uniandes.isis2304.epsandes.negocio;

public class ProcedimientoEspecializado implements VOProcedimientoEspecializado
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public long idProcesp;

	public String tipo;
	
	public String equipos;
	
	public long idServSalud;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ProcedimientoEspecializado() 
	{
		this.idProcesp = 0;
		this.tipo = "";
		this.equipos = "";
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 */
	public ProcedimientoEspecializado(long id, String tipo, String pEquipo, long pServSalud) 
	{
		this.idProcesp = id;
		this.tipo = tipo;
		this.equipos = pEquipo;
		this.idServSalud = pServSalud;
	}


	public long getId() 
	{
		return idProcesp;
	}

	public void setId(long id) 
	{
		this.idProcesp = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	
	public String getEquipo() {
		return equipos;
	}

	public void setEquipo(String equipos) {
		this.equipos = equipos;
	}

	public long getIdServSalud() {
		return idServSalud;
	}

	public void setIdServSalud(long idServSalud) {
		this.idServSalud = idServSalud;
	}

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [id=" + idProcesp + ", tipo=" + tipo+ ", equipos=" + equipos+ ", idServSalud=" + idServSalud + "]";
	}

	
}
