package uniandes.isis2304.epsandes.negocio;

public interface VOMedico {

	public long getId();
	
	public String getTipo();
	
	public long getRegistroMedico();
	
	public long getIdEmpleado();
	
	@Override
	public String toString();
	
}
