package uniandes.isis2304.epsandes.negocio;

public class Terapia implements VOTerapia
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public long idTerapia;

	public String tipo;
	
	public int nSesiones;
	
	public long idServSalud;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Terapia() 
	{
		this.idTerapia = 0;
		this.tipo = "";
		this.nSesiones = 0;
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Terapia(long id, String tipo, int pNSesiones, long pServSalud) 
	{
		this.idTerapia = id;
		this.tipo = tipo;
		this.nSesiones = pNSesiones;
		this.idServSalud = pServSalud;
	}


	public long getId() 
	{
		return idTerapia;
	}

	public void setId(long id) 
	{
		this.idTerapia = id;
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
		return "ProcedimientoEspecializado [id=" + idTerapia + ", tipo=" + tipo+ ", nSesiones=" + nSesiones+ ", idServSalud=" + idServSalud + "]";
	}

	
	
}
