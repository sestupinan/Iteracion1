package uniandes.isis2304.epsandes.negocio;

public interface VOExamenDiagnostico {

	public long getId() ;
	
	public String getTipo();
	
	public String getEquipo();
	
	public long getIdServSalud();
	
	@Override
	public String toString();
	
}
