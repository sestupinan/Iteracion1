package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public class Recepcionista extends Empleado{
	
	/**
	 * Constructor por defecto
	 */
	public Recepcionista() 
	{
		super();
	}

	/**
	 * Constructor con valores
	 */
	public Recepcionista(Long id, String tipo, String pNombre) 
	{
		super(id, tipo, pNombre);
	}
}
