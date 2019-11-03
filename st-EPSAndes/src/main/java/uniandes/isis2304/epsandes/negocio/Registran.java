package uniandes.isis2304.epsandes.negocio;

public class Registran {

	public long idUsuario;
	
	public long campañaPreventiva;

	public Registran(long idUsuario, long campañaPreventiva) {
	
		this.idUsuario = idUsuario;
		this.campañaPreventiva = campañaPreventiva;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getCampañaPreventiva() {
		return campañaPreventiva;
	}

	public void setCampañaPreventiva(long campañaPreventiva) {
		this.campañaPreventiva = campañaPreventiva;
	}

	@Override
	public String toString() {
		return "Registran [idUsuario=" + idUsuario + ", campañaPreventiva=" + campañaPreventiva + "]";
	}
	
	
	
}
