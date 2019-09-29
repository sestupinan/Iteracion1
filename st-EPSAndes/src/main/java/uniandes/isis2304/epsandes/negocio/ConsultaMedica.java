/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.epsandes.negocio;

/**
 * Clase para mode laar el concepto consulta medica de la negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class ConsultaMedica implements VOConsultaMedica
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de los consulta medicaes
	 */
	private long id;
	
	/**
	 * El tipo de la consulta medica
	 */
	private String tipo;

	/**
	 * La dolencia donde se encuentra el consulta medica
	 */
	private String dolencia;
	
	/**
	 * El receta de la consulta medica (ALTO, MEDIO, BAJO)
	 */
	private Receta receta;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public ConsultaMedica() 
    {
    	this.id = 0;
		this.tipo = "";
		this.dolencia = "";
		this.receta = "";
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la consulta medicat
	 * @param tipo - El tipo de la consulta medica
	 * @param dolencia - La dolencia de la consulta medica
	 * @param receta - El receta de la consulta medica (ALTO, MEDIO, BAJO)
	 * @param cantSedes - Las sedes de la consulta medica (Mayor que 0)
	 */
    public ConsultaMedica(long id, String tipo, String dolencia, String receta, int cantSedes) 
    {
    	this.id = id;
		this.tipo = tipo;
		this.dolencia = dolencia;
		this.receta = receta;
	}

    /**
	 * @return El id de la consulta medica
	 */
	public long getId() 
	{
		return id;
	}
	
	/**
	 * @param id - El nuevo id de la consulta medica
	 */
	public void setId(long id) 
	{
		this.id = id;
	}
	
	/**
	 * @return el tipo de la consulta medica
	 */
	public String getTipo() 
	{
		return tipo;
	}
	
	/**
	 * @param tipo El nuevo tipo de la consulta medica
	 */
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	
	/**
	 * @return la dolencia de la consulta medica
	 */
	public String getDolencia() 
	{
		return dolencia;
	}
	
	/**
	 * @param dolencia - La nueva dolencia de la consulta medica
	 */
	public void setDolencia(String dolencia) 
	{
		this.dolencia = dolencia;
	}
	
	/**
	 * @return La receta de la consulta medica
	 */
	public Receta getReceta() 
	{
		return receta;
	}
	
	/**
	 * @param receta - La nueva receta de la consulta medica 
	 */
	public void setReceta(Receta receta) 
	{
		this.receta = receta;
	}
	
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la consulta medica
	 */
	public String toString() 
	{
		return "consulta medica [id=" + id + ", tipo=" + tipo + ", dolencia=" + dolencia + ", receta=" + receta
				+ ", cantSedes=" + cantSedes + "]";
	}
	

}
