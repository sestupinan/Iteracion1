package uniandes.isis2304.epsandes.negocio;

public interface VOIPS {

	public long getId();
	
	public String getTipo();
	
	public String getLocalizacion();
	
	@Override
	public String toString();
}
