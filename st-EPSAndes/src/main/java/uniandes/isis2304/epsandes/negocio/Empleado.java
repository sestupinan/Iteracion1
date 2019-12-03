package uniandes.isis2304.epsandes.negocio;

public class Empleado implements VOEmpleado
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long idEmpleado;

	private String tipo;
	
	private String nombre;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Empleado() 
	{
		this.idEmpleado = 0;
		this.tipo = "";
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 */
	public Empleado(long id, String pTipoId, String pNombre) 
	{
		this.idEmpleado = id;
		this.tipo = pTipoId;
		this.nombre = pNombre;
	}


	public long getId() 
	{
		return idEmpleado;
	}

	public void setId(long id) 
	{
		this.idEmpleado = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return "ProcedimientoEspecializado [id=" + idEmpleado + ", tipo=" + tipo+ ", nombre=" + nombre + "]";
	}

}
