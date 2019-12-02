package uniandes.isis2304.epsandes.negocio;

public class IPS implements VOIPS
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public long idIPS;

	public String tipo;
	
	public String localizacion;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public IPS() 
	{
		this.idIPS = 0;
		this.tipo = "";
		this.localizacion = "";
	}

	/**
	 * Constructor con valores
	 */
	public IPS(long id, String tipo, String pLocalizacion) 
	{
		this.idIPS = id;
		this.tipo = tipo;
		this.localizacion = pLocalizacion;
	}


	public long getId() 
	{
		return idIPS;
	}

	public void setId(long id) 
	{
		this.idIPS = id;
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
		return "ProcedimientoEspecializado [id=" + idIPS + ", tipo=" + tipo+ ", localizacion=" + localizacion + "]";
	}

	
}
