package uniandes.isis2304.epsandes.negocio;

import java.sql.Date;

public class CampañaPrevencion implements VOCampañaPrevencion {

	public long id;

	public Date fechaInicio;
	
	public Date column1;
	
	public CampañaPrevencion(long id, Date fechaInicio, Date column1) {
	
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.column1 = column1;
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

	public Date getColumn1() {
		return column1;
	}

	public void setColumn1(Date column1) {
		this.column1 = column1;
	}

	@Override
	public String toString() {
		return "CampañaPrevencion [id=" + id + ", fechaInicio=" + fechaInicio + ", column1=" + column1 + "]";
	}

	
}
