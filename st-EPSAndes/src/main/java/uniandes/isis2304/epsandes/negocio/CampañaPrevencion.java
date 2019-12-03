package uniandes.isis2304.epsandes.negocio;

import java.sql.Date;

public class CampañaPrevencion implements VOCampañaPrevencion {

	public long id;

	public Date fechaInicio;
	
	public Date fechaFin;
	
	public String nombreCampania;
	
	public CampañaPrevencion(long id, Date fechaInicio, Date fechaFin, String nomCamp) {
	
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombreCampania = nomCamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNombreCampania() {
		return nombreCampania;
	}

	public void setNombreCampania(String nombreCampania) {
		this.nombreCampania = nombreCampania;
	}

	@Override
	public String toString() {
		return "CampañaPrevencion [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", nombreCampania=" + nombreCampania + "]";
	}

	
	
}
