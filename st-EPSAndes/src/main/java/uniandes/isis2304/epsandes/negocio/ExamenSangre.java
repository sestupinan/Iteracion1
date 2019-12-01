package uniandes.isis2304.epsandes.negocio;

public class ExamenSangre implements VOExamenSangre{

	private long id;
	
	private long idServicioSalud;

	public ExamenSangre(long id, long idServicioSalud) {
		this.id = id;
		this.idServicioSalud = idServicioSalud;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdServicioSalud() {
		return idServicioSalud;
	}

	public void setIdServicioSalud(long idServicioSalud) {
		this.idServicioSalud = idServicioSalud;
	}

	@Override
	public String toString() {
		return "ExamenSangre [id=" + id + ", idServicioSalud=" + idServicioSalud + "]";
	}
	
	
}
