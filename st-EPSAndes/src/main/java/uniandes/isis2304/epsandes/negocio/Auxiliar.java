package uniandes.isis2304.epsandes.negocio;

import java.math.BigDecimal;

import oracle.sql.TIMESTAMP;

public class Auxiliar {

	public BigDecimal nidentificacion;
	public String nombre;
	public String tipoid;
	public TIMESTAMP fechanacimiento;
	public BigDecimal c;
	
	public Auxiliar(BigDecimal nidentificacion, String nombre, String tipoid, TIMESTAMP fechanacimiento, BigDecimal c) {
		this.nidentificacion = nidentificacion;
		this.nombre = nombre;
		this.tipoid = tipoid;
		this.fechanacimiento = fechanacimiento;
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "El afiliado tiene id: " + this.nidentificacion + " y usa " + this.c + " servicios.";
	}
	
	public BigDecimal getNidentificacion() {
		return nidentificacion;
	}
	public void setNidentificacion(BigDecimal nidentificacion) {
		this.nidentificacion = nidentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoid() {
		return tipoid;
	}
	public void setTipoid(String tipoid) {
		this.tipoid = tipoid;
	}
	public TIMESTAMP getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(TIMESTAMP fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public BigDecimal getC() {
		return c;
	}
	public void setC(BigDecimal c) {
		this.c = c;
	}
	public BigDecimal getN() {
		return n;
	}
	public void setN(BigDecimal n) {
		this.n = n;
	}
	public BigDecimal n;
	
	
}
