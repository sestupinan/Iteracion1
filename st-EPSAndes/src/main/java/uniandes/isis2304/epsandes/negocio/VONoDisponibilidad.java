package uniandes.isis2304.epsandes.negocio;

import java.sql.Date;

public interface VONoDisponibilidad {

	public long getIdServicioSalud();

	public Date getFechaInicio();

	public long getIdIPS();

	public String getCausa();

	public Date getFechaFin();

	@Override
	public String toString();
	
}
