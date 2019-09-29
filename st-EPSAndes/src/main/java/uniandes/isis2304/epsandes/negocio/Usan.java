package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Usan 
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long idUsuario;

	private long idServSalud;
	
	private Timestamp fechaReserva;
	
	private Timestamp fechaAtencion;
	
	private long idRecepcionista;
	
	private int estado;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Usan() 
	{
		this.idUsuario = 0;
		this.idServSalud = 0;
		this.fechaReserva = null;
		this.fechaAtencion = null;
		this.idRecepcionista = 0;
		this.estado = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Usan(long id, long idServSalud, Timestamp pFechaReserva,Timestamp pFechaAtencion, long pNombre, int pEstado) 
	{
		this.idUsuario = id;
		this.idServSalud = idServSalud;
		this.fechaReserva = pFechaReserva;
		this.fechaAtencion = pFechaAtencion;
		this.idRecepcionista = pNombre;
		this.estado = pEstado;
	}




	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdServSalud() {
		return idServSalud;
	}

	public void setIdServSalud(long idServSalud) {
		this.idServSalud = idServSalud;
	}

	public Timestamp getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Timestamp fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Timestamp getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Timestamp fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [idUsuario=" + idUsuario + ", idServSalud=" + idServSalud+ ", fechaReserva=" + fechaReserva+ ", fechaAtencion=" + fechaAtencion+ ", idRecepcionista=" + idRecepcionista +", estado=" + estado + "]";
	}

}
