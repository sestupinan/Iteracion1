package uniandes.isis2304.epsandes.negocio;

public class ExamenDiagnostico implements VOExamenDiagnostico
{
	/* ****************************************************************
	* 			Atributos
	 *****************************************************************/

	private long idExDiagnostico;

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
		this.idExDiagnostico = 0;
		this.resultado = "";
		this.diagnostico = "";
		this.idServSalud = 0;
	}

	/**
	 * Constructor con valores
	 */
	public ExamenDiagnostico(long id, String pResultado, String pDiagnostico, long pServSalud) 
	{
		this.idExDiagnostico = id;
		this.resultado = pResultado;
		this.diagnostico = pDiagnostico;
		this.idServSalud = pServSalud;
	}


	public long getId() 
	{
		return idExDiagnostico;
	}

	public void setId(long id) 
	{
		this.idExDiagnostico = id;
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
		return "ProcedimientoEspecializado [id=" + idExDiagnostico + ", resultado=" + resultado+ ", diagnostico=" + diagnostico+ ", idServSalud=" + idServSalud + "]";
	}

	
}
