package uniandes.isis2304.epsandes.negocio;

import java.sql.Date;

public interface VOCampañaPrevencion {


	public long getId();

	public Date getFechaInicio();


	public Date getFechaFin();

	public String getNombreCampania();

	@Override
	public String toString();
}
