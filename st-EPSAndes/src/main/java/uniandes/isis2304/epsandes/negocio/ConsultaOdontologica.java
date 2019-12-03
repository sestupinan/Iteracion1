package uniandes.isis2304.epsandes.negocio;

public class ConsultaOdontologica implements VOConsultaOdontologica{
	
	public long id;
	
	public long idServSalud;

	public ConsultaOdontologica(long id, long idServSalud) {
		this.id = id;
		this.idServSalud = idServSalud;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdServicioSalud() {
		return idServSalud;
	}

	public void setIdServicioSalud(long idServSalud) {
		this.idServSalud = idServSalud;
	}

	@Override
	public String toString() {
		return "ConsultaOdontologica [id=" + id + ", idServSalud=" + idServSalud + "]";
	}
	
	
	
	

}
