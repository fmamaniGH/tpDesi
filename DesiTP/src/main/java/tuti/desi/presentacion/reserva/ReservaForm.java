package tuti.desi.presentacion.reserva;

public class ReservaForm {

	private String dni;
	private Long idVuelo;
	private Long asiento;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Long getVueloId() {
		return idVuelo;
	}

	public void setVueloId(Long vueloId) {
		this.idVuelo = vueloId;
	}

	public Long getAsiento() {
		return asiento;
	}

	public void setAsiento(Long asiento) {
		this.asiento = asiento;
	}
}
