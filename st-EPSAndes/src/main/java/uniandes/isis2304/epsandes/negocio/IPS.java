package uniandes.isis2304.epsandes.negocio;

public class IPS 
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long id;

	private String tipo;
	
	private String localizacion;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public IPS() 
	{
		this.id = 0;
		this.tipo = "";
		this.localizacion = "";
	}

	/**
	 * Constructor con valores
	 */
	public IPS(long id, String tipo, String pLocalizacion, long pServSalud) 
	{
		this.id = id;
		this.tipo = tipo;
		this.localizacion = pLocalizacion;
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
	

	
	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String pLocalizacion) {
		this.localizacion = pLocalizacion;
	}


	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [id=" + id + ", tipo=" + tipo+ ", localizacion=" + localizacion + "]";
	}

	
}
