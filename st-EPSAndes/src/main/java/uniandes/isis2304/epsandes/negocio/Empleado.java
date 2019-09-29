package uniandes.isis2304.epsandes.negocio;

public class Empleado 
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long id;

	private String tipoId;
	
	private String nombre;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Empleado() 
	{
		this.id = 0;
		this.tipoId = "";
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 */
	public Empleado(long id, String pTipoId, String pNOmbre) 
	{
		this.id = id;
		this.tipoId = pTipoId;
		this.nombre = pNOmbre;
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
		return tipoId;
	}

	public void setTipo(String tipo) {
		this.tipoId = tipo;
	}
	

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}



	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [id=" + id + ", tipoId=" + tipoId+ ", nombre=" + nombre + "]";
	}

}
