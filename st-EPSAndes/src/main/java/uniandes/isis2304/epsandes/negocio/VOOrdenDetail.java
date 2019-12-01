package uniandes.isis2304.epsandes.negocio;

public interface VOOrdenDetail {

	public long getIdOrden();

	/**
	 * @return El idBar
	 */
	public long getIdServSalud();

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}
