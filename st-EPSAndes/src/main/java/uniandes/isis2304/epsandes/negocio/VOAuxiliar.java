package uniandes.isis2304.epsandes.negocio;

import java.math.BigDecimal;

import oracle.sql.TIMESTAMP;

public interface VOAuxiliar {

	@Override
	public String toString();
	
	public BigDecimal getNidentificacion();
	
	public String getNombre();
	
	public String getTipoid();
	
	public TIMESTAMP getFechanacimiento();
	
	public BigDecimal getC();
	
	public BigDecimal getN();
}
