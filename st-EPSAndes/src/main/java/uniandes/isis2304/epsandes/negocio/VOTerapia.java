package uniandes.isis2304.epsandes.negocio;

public interface VOTerapia {

	public long getId();
	
	public String getTipo();
	
	public int getNSesiones();
	
	public long getIdServSalud();
	
	@Override
	public String toString();
	
}
