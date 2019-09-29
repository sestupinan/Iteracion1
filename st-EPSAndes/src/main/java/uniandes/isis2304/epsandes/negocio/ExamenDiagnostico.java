package uniandes.isis2304.epsandes.negocio;

public class ExamenDiagnostico implements VOExamenDiagnostico
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long id;

	private String resultado;
	
	private String diagnostico;
	
	private long idServSalud;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ExamenDiagnostico() 
	{
		this.id = 0;
		this.resultado = "";
		this.diagnostico = "";
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 */
	public ExamenDiagnostico(long id, String pResultado, String pDiagnostico, long pServSalud) 
	{
		this.id = id;
		this.resultado = pResultado;
		this.diagnostico = pDiagnostico;
		this.idServSalud = pServSalud;
	}


	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getTipo() {
		return resultado;
	}

	public void setTipo(String tipo) {
		this.resultado = tipo;
	}
	

	
	public String getEquipo() {
		return diagnostico;
	}

	public void setEquipo(String equipo) {
		this.diagnostico = equipo;
	}

	public long getIdServSalud() {
		return idServSalud;
	}

	public void setIdServSalud(long idServSalud) {
		this.idServSalud = idServSalud;
	}

	/**
	 * @return Una cadena de caracteres con la información del servicio de salud
	 */
	@Override
	public String toString() 
	{
		return "ProcedimientoEspecializado [id=" + id + ", resultado=" + resultado+ ", diagnostico=" + diagnostico+ ", idServSalud=" + idServSalud + "]";
	}

	
}
