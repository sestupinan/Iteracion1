package uniandes.isis2304.epsandes.negocio;

public class Reservan {
	
	public long idServicioSalud;
	
	public long idCampañaPreventiva;

	public Reservan(long idServicioSalud, long idCampañaPreventiva) {
		
		this.idServicioSalud = idServicioSalud;
		this.idCampañaPreventiva = idCampañaPreventiva;
	}

	public long getIdServicioSalud() {
		return idServicioSalud;
	}

	public void setIdServicioSalud(long idServicioSalud) {
		this.idServicioSalud = idServicioSalud;
	}

	public long getIdCampañaPreventiva() {
		return idCampañaPreventiva;
	}

	public void setIdCampañaPreventiva(long idCampañaPreventiva) {
		this.idCampañaPreventiva = idCampañaPreventiva;
	}

	@Override
	public String toString() {
		return "Reservan [idServicioSalud=" + idServicioSalud + ", idCampañaPreventiva=" + idCampañaPreventiva + "]";
	}
	
	
	

}
