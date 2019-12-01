package uniandes.isis2304.epsandes.negocio;

public interface VOAtienden {
	
	public long getIdMedico();

	public void setIdMedico(long idMedico);

	public long getIdUsuario();

	public void setIdUsuario(long idUsuario);
	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString();
	
}
