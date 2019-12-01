package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Usan implements VOUsan
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	public long idUsuario;

	public long idServSalud;
	
	public Timestamp fechaReserva;
	
	public Timestamp fechaAtencion;
	
	public long idRecepcionista;
	
	public int estado;
	
	public long idOrden;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public Usan(long idUsuario, long idServSalud, Timestamp fechaReserva, Timestamp fechaAtencion, long idRecepcionista,
			int estado, long idOrden) {
		this.idUsuario = idUsuario;
		this.idServSalud = idServSalud;
		this.fechaReserva = fechaReserva;
		this.fechaAtencion = fechaAtencion;
		this.idRecepcionista = idRecepcionista;
		this.estado = estado;
		this.idOrden = idOrden;
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
	
	public long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}

	@Override
	public String toString() {
		return "Usan [idUsuario=" + idUsuario + ", idServSalud=" + idServSalud + ", fechaReserva=" + fechaReserva
				+ ", fechaAtencion=" + fechaAtencion + ", idRecepcionista=" + idRecepcionista + ", estado=" + estado
				+ ", idOrden=" + idOrden + "]";
	}

	

}
