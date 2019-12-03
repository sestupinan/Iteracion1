package uniandes.isis2304.epsandes.negocio;

public class OrdenDetail implements VOOrdenDetail {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del bebedor que realiza la visita
	 */
	public long ordenId;
	
	public long servicioId;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public OrdenDetail() 
	{
		this.ordenId = 0;
		this.servicioId = 0;
	}

	/**
	 * Constructor con valores
	 * @param idBebedor - El identificador del b ebedor. Debe existir un bebedor con dicho identificador
	 * @param idBar - El identificador del bar. Debe exixtir un bar con dicho identificador
	 * @param fechaVisita - La fecha en la cual se realiza la visita
	 * @param pMedicamentos - El horario en el que el bebedor vista el bar (DIURNO, NOCTURNO, TODOS)
	 */
	public OrdenDetail(long idOrden, long pIdServSalud) 
	{
		this.ordenId = idOrden;
		this.servicioId = pIdServSalud;
	}

	/**
	 * @return El idBebedor
	 */
	public long getIdOrden() 
	{
		return ordenId;
	}

	/**
	 * @param idBebedor - El nuevo idBebedor. Debe existir un bebedor con dicho identificador
	 */
	public void setIdOrden(long idBebedor) 
	{
		this.ordenId = idBebedor;
	}

	/**
	 * @return El idBar
	 */
	public long getIdServSalud() 
	{
		return servicioId;
	}

	/**
	 * @param idBar - El nuevo idBar. Debe exixtir un bar con dicho identificador
	 */
	public void setIdServSalud(long idBar) 
	{	
		this.servicioId = idBar;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Visitan [idOrdenitalizacion=" + ordenId + "idServSalud=" + servicioId+ "]";
	}
}
