package uniandes.isis2304.epsandes.negocio;

import java.sql.Timestamp;

public interface VOUsan {

	public long getIdUsuario();

	public long getIdServSalud();

	public Timestamp getFechaReserva();

	public Timestamp getFechaAtencion();

	public long getIdRecepcionista();

	public int getEstado();
	
	public long getIdOrden();

	@Override
	public String toString();
}
