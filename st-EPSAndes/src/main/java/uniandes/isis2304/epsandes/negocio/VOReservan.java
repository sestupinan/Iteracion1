package uniandes.isis2304.epsandes.negocio;

public interface VOReservan {
	
	public long getIdServSalud();
	
	public long getIdCampaniaPrev();

	public int getCantidadreservados();
	
	@Override
	public String toString();

}
