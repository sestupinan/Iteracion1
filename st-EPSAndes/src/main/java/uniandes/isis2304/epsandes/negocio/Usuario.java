package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

import org.datanucleus.store.types.converters.InstantDateConverter;


public class Usuario implements VOUsuario
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long nIdentificacion;

	private String tipoId;
	
	private Timestamp fechaNacimiento;
	
	private String nombre;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Usuario() 
	{
		this.nIdentificacion = 0;
		this.tipoId = "";
		this.fechaNacimiento = null;
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 */
	public Usuario(long id, String tipo, Timestamp pFechaNacimiento, String pNombre) 
	{
		this.nIdentificacion = id;
		this.tipoId = tipo;
		this.fechaNacimiento = pFechaNacimiento;
		this.nombre = pNombre;
	}


	public long getId() 
	{
		return nIdentificacion;
	}

	public void setId(long id) 
	{
		this.nIdentificacion = id;
	}

	public String getTipo() {
		return tipoId;
	}

	public void setTipo(String tipo) {
		this.tipoId = tipo;
	}
	

	
	public Timestamp getFechaN() {
		return fechaNacimiento;
	}

	public void setFechaN(Timestamp pFecha) {
		this.fechaNacimiento = pFecha;
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
		return "ProcedimientoEspecializado [nIdentificacion=" + nIdentificacion + ", tipoId=" + tipoId+ ", fechaNacimiento=" + fechaNacimiento+ ", nombre=" + nombre + "]";
	}

	
}
