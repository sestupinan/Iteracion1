package uniandes.isis2304.epsandes.negocio;

public interface VOProcedimientoEspecializado {

	public long getId();
	
	public String getTipo();
	
	public String getEquipo();
	
	public long getIdServSalud();
	
	@Override
	public String toString();
	
}
