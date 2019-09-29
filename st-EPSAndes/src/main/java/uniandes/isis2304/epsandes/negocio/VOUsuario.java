package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public interface VOUsuario {

	public long getId();
	
	public String getTipo();
	
	public Timestamp getFechaN();
	
	public String getNombre();
	
	@Override
	public String toString();
	
}
