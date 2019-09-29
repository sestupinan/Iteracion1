package uniandes.isis2304.epsandes.negocio;

public class ProcedimientoEspecializado 
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long id;

	private String tipo;
	
	private String equipo;
	
	private long idServSalud;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ProcedimientoEspecializado() 
	{
		this.id = 0;
		this.tipo = "";
		this.equipo = "";
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 */
	public ProcedimientoEspecializado(long id, String tipo, String pEquipo, long pServSalud) 
	{
		this.id = id;
		this.tipo = tipo;
		this.equipo = pEquipo;
		this.idServSalud = pServSalud;
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
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	
	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
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
		return "ProcedimientoEspecializado [id=" + id + ", tipo=" + tipo+ ", equipo=" + equipo+ ", idServSalud=" + idServSalud + "]";
	}

	
}
