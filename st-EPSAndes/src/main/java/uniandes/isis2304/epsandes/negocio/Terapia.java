package uniandes.isis2304.epsandes.negocio;

public class Terapia 
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long id;

	private String tipo;
	
	private int nSesiones;
	
	private long idServSalud;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Terapia() 
	{
		this.id = 0;
		this.tipo = "";
		this.nSesiones = 0;
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Terapia(long id, String tipo, int pNSesiones, long pServSalud) 
	{
		this.id = id;
		this.tipo = tipo;
		this.nSesiones = pNSesiones;
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
	

	
	public int getNSesiones() {
		return nSesiones;
	}

	public void setNSesiones(int pNSesiones) {
		this.nSesiones = pNSesiones;
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
		return "ProcedimientoEspecializado [id=" + id + ", tipo=" + tipo+ ", nSesiones=" + nSesiones+ ", idServSalud=" + idServSalud + "]";
	}

	
	
}
