package uniandes.isis2304.epsandes.negocio;

public class ExamenSangre implements VOExamenSangre{

	public long id;
	
	public long idServSalud;

	public ExamenSangre(long id, long idServSalud) {
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
		return "ExamenSangre [id=" + id + ", idServSalud=" + idServSalud + "]";
	}
	
	
}
