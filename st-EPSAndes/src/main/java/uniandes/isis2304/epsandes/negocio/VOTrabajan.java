package uniandes.isis2304.epsandes.negocio;

public interface VOTrabajan {
	
	public long getIdMedico();

	public long getIdIPS();

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString();

}
