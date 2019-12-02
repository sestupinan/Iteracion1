package uniandes.isis2304.epsandes.negocio;

public class Reservan implements VOReservan{
	
	public long idServSalud;
	
	public long idCampaniaPrev;

	public int cantidadreservados;
	
	public Reservan(long idServSalud, long idCampaniaPrev) {
		
		this.idServSalud = idServSalud;
		this.idCampaniaPrev = idCampaniaPrev;
	}

	
	public long getIdServSalud() {
		return idServSalud;
	}


	public void setIdServSalud(long idServSalud) {
		this.idServSalud = idServSalud;
	}



	public long getIdCampaniaPrev() {
		return idCampaniaPrev;
	}



	public void setIdCampaniaPrev(long idCampaniaPrev) {
		this.idCampaniaPrev = idCampaniaPrev;
	}



	public int getCantidadreservados() {
		return cantidadreservados;
	}



	public void setCantidadreservados(int cantidadreservados) {
		this.cantidadreservados = cantidadreservados;
	}


	@Override
	public String toString() {
		return "Reservan [idServSalud=" + idServSalud + ", idCampaniaPrev=" + idCampaniaPrev + ", cantidadreservados="
				+ cantidadreservados + "]";
	}
	

}
