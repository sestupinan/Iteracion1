package uniandes.isis2304.epsandes.negocio;

import java.sql.Date;

public class NoDisponibilidad {

	private long idServicioSalud;
	
	private Date fechaInicio;
	
	private long idIPS;
	
	private String causa;
	
	private Date fechaFin;

	public NoDisponibilidad(long idServicioSalud, Date fechaInicio, long idIPS, String causa, Date fechaFin) {
		this.idServicioSalud = idServicioSalud;
		this.fechaInicio = fechaInicio;
		this.idIPS = idIPS;
		this.causa = causa;
		this.fechaFin = fechaFin;
	}

	public long getIdServicioSalud() {
		return idServicioSalud;
	}

	public void setIdServicioSalud(long idServicioSalud) {
		this.idServicioSalud = idServicioSalud;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public long getIdIPS() {
		return idIPS;
	}

	public void setIdIPS(long idIPS) {
		this.idIPS = idIPS;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "NoDisponibilidad [idServicioSalud=" + idServicioSalud + ", fechaInicio=" + fechaInicio + ", idIPS="
				+ idIPS + ", causa=" + causa + ", fechaFin=" + fechaFin + "]";
	}
	
}
