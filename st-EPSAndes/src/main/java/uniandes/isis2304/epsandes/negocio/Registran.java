package uniandes.isis2304.epsandes.negocio;

public class Registran implements VORegistran{

	public long idUsuario;
	
	public long campañaPrev;

	public Registran(long idUsuario, long campañaPrev) {
	
		this.idUsuario = idUsuario;
		this.campañaPrev = campañaPrev;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getCampañaPreventiva() {
		return campañaPrev;
	}

	public void setCampañaPreventiva(long campañaPrev) {
		this.campañaPrev = campañaPrev;
	}

	@Override
	public String toString() {
		return "Registran [idUsuario=" + idUsuario + ", campañaPrev=" + campañaPrev + "]";
	}
	
	
	
}
