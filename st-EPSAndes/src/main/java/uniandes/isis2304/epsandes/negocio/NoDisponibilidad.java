package uniandes.isis2304.epsandes.negocio;

import java.sql.Date;

public class NoDisponibilidad implements VONoDisponibilidad {

	public long idServSalud;
	
	public Date fechaInicio;
	
	public long idIPS;
	
	public String causa;
	
	public Date fechaFin;

	public NoDisponibilidad(long idServSalud, Date fechaInicio, long idIPS, String causa, Date fechaFin) {
		this.idServSalud = idServSalud;
		this.fechaInicio = fechaInicio;
		this.idIPS = idIPS;
		this.causa = causa;
		this.fechaFin = fechaFin;
	}

	public long getIdServicioSalud() {
		return idServSalud;
	}

	public void setIdServicioSalud(long idServSalud) {
		this.idServSalud = idServSalud;
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
		return "NoDisponibilidad [idServSalud=" + idServSalud + ", fechaInicio=" + fechaInicio + ", idIPS="
				+ idIPS + ", causa=" + causa + ", fechaFin=" + fechaFin + "]";
	}
	
}
